package controller;

import dao.PassengerDAO;
import dao.TicketDAO;
import java.util.List;
import model.Passenger;
import model.PassengerType;

public class PassengerController {

    private final PassengerDAO passengerDAO;
    private final TicketDAO ticketDAO;

    public PassengerController() {
        this.passengerDAO = new PassengerDAO();
        this.ticketDAO = new TicketDAO();
    }

    // Konversi String menjadi PassengerType
    private PassengerType parsePassengerType(String passengerType) {

        if (passengerType == null) {
            return null;
        }

        String normalized = passengerType.replace(" ", "").replace("-", "");

        if (normalized.equalsIgnoreCase("Dewasa")) {
            return PassengerType.DEWASA;
        }

        if (normalized.equalsIgnoreCase("Anakanak")) {
            return PassengerType.ANAK_ANAK;
        }

        return null;
    }

    // Tambah penumpang
    public String addPassenger(String name, String email, String phone, String nationality, String passengerType) {

        StringBuilder errors = new StringBuilder();

        if (name == null || name.trim().isEmpty()) {
            errors.append("- Nama wajib diisi.\n");
        }

        if (email == null || email.trim().isEmpty()) {
            errors.append("- Email wajib diisi.\n");
        } else if (!email.contains("@") || !email.contains(".")) {
            errors.append("- Format email tidak valid.\n");
        }

        if (phone == null || phone.trim().isEmpty()) {
            errors.append("- Nomor HP wajib diisi.\n");
        }

        if (nationality == null || nationality.trim().isEmpty()) {
            errors.append("- Kewarganegaraan wajib diisi.\n");
        }

        PassengerType type = parsePassengerType(passengerType);

        if (type == null) {
            errors.append("- Tipe penumpang harus Dewasa atau Anak-anak.\n");
        }

        if (errors.length() > 0) {
            return errors.toString();
        }

        Passenger passenger = new Passenger(
                name.trim(),
                email.trim(),
                phone.trim(),
                nationality.trim(),
                type
        );

        int result = passengerDAO.insert(passenger);

        if (result > 0) {
            return "OK|" + result;
        }

        return "Gagal menambah data penumpang.";
    }

    // Cari passenger berdasarkan email, jika belum ada maka buat baru
    public String findOrCreatePassenger(String name, String email, String phone, String nationality, String passengerType) {

        Passenger passenger = passengerDAO.findByEmail(email.trim());

        if (passenger != null) {
            return "OK|" + passenger.getPassengerID();
        }

        return addPassenger(name, email, phone, nationality, passengerType);
    }

    // Update penumpang
    public String updatePassenger(int passengerID, String name, String email, String phone, String nationality, String passengerType) {

        StringBuilder errors = new StringBuilder();

        if (name == null || name.trim().isEmpty()) {
            errors.append("- Nama wajib diisi.\n");
        }

        if (email == null || email.trim().isEmpty()) {
            errors.append("- Email wajib diisi.\n");
        } else if (!email.contains("@") || !email.contains(".")) {
            errors.append("- Format email tidak valid.\n");
        }

        if (phone == null || phone.trim().isEmpty()) {
            errors.append("- Nomor HP wajib diisi.\n");
        }

        if (nationality == null || nationality.trim().isEmpty()) {
            errors.append("- Kewarganegaraan wajib diisi.\n");
        }

        PassengerType type = parsePassengerType(passengerType);

        if (type == null) {
            errors.append("- Tipe penumpang harus Dewasa atau Anak-anak.\n");
        }

        if (errors.length() > 0) {
            return errors.toString();
        }

        Passenger passenger = new Passenger(
                passengerID,
                name.trim(),
                email.trim(),
                phone.trim(),
                nationality.trim(),
                type
        );

        int result = passengerDAO.update(passenger);

        if (result > 0) {
            return "OK";
        }

        return "Gagal memperbarui data penumpang.";
    }

    // Hapus penumpang
    public String deletePassenger(int passengerID) {

        if (ticketDAO.isPassengerUsed(passengerID)) {
            return "Penumpang tidak dapat dihapus karena sudah memiliki riwayat tiket.";
        }

        int result = passengerDAO.delete(passengerID);

        if (result > 0) {
            return "OK";
        }

        return "Gagal menghapus data penumpang.";
    }

    // Ambil semua data penumpang
    public List<Passenger> getAllPassengers() {
        return passengerDAO.getAll();
    }

    // Cari penumpang berdasarkan email
    public Passenger getPassengerByEmail(String email) {

        if (email == null || email.trim().isEmpty()) {
            return null;
        }

        return passengerDAO.findByEmail(email.trim());
    }

}