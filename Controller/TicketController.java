package controller;

import dao.RouteDAO;
import dao.ScheduleDAO;
import dao.TicketDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.PaymentStatus;
import model.Route;
import model.Schedule;
import model.Ticket;
import model.TicketStatus;
import model.TripType;

public class TicketController {

    private final TicketDAO ticketDAO;
    private final ScheduleDAO scheduleDAO;
    private final RouteDAO routeDAO;

    public TicketController() {
        this.ticketDAO = new TicketDAO();
        this.scheduleDAO = new ScheduleDAO();
        this.routeDAO = new RouteDAO();
    }

    // Konversi String menjadi TripType
    private TripType parseTripType(String tripType) {

        if (tripType == null) {
            return null;
        }

        String normalized = tripType.replace(" ", "").replace("-", "");

        if (normalized.equalsIgnoreCase("SatuArah")) {
            return TripType.SATU_ARAH;
        }

        if (normalized.equalsIgnoreCase("PergiPulang")) {
            return TripType.PERGI_PULANG;
        }

        return null;
    }

    // Hitung total harga tiket
    public double hitungTotalHarga(int routeID, String passengerType, String tripType) {

        Route route = findRouteByID(routeID);

        if (route == null) {
            return 0;
        }

        double harga = passengerType.equalsIgnoreCase("Dewasa")
                ? route.getPriceAdult()
                : route.getPriceChild();

        TripType trip = parseTripType(tripType);

        if (trip == TripType.PERGI_PULANG) {
            harga *= 2;
        }

        return harga;
    }

    // Generate kode tiket
    public String generateTicketCode() {

        String tanggal = new SimpleDateFormat("yyyyMMdd").format(new Date());

        int jumlahHariIni = 0;

        for (Ticket ticket : ticketDAO.getAll()) {

            if (ticket.getTicketCode() != null
                    && ticket.getTicketCode().contains(tanggal)) {

                jumlahHariIni++;
            }
        }

        return "TKT-" + tanggal + "-" + String.format("%03d", jumlahHariIni + 1);
    }

    // Booking tiket
    public String bookTicket(int passengerID, int scheduleID,
            String tripType, String passengerType) {

        Schedule schedule = findScheduleByID(scheduleID);

        if (schedule == null) {
            return "Jadwal tidak ditemukan.";
        }

        if (schedule.getAvailableSeats() <= 0) {
            return "Kursi untuk jadwal ini sudah habis.";
        }

        TripType trip = parseTripType(tripType);

        if (trip == null) {
            return "Jenis perjalanan tidak valid.";
        }

        double totalPrice = hitungTotalHarga(
                schedule.getRouteID(),
                passengerType,
                tripType
        );

        if (totalPrice <= 0) {
            return "Gagal menghitung harga tiket.";
        }

        String ticketCode = generateTicketCode();

        Ticket ticket = new Ticket(
                passengerID,
                scheduleID,
                ticketCode,
                trip,
                totalPrice,
                0,
                0,
                null,
                PaymentStatus.PENDING,
                TicketStatus.PENDING
        );

        int result = ticketDAO.insert(ticket);

        if (result > 0) {
            return "OK|" + ticketCode + "|" + result;
        }

        return "Gagal membuat tiket.";
    }

    // Booking lengkap
    public String bookCompleteTicket(
            String name,
            String email,
            String phone,
            String nationality,
            String passengerType,
            int scheduleID,
            String tripType,
            PassengerController passengerController) {

        String passengerResult = passengerController.findOrCreatePassenger(
                name,
                email,
                phone,
                nationality,
                passengerType
        );

        if (!passengerResult.startsWith("OK")) {
            return passengerResult;
        }

        int passengerID = Integer.parseInt(passengerResult.split("\\|")[1]);

        String ticketResult = bookTicket(
                passengerID,
                scheduleID,
                tripType,
                passengerType
        );

        if (!ticketResult.startsWith("OK")) {
            return ticketResult;
        }

        return ticketResult + "|" + passengerID;
    }

    // Pembayaran
    public String processPayment(int ticketID,
            int scheduleID,
            double totalPrice,
            double paidAmount,
            String paymentMethod) {

        if (paymentMethod == null || paymentMethod.trim().isEmpty()) {
            return "Metode pembayaran wajib dipilih.";
        }

        if (paidAmount < totalPrice) {
            return "Pembayaran kurang Rp "
                    + (totalPrice - paidAmount)
                    + ". Silakan lengkapi pembayaran.";
        }

        double changeAmount = paidAmount - totalPrice;

        int result = ticketDAO.updateTicketStatus(
                ticketID,
                TicketStatus.ACTIVE,
                PaymentStatus.PAID
        );

        if (result != 1) {
            return "Gagal memproses pembayaran.";
        }

        ticketDAO.updatePaymentInfo(
                ticketID,
                paidAmount,
                changeAmount,
                paymentMethod.trim()
        );

        scheduleDAO.reduceAvailableSeats(scheduleID);

        return "OK|" + changeAmount;
    }

    // Batalkan tiket
    public String cancelTicket(int ticketID, int scheduleID) {

        int result = ticketDAO.updateTicketStatus(
                ticketID,
                TicketStatus.CANCELLED,
                PaymentStatus.CANCELLED
        );

        if (result > 0) {
            scheduleDAO.increaseAvailableSeats(scheduleID);
            return "OK";
        }

        return "Gagal membatalkan tiket.";
    }

    // Gunakan tiket
    public String useTicket(int ticketID) {

        int result = ticketDAO.updateTicketStatus(
                ticketID,
                TicketStatus.USED,
                PaymentStatus.PAID
        );

        if (result > 0) {
            return "OK";
        }

        return "Gagal memperbarui status tiket.";
    }

    // Semua tiket
    public List<Ticket> getAllTickets() {
        return ticketDAO.getAll();
    }

    // Helper
    private Schedule findScheduleByID(int scheduleID) {
        return scheduleDAO.findById(scheduleID);
    }

    private Route findRouteByID(int routeID) {
        return routeDAO.findById(routeID);
    }

}