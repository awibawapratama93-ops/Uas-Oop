package controller;

import dao.RouteDAO;
import dao.ScheduleDAO;
import model.Route;
import java.util.List;

public class RouteController {
    private final RouteDAO routeDAO;
    private final ScheduleDAO scheduleDAO;

    public RouteController() {
        routeDAO = new RouteDAO();
        scheduleDAO = new ScheduleDAO();
    }

    public String addRoute(String origin, String destination, double priceAdult, double priceChild) {
        StringBuilder errors = new StringBuilder();

        if (origin == null || origin.trim().isEmpty()) {
            errors.append("- Kota/pulau asal wajib diisi.\n");
        }
        if (destination == null || destination.trim().isEmpty()) {
            errors.append("- Kota/pulau tujuan wajib diisi.\n");
        }
        if (origin != null && destination != null && origin.equalsIgnoreCase(destination)) {
            errors.append("- Asal dan tujuan tidak boleh sama.\n");
        }
        if (priceAdult <= 0) {
            errors.append("- Harga dewasa harus lebih dari 0.\n");
        }
        if (priceChild <= 0) {
            errors.append("- Harga anak harus lebih dari 0.\n");
        }
        if (priceAdult > 0 && priceChild > 0 && priceChild > priceAdult) {
            errors.append("- Harga anak tidak boleh lebih mahal dari harga dewasa.\n");
        }

        if (errors.length() > 0) {
            return errors.toString();
        }

        Route route = new Route(origin, destination, priceAdult, priceChild);
        int result = routeDAO.insert(route);
        return (result > 0) ? "OK|" + result : "Gagal menambah rute.";
    }

    public String updateRoute(int routeID, String origin, String destination, double priceAdult, double priceChild) {
        StringBuilder errors = new StringBuilder();

        if (origin == null || origin.trim().isEmpty()) {
            errors.append("- Kota/pulau asal wajib diisi.\n");
        }
        if (destination == null || destination.trim().isEmpty()) {
            errors.append("- Kota/pulau tujuan wajib diisi.\n");
        }
        if (origin != null && destination != null && origin.equalsIgnoreCase(destination)) {
            errors.append("- Asal dan tujuan tidak boleh sama.\n");
        }
        if (priceAdult <= 0) {
            errors.append("- Harga dewasa harus lebih dari 0.\n");
        }
        if (priceChild <= 0) {
            errors.append("- Harga anak harus lebih dari 0.\n");
        }
        if (priceAdult > 0 && priceChild > 0 && priceChild > priceAdult) {
            errors.append("- Harga anak tidak boleh lebih mahal dari harga dewasa.\n");
        }

        if (errors.length() > 0) {
            return errors.toString();
        }

        Route route = new Route(routeID, origin, destination, priceAdult, priceChild);
        int result = routeDAO.update(route);
        return (result == 1) ? "OK" : "Gagal update rute.";
    }

    public String deleteRoute(int routeID) {
        if (scheduleDAO.isRouteUsed(routeID)) {
            return "Rute tidak bisa dihapus karena masih digunakan pada jadwal.";
        }
        int result = routeDAO.delete(routeID);
        return (result == 1) ? "OK" : "Gagal menghapus rute.";
    }

    public List<Route> getAllRoutes() {
        return routeDAO.getAll();
    }
}