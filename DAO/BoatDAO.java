package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Boat;
import util.DBConnection;

public class BoatDAO {
    private Connection connection;

    public BoatDAO() {
        try {
            connection = DBConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(BoatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Create
    public int insertBoat(Boat boat) {
        try {
            String sql = "INSERT INTO boats (boatName, boatType, capacity, createdAt) VALUES (?,?,?,NOW())";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, boat.getBoatName());
            stmt.setString(2, boat.getBoatType());
            stmt.setInt(3, boat.getCapacity());
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println("Error insert: " + e.getMessage());
            return 0;
        }
    }

    // Read
    public List<Boat> getBoats() {
        List<Boat> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM boats";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Boat b = new Boat(
                    rs.getInt("boatID"),
                    rs.getString("boatName"),
                    rs.getString("boatType"),
                    rs.getInt("capacity")
                );
                list.add(b);
            }
        } catch (SQLException e) {
            Logger.getLogger(BoatDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    // Update
    public int updateBoat(Boat boat) {
        try {
            String sql = "UPDATE boats SET boatName=?, boatType=?, capacity=? WHERE boatID=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, boat.getBoatName());
            stmt.setString(2, boat.getBoatType());
            stmt.setInt(3, boat.getCapacity());
            stmt.setInt(4, boat.getBoatID());
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println("Error update: " + e.getMessage());
            return 0;
        }
    }

    // Delete
    public int deleteBoat(int boatID) {
        try {
            String sql = "DELETE FROM boats WHERE boatID=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, boatID);
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println("Error delete: " + e.getMessage());
            return 0;
        }
    }
}