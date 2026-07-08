package controller;

import dao.ScheduleDAO;
import dao.BoatDAO;
import dao.RouteDAO;
import model.Schedule;
import model.Boat;
import model.Route;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ScheduleController {
    private final ScheduleDAO scheduleDAO;
    private final BoatDAO boatDAO;
    private final RouteDAO routeDAO;

    public ScheduleController() {
        scheduleDAO = new ScheduleDAO();
        boatDAO = new BoatDAO();
        routeDAO = new RouteDAO();
    }

    public String addSchedule(int boatID, int routeID, String departureDate, String departureTime, int availableSeats) {
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
            errors.append("- Kursi tersedia tidak boleh melebihi kapasitas kapal (" + boat.getCapacity() + ").\n");
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

        Schedule schedule = new Schedule(boatID, routeID, departureDate, departureTime, availableSeats);
        int result = scheduleDAO.insert(schedule);
        return (result > 0) ? "OK|" + result : "Gagal menambah jadwal.";
    }

    public String updateSchedule(int scheduleID, int boatID, int routeID, String departureDate, String departureTime, int availableSeats) {
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
            errors.append("- Kursi tersedia tidak boleh melebihi kapasitas kapal (" + boat.getCapacity() + ").\n");
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

        Schedule schedule = new Schedule(scheduleID, boatID, routeID, departureDate, departureTime, availableSeats);
        int result = scheduleDAO.update(schedule);
        return (result == 1) ? "OK" : "Gagal update jadwal.";
    }

    public String deleteSchedule(int scheduleID) {
        int result = scheduleDAO.delete(scheduleID);
        return (result == 1) ? "OK" : "Gagal menghapus jadwal. Jadwal mungkin sudah dipakai pada transaksi tiket.";
    }

    public List<Schedule> getAllSchedules() {
        List<Schedule> schedules = scheduleDAO.getAll();
        for (Schedule s : schedules) {
            s.setBoat(findBoatByID(s.getBoatID()));
            s.setRoute(findRouteByID(s.getRouteID()));
        }
        return schedules;
    }

    public List<Schedule> findSchedulesByRouteAndDate(int routeID, String departureDate) {
        List<Schedule> result = new ArrayList<>();
        for (Schedule s : scheduleDAO.getAll()) {
            if (s.getRouteID() == routeID
                    && s.getDepartureDate().equals(departureDate)
                    && s.getAvailableSeats() > 0) {
                s.setBoat(findBoatByID(s.getBoatID()));
                s.setRoute(findRouteByID(s.getRouteID()));
                result.add(s);
            }
        }
        return result;
    }

    private Boat findBoatByID(int boatID) {
        for (Boat b : boatDAO.getAll()) {
            if (b.getBoatID() == boatID) return b;
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