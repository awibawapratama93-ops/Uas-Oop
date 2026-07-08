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
import model.PassengerType;
import util.DBConnection;

public class PassengerDAO implements CrudDAO<Passenger> {
    private Connection connection;

    public PassengerDAO() {
        try {
            connection = DBConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(PassengerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Create
    public int insert(Passenger passenger) {
    try {
        String sql = "INSERT INTO passengers (name, email, phone, nationality, passengerType, createdAt) VALUES (?,?,?,?,?,NOW())";
        
        // LANGKAH 1: tambahkan RETURN_GENERATED_KEYS di sini
        PreparedStatement stmt = connection.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
        
        stmt.setString(1, passenger.getName());
        stmt.setString(2, passenger.getEmail());
        stmt.setString(3, passenger.getPhone());
        stmt.setString(4, passenger.getNationality());
        stmt.setString(5, passenger.getPassengerType().name());
        stmt.executeUpdate();

        // LANGKAH 2: tambahkan blok ini setelah executeUpdate()
        ResultSet generatedKeys = stmt.getGeneratedKeys();
        if (generatedKeys.next()) {
            int newID = generatedKeys.getInt(1);
            passenger.setPassengerID(newID);
            return newID;
        }
        return 0;

    } catch (SQLException e) {
        System.out.println("Error insert: " + e.getMessage());
        return 0;
    }
}

    // Read
    public List<Passenger> getAll() {
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
                    PassengerType.valueOf(rs.getString("passengerType"))
                );
                list.add(p);
            }
        } catch (SQLException e) {
            Logger.getLogger(PassengerDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    // Cari passenger berdasarkan email (untuk cek duplikat sebelum insert baru)
public Passenger findByEmail(String email) {
    try {
        String sql = "SELECT * FROM passengers WHERE email=?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, email);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return new Passenger(
                rs.getInt("passengerID"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("phone"),
                rs.getString("nationality"),
                PassengerType.valueOf(rs.getString("passengerType"))
            );
        }
    } catch (SQLException e) {
        Logger.getLogger(PassengerDAO.class.getName()).log(Level.SEVERE, null, e);
    }
    return null; // tidak ditemukan
}

    // Update
    public int update(Passenger passenger) {
        try {
            String sql = "UPDATE passengers SET name=?, email=?, phone=?, nationality=?, passengerType=? WHERE passengerID=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, passenger.getName());
            stmt.setString(2, passenger.getEmail());
            stmt.setString(3, passenger.getPhone());
            stmt.setString(4, passenger.getNationality());
            stmt.setString(5, passenger.getPassengerType().name());
            stmt.setInt(6, passenger.getPassengerID());
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println("Error update: " + e.getMessage());
            return 0;
        }
    }

    // Delete
    public int delete(int passengerID) {
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