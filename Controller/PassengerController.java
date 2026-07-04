package controller;

import dao.PassengerDAO;
import dao.TicketDAO;
import model.Passenger;
import java.util.List;

public class PassengerController {
    private PassengerDAO passengerDAO;
    private TicketDAO ticketDAO;

    public PassengerController() {
        passengerDAO = new PassengerDAO();
        ticketDAO = new TicketDAO();
    }

    // Tambah penumpang dengan validasi
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
        String normalizedType = (passengerType == null) ? "" : passengerType.replace(" ", "").replace("-", "");
        if (!(normalizedType.equalsIgnoreCase("Dewasa") || normalizedType.equalsIgnoreCase("Anakanak"))) {
        errors.append("- Tipe penumpang harus Dewasa atau Anak-anak.\n");
        }

        if (errors.length() > 0) {
            return errors.toString();
        }

        Passenger passenger = new Passenger(name, email, phone, nationality, passengerType);
        int result = passengerDAO.insertPassenger(passenger);
        return (result == 1) ? "OK" : "Gagal menambah data penumpang.";
    }

    // Update penumpang dengan validasi
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
        String normalizedType = (passengerType == null) ? "" : passengerType.replace(" ", "").replace("-", "");
        if (!(normalizedType.equalsIgnoreCase("Dewasa") || normalizedType.equalsIgnoreCase("Anakanak"))) {
        errors.append("- Tipe penumpang harus Dewasa atau Anak-anak.\n");
        }

        if (errors.length() > 0) {
            return errors.toString();
        }

        Passenger passenger = new Passenger(passengerID, name, email, phone, nationality, passengerType);
        int result = passengerDAO.updatePassenger(passenger);
        return (result == 1) ? "OK" : "Gagal update data penumpang.";
    }

    // Hapus penumpang dengan validasi (cek dulu apakah sudah punya tiket)
    public String deletePassenger(int passengerID) {
        if (ticketDAO.isPassengerUsed(passengerID)) {
            return "Penumpang tidak bisa dihapus karena sudah memiliki riwayat tiket.";
        }
        int result = passengerDAO.deletePassenger(passengerID);
        return (result == 1) ? "OK" : "Gagal menghapus data penumpang.";
    }

    // Ambil semua data penumpang
    public List<Passenger> getAllPassengers() {
        return passengerDAO.getPassengers();
    }
}