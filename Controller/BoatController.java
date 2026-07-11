package controller;

import dao.BoatDAO;
import dao.ScheduleDAO;
import java.util.List;
import model.Boat;

public class BoatController {

    private final BoatDAO boatDAO;
    private final ScheduleDAO scheduleDAO;

    public BoatController() {
        this.boatDAO = new BoatDAO();
        this.scheduleDAO = new ScheduleDAO();
    }

    // Tambah kapal
    public String addBoat(String boatName, String boatType, int capacity) {

        StringBuilder errors = new StringBuilder();

        if (boatName == null || boatName.trim().isEmpty()) {
            errors.append("- Nama kapal wajib diisi.\n");
        }

        if (boatType == null || boatType.trim().isEmpty()) {
            errors.append("- Tipe kapal wajib diisi.\n");
        }

        if (capacity <= 0) {
            errors.append("- Kapasitas kapal harus lebih dari 0.\n");
        }

        if (errors.length() > 0) {
            return errors.toString();
        }

        Boat boat = new Boat(
                boatName.trim(),
                boatType.trim(),
                capacity
        );

        int result = boatDAO.insert(boat);

        if (result > 0) {
            return "OK|" + result;
        }

        return "Gagal menambah kapal. Nama kapal mungkin sudah dipakai.";
    }

    // Update kapal
    public String updateBoat(int boatID, String boatName, String boatType, int capacity) {

        StringBuilder errors = new StringBuilder();

        if (boatName == null || boatName.trim().isEmpty()) {
            errors.append("- Nama kapal wajib diisi.\n");
        }

        if (boatType == null || boatType.trim().isEmpty()) {
            errors.append("- Tipe kapal wajib diisi.\n");
        }

        if (capacity <= 0) {
            errors.append("- Kapasitas kapal harus lebih dari 0.\n");
        }

        if (errors.length() > 0) {
            return errors.toString();
        }

        Boat boat = new Boat(
                boatID,
                boatName.trim(),
                boatType.trim(),
                capacity
        );

        int result = boatDAO.update(boat);

        if (result > 0) {
            return "OK";
        }

        return "Gagal memperbarui data kapal.";
    }

    // Hapus kapal
    public String deleteBoat(int boatID) {

        if (scheduleDAO.isBoatUsed(boatID)) {
            return "Kapal tidak dapat dihapus karena masih digunakan pada jadwal.";
        }

        int result = boatDAO.delete(boatID);

        if (result > 0) {
            return "OK";
        }

        return "Gagal menghapus kapal.";
    }

    // Ambil semua data kapal
    public List<Boat> getAllBoats() {
        return boatDAO.getAll();
    }

}