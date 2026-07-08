package controller;

import dao.PassengerDAO;
import dao.TicketDAO;
import model.Passenger;
import model.PassengerType;
import java.util.List;

public class PassengerController {
    private final PassengerDAO passengerDAO;
    private final TicketDAO ticketDAO;

    public PassengerController() {
        passengerDAO = new PassengerDAO();
        ticketDAO = new TicketDAO();
    }
    
// Konversi String dari View (combo box) menjadi enum PassengerType
    private PassengerType parsePassengerType(String passengerType) {
        String normalized = (passengerType == null) ? "" : passengerType.replace(" ", "").replace("-", "");
        if (normalized.equalsIgnoreCase("Dewasa")) return PassengerType.DEWASA;
        if (normalized.equalsIgnoreCase("Anakanak")) return PassengerType.ANAK_ANAK;
        return null;
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

        Passenger passenger = new Passenger(name, email, phone, nationality, parsePassengerType(passengerType));
        int result = passengerDAO.insert(passenger);
        return (result > 0) ? "OK|" + result : "Gagal menambah data penumpang.";
    }
    
// Cari passenger berdasarkan email; kalau belum ada, buat baru.
// Dipakai khusus untuk alur booking supaya tidak membuat data penumpang duplikat.
public String findOrCreatePassenger(String name, String email, String phone, String nationality, String passengerType) {
    Passenger existing = passengerDAO.findByEmail(email);

    if (existing != null) {
        // Passenger sudah ada, langsung pakai ID lama
        return "OK|" + existing.getPassengerID();
    }

    // Belum ada, buat baru (pakai validasi & insert yang sudah ada)
    return addPassenger(name, email, phone, nationality, passengerType);
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

        Passenger passenger = new Passenger(passengerID, name, email, phone, nationality, parsePassengerType(passengerType));
        int result = passengerDAO.update(passenger);
        return (result == 1) ? "OK" : "Gagal update data penumpang.";
    }

    // Hapus penumpang dengan validasi (cek dulu apakah sudah punya tiket)
    public String deletePassenger(int passengerID) {
        if (ticketDAO.isPassengerUsed(passengerID)) {
            return "Penumpang tidak bisa dihapus karena sudah memiliki riwayat tiket.";
        }
        int result = passengerDAO.delete(passengerID);
        return (result == 1) ? "OK" : "Gagal menghapus data penumpang.";
    }

    // Ambil semua data penumpang
    public List<Passenger> getAllPassengers() {
        return passengerDAO.getAll();
    }
    
    public Passenger getPassengerByEmail(String email) {
        return passengerDAO.findByEmail(email);
    }
    
}