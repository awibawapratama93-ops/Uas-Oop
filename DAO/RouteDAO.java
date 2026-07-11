package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Route;
import util.DBConnection;

public class RouteDAO implements CrudDAO<Route> {

    private static final Logger LOGGER = Logger.getLogger(RouteDAO.class.getName());

    // Mapping satu baris ResultSet menjadi objek Route (dipakai getAll & findById)
    private Route mapResultSetToRoute(ResultSet rs) throws SQLException {
        return new Route(
                rs.getInt("routeID"),
                rs.getString("origin"),
                rs.getString("destination"),
                rs.getDouble("priceAdult"),
                rs.getDouble("priceChild")
        );
    }

    // Create
    @Override
    public int insert(Route route) {
        String sql = "INSERT INTO routes (origin, destination, priceAdult, priceChild, createdAt) VALUES (?,?,?,?,NOW())";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, route.getOrigin());
            stmt.setString(2, route.getDestination());
            stmt.setDouble(3, route.getPriceAdult());
            stmt.setDouble(4, route.getPriceChild());

            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {

                if (generatedKeys.next()) {
                    int routeID = generatedKeys.getInt(1);
                    route.setRouteID(routeID);
                    return routeID;
                }

            }

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    // Read
    @Override
    public List<Route> getAll() {
        List<Route> routes = new ArrayList<>();

        String sql = "SELECT * FROM routes";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                routes.add(mapResultSetToRoute(rs));
            }

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }

        return routes;
    }

    // Cari berdasarkan ID
    public Route findById(int routeID) {

        String sql = "SELECT * FROM routes WHERE routeID=?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, routeID);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return mapResultSetToRoute(rs);
                }

            }

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }

        return null;
    }

    // Update
    @Override
    public int update(Route route) {

        String sql = "UPDATE routes SET origin=?, destination=?, priceAdult=?, priceChild=? WHERE routeID=?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, route.getOrigin());
            stmt.setString(2, route.getDestination());
            stmt.setDouble(3, route.getPriceAdult());
            stmt.setDouble(4, route.getPriceChild());
            stmt.setInt(5, route.getRouteID());

            return stmt.executeUpdate();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    // Delete
    @Override
    public int delete(int routeID) {

        String sql = "DELETE FROM routes WHERE routeID=?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, routeID);

            return stmt.executeUpdate();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }

        return 0;
    }
}