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
import model.TicketStatus;
import model.PaymentStatus;

public class TicketController {
    private final TicketDAO ticketDAO;
    private final ScheduleDAO scheduleDAO;
    private final RouteDAO routeDAO;

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

        String normalizedTripType = tripType.replace(" ", "").replace("-", "");
        if (normalizedTripType.equalsIgnoreCase("PergiPulang")) {
        harga = harga * 2;
        }
        return harga;
    }

    // ================= STEP 3: Generate kode tiket unik =================
    public String generateTicketCode() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String tanggal = sdf.format(new Date());

        int jumlahHariIni = 0;
        for (Ticket t : ticketDAO.getAll()) {
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
                PaymentStatus.PENDING,
                TicketStatus.PENDING
        );

        int result = ticketDAO.insert(ticket);
        return (result > 0) ? "OK|" + ticketCode + "|" + result : "Gagal membuat tiket.";
    }

    // ================= Booking lengkap: cari/buat passenger + buat tiket sekaligus =================
// Method ini menggabungkan proses yang sebelumnya tersebar di View, supaya orkestrasi bisnis
// logic ada di Controller (bukan di View) dan passenger tidak dobel dibuat untuk email yang sama.
public String bookCompleteTicket(String name, String email, String phone, String nationality,
                                   String passengerType, int scheduleID, String tripType,
                                   PassengerController passengerController) {

    // 1. Cari passenger existing (by email) atau buat baru kalau belum ada
    String resultPassenger = passengerController.findOrCreatePassenger(name, email, phone, nationality, passengerType);
    if (!resultPassenger.startsWith("OK")) {
        return resultPassenger; // pesan error validasi passenger diteruskan apa adanya
    }
    int passengerID = Integer.parseInt(resultPassenger.split("\\|")[1]);

    // 2. Buat tiket dengan status Pending
    String resultTicket = bookTicket(passengerID, scheduleID, tripType, passengerType);
    if (!resultTicket.startsWith("OK")) {
        return resultTicket; // pesan error dari bookTicket diteruskan apa adanya
    }

    // 3. Gabungkan hasil: passengerID + (kode tiket + ticketID dari bookTicket)
    // Format resultTicket sekarang: "OK|TKT-xxxx|7" -> kita tambahkan passengerID di akhir
    return resultTicket + "|" + passengerID;
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
        int result = ticketDAO.updateTicketStatus(ticketID, TicketStatus.ACTIVE, PaymentStatus.PAID);
        if (result != 1) {
            return "Gagal memproses pembayaran.";
        }

        // Kurangi kursi tersedia di jadwal
        scheduleDAO.reduceAvailableSeats(scheduleID);

        return "OK|" + changeAmount; // kembalian dikirim ke View untuk ditampilkan
    }

    // ================= Batalkan tiket =================
    public String cancelTicket(int ticketID, int scheduleID) {
        int result = ticketDAO.updateTicketStatus(ticketID, TicketStatus.CANCELLED, PaymentStatus.CANCELLED);
        if (result == 1) {
            scheduleDAO.increaseAvailableSeats(scheduleID);
            return "OK";
        }
        return "Gagal membatalkan tiket.";
    }

    // ================= Tandai tiket sebagai sudah dipakai =================
    public String useTicket(int ticketID) {
        int result = ticketDAO.updateTicketStatus(ticketID, TicketStatus.USED, PaymentStatus.PAID);
        return (result == 1) ? "OK" : "Gagal update status tiket.";
    }

    // ================= Riwayat tiket =================
    public List<Ticket> getAllTickets() {
        return ticketDAO.getAll();
    }

    // ================= Helper =================
    private Schedule findScheduleByID(int scheduleID) {
        for (Schedule s : scheduleDAO.getAll()) {
            if (s.getScheduleID() == scheduleID) return s;
        }
        return null;
    }

    private Route findRouteByID(int routeID) {
        for (Route r : routeDAO.getAll()) {
            if (r.getRouteID() == routeID) return r;
        }
        return null;
    }
}