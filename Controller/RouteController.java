package controller;

import dao.RouteDAO;
import dao.ScheduleDAO;
import java.util.List;
import model.Route;

public class RouteController {

    private final RouteDAO routeDAO;
    private final ScheduleDAO scheduleDAO;

    public RouteController() {
        this.routeDAO = new RouteDAO();
        this.scheduleDAO = new ScheduleDAO();
    }

    // Tambah rute
    public String addRoute(String origin, String destination, double priceAdult, double priceChild) {

        StringBuilder errors = new StringBuilder();

        if (origin == null || origin.trim().isEmpty()) {
            errors.append("- Kota/pulau asal wajib diisi.\n");
        }

        if (destination == null || destination.trim().isEmpty()) {
            errors.append("- Kota/pulau tujuan wajib diisi.\n");
        }

        if (origin != null && destination != null
                && origin.trim().equalsIgnoreCase(destination.trim())) {
            errors.append("- Asal dan tujuan tidak boleh sama.\n");
        }

        if (priceAdult <= 0) {
            errors.append("- Harga dewasa harus lebih dari 0.\n");
        }

        if (priceChild <= 0) {
            errors.append("- Harga anak harus lebih dari 0.\n");
        }

        if (priceAdult > 0 && priceChild > priceAdult) {
            errors.append("- Harga anak tidak boleh lebih mahal dari harga dewasa.\n");
        }

        if (errors.length() > 0) {
            return errors.toString();
        }

        Route route = new Route(
                origin.trim(),
                destination.trim(),
                priceAdult,
                priceChild
        );

        int result = routeDAO.insert(route);

        if (result > 0) {
            return "OK|" + result;
        }

        return "Gagal menambah rute.";
    }

    // Update rute
    public String updateRoute(int routeID, String origin, String destination,
                              double priceAdult, double priceChild) {

        StringBuilder errors = new StringBuilder();

        if (origin == null || origin.trim().isEmpty()) {
            errors.append("- Kota/pulau asal wajib diisi.\n");
        }

        if (destination == null || destination.trim().isEmpty()) {
            errors.append("- Kota/pulau tujuan wajib diisi.\n");
        }

        if (origin != null && destination != null
                && origin.trim().equalsIgnoreCase(destination.trim())) {
            errors.append("- Asal dan tujuan tidak boleh sama.\n");
        }

        if (priceAdult <= 0) {
            errors.append("- Harga dewasa harus lebih dari 0.\n");
        }

        if (priceChild <= 0) {
            errors.append("- Harga anak harus lebih dari 0.\n");
        }

        if (priceAdult > 0 && priceChild > priceAdult) {
            errors.append("- Harga anak tidak boleh lebih mahal dari harga dewasa.\n");
        }

        if (errors.length() > 0) {
            return errors.toString();
        }

        Route route = new Route(
                routeID,
                origin.trim(),
                destination.trim(),
                priceAdult,
                priceChild
        );

        int result = routeDAO.update(route);

        if (result > 0) {
            return "OK";
        }

        return "Gagal memperbarui rute.";
    }

    // Hapus rute
    public String deleteRoute(int routeID) {

        if (scheduleDAO.isRouteUsed(routeID)) {
            return "Rute tidak dapat dihapus karena masih digunakan pada jadwal.";
        }

        int result = routeDAO.delete(routeID);

        if (result > 0) {
            return "OK";
        }

        return "Gagal menghapus rute.";
    }

    // Ambil semua data rute
    public List<Route> getAllRoutes() {
        return routeDAO.getAll();
    }

}