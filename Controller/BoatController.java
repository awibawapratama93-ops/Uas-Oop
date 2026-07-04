package controller;

import dao.BoatDAO;
import dao.ScheduleDAO;
import model.Boat;
import java.util.List;

public class BoatController {
    private final BoatDAO boatDAO;
    private final ScheduleDAO scheduleDAO;

    public BoatController() {
        boatDAO = new BoatDAO();
        scheduleDAO = new ScheduleDAO();
    }

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

        Boat boat = new Boat(boatName, boatType, capacity);
        int result = boatDAO.insertBoat(boat);
        return (result == 1) ? "OK" : "Gagal menambah kapal. Nama kapal mungkin sudah dipakai.";
    }

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

        Boat boat = new Boat(boatID, boatName, boatType, capacity);
        int result = boatDAO.updateBoat(boat);
        return (result == 1) ? "OK" : "Gagal update kapal.";
    }

    public String deleteBoat(int boatID) {
        if (scheduleDAO.isBoatUsed(boatID)) {
            return "Kapal tidak bisa dihapus karena masih digunakan pada jadwal.";
        }
        int result = boatDAO.deleteBoat(boatID);
        return (result == 1) ? "OK" : "Gagal menghapus kapal.";
    }

    public List<Boat> getAllBoats() {
        return boatDAO.getBoats();
    }
}