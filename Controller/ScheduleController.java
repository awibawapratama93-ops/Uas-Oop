package controller;

import dao.BoatDAO;
import dao.RouteDAO;
import dao.ScheduleDAO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Boat;
import model.Route;
import model.Schedule;

public class ScheduleController {

    private final ScheduleDAO scheduleDAO;
    private final BoatDAO boatDAO;
    private final RouteDAO routeDAO;

    public ScheduleController() {
        this.scheduleDAO = new ScheduleDAO();
        this.boatDAO = new BoatDAO();
        this.routeDAO = new RouteDAO();
    }

    // Tambah jadwal
    public String addSchedule(int boatID, int routeID, String departureDate,
            String departureTime, int availableSeats) {

        StringBuilder errors = new StringBuilder();

        Boat boat = findBoatByID(boatID);
        Route route = findRouteByID(routeID);

        if (boat == null) {
            errors.append("- Kapal tidak ditemukan.\n");
        }

        if (route == null) {
            errors.append("- Rute tidak ditemukan.\n");
        }

        if (availableSeats <= 0) {
            errors.append("- Jumlah kursi tersedia harus lebih dari 0.\n");
        }

        if (boat != null && availableSeats > boat.getCapacity()) {
            errors.append("- Kursi tersedia tidak boleh melebihi kapasitas kapal (")
                    .append(boat.getCapacity())
                    .append(").\n");
        }

        if (departureDate == null || departureDate.trim().isEmpty()) {
            errors.append("- Tanggal keberangkatan wajib diisi.\n");
        } else {
            try {
                LocalDate date = LocalDate.parse(departureDate);

                if (date.isBefore(LocalDate.now())) {
                    errors.append("- Tanggal keberangkatan tidak boleh tanggal yang sudah lewat.\n");
                }

            } catch (Exception e) {
                errors.append("- Format tanggal tidak valid. Gunakan format YYYY-MM-DD.\n");
            }
        }

        if (departureTime == null || departureTime.trim().isEmpty()) {
            errors.append("- Jam keberangkatan wajib diisi.\n");
        } else if (!departureTime.matches("^([01]\\d|2[0-3]):([0-5]\\d)$")) {
            errors.append("- Format jam harus HH:MM, contoh: 08:00\n");
        }

        if (errors.length() > 0) {
            return errors.toString();
        }

        Schedule schedule = new Schedule(
                boatID,
                routeID,
                departureDate.trim(),
                departureTime.trim(),
                availableSeats
        );

        int result = scheduleDAO.insert(schedule);

        if (result > 0) {
            return "OK|" + result;
        }

        return "Gagal menambah jadwal.";
    }

    // Update jadwal
    public String updateSchedule(int scheduleID, int boatID, int routeID,
            String departureDate, String departureTime, int availableSeats) {

        StringBuilder errors = new StringBuilder();

        Boat boat = findBoatByID(boatID);
        Route route = findRouteByID(routeID);

        if (boat == null) {
            errors.append("- Kapal tidak ditemukan.\n");
        }

        if (route == null) {
            errors.append("- Rute tidak ditemukan.\n");
        }

        if (availableSeats < 0) {
            errors.append("- Jumlah kursi tersedia tidak boleh negatif.\n");
        }

        if (boat != null && availableSeats > boat.getCapacity()) {
            errors.append("- Kursi tersedia tidak boleh melebihi kapasitas kapal (")
                    .append(boat.getCapacity())
                    .append(").\n");
        }

        if (departureDate == null || departureDate.trim().isEmpty()) {
            errors.append("- Tanggal keberangkatan wajib diisi.\n");
        }

        if (departureTime == null || departureTime.trim().isEmpty()) {
            errors.append("- Jam keberangkatan wajib diisi.\n");
        } else if (!departureTime.matches("^([01]\\d|2[0-3]):([0-5]\\d)$")) {
            errors.append("- Format jam harus HH:MM, contoh: 08:00\n");
        }

        if (errors.length() > 0) {
            return errors.toString();
        }

        Schedule schedule = new Schedule(
                scheduleID,
                boatID,
                routeID,
                departureDate.trim(),
                departureTime.trim(),
                availableSeats
        );

        int result = scheduleDAO.update(schedule);

        if (result > 0) {
            return "OK";
        }

        return "Gagal memperbarui jadwal.";
    }

    // Hapus jadwal
    public String deleteSchedule(int scheduleID) {

        int result = scheduleDAO.delete(scheduleID);

        if (result > 0) {
            return "OK";
        }

        return "Gagal menghapus jadwal. Jadwal mungkin sudah dipakai pada transaksi tiket.";
    }

    // Ambil semua jadwal
    public List<Schedule> getAllSchedules() {

        List<Schedule> schedules = scheduleDAO.getAll();

        for (Schedule schedule : schedules) {
            schedule.setBoat(findBoatByID(schedule.getBoatID()));
            schedule.setRoute(findRouteByID(schedule.getRouteID()));
        }

        return schedules;
    }

    // Cari jadwal berdasarkan rute dan tanggal
    public List<Schedule> findSchedulesByRouteAndDate(int routeID, String departureDate) {

        List<Schedule> schedules = new ArrayList<>();

        for (Schedule schedule : scheduleDAO.getAll()) {

            if (schedule.getRouteID() == routeID
                    && schedule.getDepartureDate().equals(departureDate)
                    && schedule.getAvailableSeats() > 0) {

                schedule.setBoat(findBoatByID(schedule.getBoatID()));
                schedule.setRoute(findRouteByID(schedule.getRouteID()));

                schedules.add(schedule);
            }
        }

        return schedules;
    }

    // Cari satu jadwal berdasarkan ID
    public Schedule findScheduleByID(int scheduleID) {

        Schedule schedule = scheduleDAO.findById(scheduleID);

        if (schedule != null) {
            schedule.setBoat(findBoatByID(schedule.getBoatID()));
            schedule.setRoute(findRouteByID(schedule.getRouteID()));
        }

        return schedule;
    }

    // Cari kapal berdasarkan ID
    private Boat findBoatByID(int boatID) {
        return boatDAO.findById(boatID);
    }

    // Cari rute berdasarkan ID
    private Route findRouteByID(int routeID) {
        return routeDAO.findById(routeID);
    }

}