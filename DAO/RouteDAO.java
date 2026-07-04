package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Route;
import util.DBConnection;

public class RouteDAO {
    private Connection connection;

    public RouteDAO() {
        try {
            connection = DBConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(RouteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Create
    public int insertRoute(Route route) {
        try {
            String sql = "INSERT INTO routes (origin, destination, priceAdult, priceChild, createdAt) VALUES (?,?,?,?,NOW())";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, route.getOrigin());
            stmt.setString(2, route.getDestination());
            stmt.setDouble(3, route.getPriceAdult());
            stmt.setDouble(4, route.getPriceChild());
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println("Error insert: " + e.getMessage());
            return 0;
        }
    }

    // Read
    public List<Route> getRoutes() {
        List<Route> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM routes";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Route r = new Route(
                    rs.getInt("routeID"),
                    rs.getString("origin"),
                    rs.getString("destination"),
                    rs.getDouble("priceAdult"),
                    rs.getDouble("priceChild")
                );
                list.add(r);
            }
        } catch (SQLException e) {
            Logger.getLogger(RouteDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    // Update
    public int updateRoute(Route route) {
        try {
            String sql = "UPDATE routes SET origin=?, destination=?, priceAdult=?, priceChild=? WHERE routeID=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, route.getOrigin());
            stmt.setString(2, route.getDestination());
            stmt.setDouble(3, route.getPriceAdult());
            stmt.setDouble(4, route.getPriceChild());
            stmt.setInt(5, route.getRouteID());
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println("Error update: " + e.getMessage());
            return 0;
        }
    }

    // Delete
    public int deleteRoute(int routeID) {
        try {
            String sql = "DELETE FROM routes WHERE routeID=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, routeID);
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println("Error delete: " + e.getMessage());
            return 0;
        }
    }
}