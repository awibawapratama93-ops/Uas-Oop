package controller;

import dao.TicketDAO;
import dao.ScheduleDAO;
import dao.RouteDAO;
import model.Ticket;
import model.Schedule;
import model.Route;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TicketController {
    private TicketDAO ticketDAO;
    private ScheduleDAO scheduleDAO;
    private RouteDAO routeDAO;

    public TicketController() {
        ticketDAO = new TicketDAO();
        scheduleDAO = new ScheduleDAO();
        routeDAO = new RouteDAO();
    }

    // ================= STEP 3: Hitung total harga =================
    public double hitungTotalHarga(int routeID, String passengerType, String tripType) {
        Route route = findRouteByID(routeID);
        if (route == null) return 0;

        double harga = passengerType.equalsIgnoreCase("Dewasa")
                ? route.getPriceAdult()
                : route.getPriceChild();

        if (tripType.equalsIgnoreCase("Pergi Pulang")) {
            harga = harga * 2;
        }
        return harga;
    }

    // ================= STEP 3: Generate kode tiket unik =================
    public String generateTicketCode() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String tanggal = sdf.format(new Date());

        int jumlahHariIni = 0;
        for (Ticket t : ticketDAO.getTickets()) {
            if (t.getTicketCode() != null && t.getTicketCode().contains(tanggal)) {
                jumlahHariIni++;
            }
        }
        int nomorUrut = jumlahHariIni + 1;
        String nomorFormatted = String.format("%03d", nomorUrut);

        return "TKT-" + tanggal + "-" + nomorFormatted;
    }

    // ================= STEP 1-3: Buat booking tiket (status Pending) =================
    public String bookTicket(int passengerID, int scheduleID, String tripType, String passengerType) {
        Schedule schedule = findScheduleByID(scheduleID);
        if (schedule == null) {
            return "Jadwal tidak ditemukan.";
        }
        if (schedule.getAvailableSeats() <= 0) {
            return "Kursi untuk jadwal ini sudah habis.";
        }

        double totalPrice = hitungTotalHarga(schedule.getRouteID(), passengerType, tripType);
        if (totalPrice <= 0) {
            return "Gagal menghitung harga tiket.";
        }

        String ticketCode = generateTicketCode();

        Ticket ticket = new Ticket(
                passengerID,
                scheduleID,
                ticketCode,
                tripType,
                totalPrice,
                0,      // paidAmount
                0,      // changeAmount
                null,   // paymentMethod, diisi saat pembayaran
                "Pending",
                "Pending"
        );

        int result = ticketDAO.insertTicket(ticket);
        return (result == 1) ? "OK|" + ticketCode : "Gagal membuat tiket.";
    }

    // ================= STEP 4: Proses pembayaran =================
    public String processPayment(int ticketID, int scheduleID, double totalPrice, double paidAmount, String paymentMethod) {
        if (paymentMethod == null || paymentMethod.trim().isEmpty()) {
            return "Metode pembayaran wajib dipilih.";
        }
        if (paidAmount < totalPrice) {
            double kurang = totalPrice - paidAmount;
            return "Pembayaran kurang Rp " + kurang + ". Silakan lengkapi pembayaran.";
        }

        double changeAmount = paidAmount - totalPrice;

        // Update status tiket jadi Paid/Active
        int result = ticketDAO.updateTicketStatus(ticketID, "Active", "Paid");
        if (result != 1) {
            return "Gagal memproses pembayaran.";
        }

        // Kurangi kursi tersedia di jadwal
        scheduleDAO.reduceAvailableSeats(scheduleID);

        return "OK|" + changeAmount; // kembalian dikirim ke View untuk ditampilkan
    }

    // ================= Batalkan tiket =================
    public String cancelTicket(int ticketID, int scheduleID) {
        int result = ticketDAO.updateTicketStatus(ticketID, "Cancelled", "Cancelled");
        if (result == 1) {
            scheduleDAO.increaseAvailableSeats(scheduleID);
            return "OK";
        }
        return "Gagal membatalkan tiket.";
    }

    // ================= Tandai tiket sebagai sudah dipakai =================
    public String useTicket(int ticketID) {
        int result = ticketDAO.updateTicketStatus(ticketID, "Used", "Paid");
        return (result == 1) ? "OK" : "Gagal update status tiket.";
    }

    // ================= Riwayat tiket =================
    public List<Ticket> getAllTickets() {
        return ticketDAO.getTickets();
    }

    // ================= Helper =================
    private Schedule findScheduleByID(int scheduleID) {
        for (Schedule s : scheduleDAO.getSchedules()) {
            if (s.getScheduleID() == scheduleID) return s;
        }
        return null;
    }

    private Route findRouteByID(int routeID) {
        for (Route r : routeDAO.getRoutes()) {
            if (r.getRouteID() == routeID) return r;
        }
        return null;
    }
}
