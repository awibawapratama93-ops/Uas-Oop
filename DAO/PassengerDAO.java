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

// Mapping satu baris ResultSet menjadi objek Passenger (dipakai getAll & findByEmail)
private Passenger mapResultSetToPassenger(ResultSet rs) throws SQLException {
    return new Passenger(
            rs.getInt("passengerID"),
            rs.getString("name"),
            rs.getString("email"),
            rs.getString("phone"),
            rs.getString("nationality"),
            PassengerType.valueOf(rs.getString("passengerType"))
    );
}

// Create
public int insert(Passenger passenger) {
    String sql = "INSERT INTO passengers (name, email, phone, nationality, passengerType, createdAt) VALUES (?,?,?,?,?,NOW())";

    try (Connection connection = DBConnection.getConnection();
         PreparedStatement stmt = connection.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS)) {

        stmt.setString(1, passenger.getName());
        stmt.setString(2, passenger.getEmail());
        stmt.setString(3, passenger.getPhone());
        stmt.setString(4, passenger.getNationality());
        stmt.setString(5, passenger.getPassengerType().name());

        stmt.executeUpdate();

        try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int newID = generatedKeys.getInt(1);
                passenger.setPassengerID(newID);
                return newID;
            }
        }

    } catch (SQLException e) {
        Logger.getLogger(PassengerDAO.class.getName()).log(Level.SEVERE, null, e);
    }

    return 0;
}

// Read
public List<Passenger> getAll() {
    List<Passenger> list = new ArrayList<>();
    String sql = "SELECT * FROM passengers";

    try (Connection connection = DBConnection.getConnection();
         PreparedStatement stmt = connection.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            list.add(mapResultSetToPassenger(rs));
        }

    } catch (SQLException e) {
        Logger.getLogger(PassengerDAO.class.getName()).log(Level.SEVERE, null, e);
    }

    return list;
}

// Cari passenger berdasarkan email
public Passenger findByEmail(String email) {
    String sql = "SELECT * FROM passengers WHERE email=?";

    try (Connection connection = DBConnection.getConnection();
         PreparedStatement stmt = connection.prepareStatement(sql)) {

        stmt.setString(1, email);

        try (ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return mapResultSetToPassenger(rs);
            }

        }

    } catch (SQLException e) {
        Logger.getLogger(PassengerDAO.class.getName()).log(Level.SEVERE, null, e);
    }

    return null;
}

// Update
public int update(Passenger passenger) {
    String sql = "UPDATE passengers SET name=?, email=?, phone=?, nationality=?, passengerType=? WHERE passengerID=?";

    try (Connection connection = DBConnection.getConnection();
         PreparedStatement stmt = connection.prepareStatement(sql)) {

        stmt.setString(1, passenger.getName());
        stmt.setString(2, passenger.getEmail());
        stmt.setString(3, passenger.getPhone());
        stmt.setString(4, passenger.getNationality());
        stmt.setString(5, passenger.getPassengerType().name());
        stmt.setInt(6, passenger.getPassengerID());

        return stmt.executeUpdate();

    } catch (SQLException e) {
        Logger.getLogger(PassengerDAO.class.getName()).log(Level.SEVERE, null, e);
    }

    return 0;
}

// Delete
public int delete(int passengerID) {
    String sql = "DELETE FROM passengers WHERE passengerID=?";

    try (Connection connection = DBConnection.getConnection();
         PreparedStatement stmt = connection.prepareStatement(sql)) {

        stmt.setInt(1, passengerID);

        return stmt.executeUpdate();

    } catch (SQLException e) {
        Logger.getLogger(PassengerDAO.class.getName()).log(Level.SEVERE, null, e);
    }

    return 0;
}

}