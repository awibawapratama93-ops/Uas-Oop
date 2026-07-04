package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Passenger;
import util.DBConnection;

public class PassengerDAO {
    private Connection connection;

    public PassengerDAO() {
        try {
            connection = DBConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(PassengerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Create
    public int insertPassenger(Passenger passenger) {
        try {
            String sql = "INSERT INTO passengers (name, email, phone, nationality, passengerType, createdAt) VALUES (?,?,?,?,?,NOW())";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, passenger.getName());
            stmt.setString(2, passenger.getEmail());
            stmt.setString(3, passenger.getPhone());
            stmt.setString(4, passenger.getNationality());
            stmt.setString(5, passenger.getPassengerType());
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println("Error insert: " + e.getMessage());
            return 0;
        }
    }

    // Read
    public List<Passenger> getPassengers() {
        List<Passenger> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM passengers";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Passenger p = new Passenger(
                    rs.getInt("passengerID"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("nationality"),
                    rs.getString("passengerType")
                );
                list.add(p);
            }
        } catch (SQLException e) {
            Logger.getLogger(PassengerDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    // Update
    public int updatePassenger(Passenger passenger) {
        try {
            String sql = "UPDATE passengers SET name=?, email=?, phone=?, nationality=?, passengerType=? WHERE passengerID=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, passenger.getName());
            stmt.setString(2, passenger.getEmail());
            stmt.setString(3, passenger.getPhone());
            stmt.setString(4, passenger.getNationality());
            stmt.setString(5, passenger.getPassengerType());
            stmt.setInt(6, passenger.getPassengerID());
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println("Error update: " + e.getMessage());
            return 0;
        }
    }

    // Delete
    public int deletePassenger(int passengerID) {
        try {
            String sql = "DELETE FROM passengers WHERE passengerID=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, passengerID);
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println("Error delete: " + e.getMessage());
            return 0;
        }
    }
}