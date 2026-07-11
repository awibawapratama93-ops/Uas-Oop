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

public class BoatDAO implements CrudDAO<Boat> {

// Mapping satu baris ResultSet menjadi objek Boat (dipakai getAll & findById)
private Boat mapResultSetToBoat(ResultSet rs) throws SQLException {
    return new Boat(
            rs.getInt("boatID"),
            rs.getString("boatName"),
            rs.getString("boatType"),
            rs.getInt("capacity")
    );
}

// Create
public int insert(Boat boat) {
    String sql = "INSERT INTO boats (boatName, boatType, capacity, createdAt) VALUES (?,?,?,NOW())";

    try (Connection connection = DBConnection.getConnection();
         PreparedStatement stmt = connection.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS)) {

        stmt.setString(1, boat.getBoatName());
        stmt.setString(2, boat.getBoatType());
        stmt.setInt(3, boat.getCapacity());

        stmt.executeUpdate();

        try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int newID = generatedKeys.getInt(1);
                boat.setBoatID(newID);
                return newID;
            }
        }

    } catch (SQLException e) {
        Logger.getLogger(BoatDAO.class.getName()).log(Level.SEVERE, null, e);
    }

    return 0;
}

// Read
public List<Boat> getAll() {
    List<Boat> list = new ArrayList<>();
    String sql = "SELECT * FROM boats";

    try (Connection connection = DBConnection.getConnection();
         PreparedStatement stmt = connection.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            list.add(mapResultSetToBoat(rs));
        }

    } catch (SQLException e) {
        Logger.getLogger(BoatDAO.class.getName()).log(Level.SEVERE, null, e);
    }

    return list;
}

// Update
public int update(Boat boat) {
    String sql = "UPDATE boats SET boatName=?, boatType=?, capacity=? WHERE boatID=?";

    try (Connection connection = DBConnection.getConnection();
         PreparedStatement stmt = connection.prepareStatement(sql)) {

        stmt.setString(1, boat.getBoatName());
        stmt.setString(2, boat.getBoatType());
        stmt.setInt(3, boat.getCapacity());
        stmt.setInt(4, boat.getBoatID());

        return stmt.executeUpdate();

    } catch (SQLException e) {
        Logger.getLogger(BoatDAO.class.getName()).log(Level.SEVERE, null, e);
    }

    return 0;
}
    
// Cari boat berdasarkan ID
public Boat findById(int boatID) {
    String sql = "SELECT * FROM boats WHERE boatID=?";

    try (Connection connection = DBConnection.getConnection();
         PreparedStatement stmt = connection.prepareStatement(sql)) {

        stmt.setInt(1, boatID);

        try (ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return mapResultSetToBoat(rs);
            }

        }

    } catch (SQLException e) {
        Logger.getLogger(BoatDAO.class.getName()).log(Level.SEVERE, null, e);
    }

    return null;
}

// Delete
public int delete(int boatID) {
    String sql = "DELETE FROM boats WHERE boatID=?";

    try (Connection connection = DBConnection.getConnection();
         PreparedStatement stmt = connection.prepareStatement(sql)) {

        stmt.setInt(1, boatID);

        return stmt.executeUpdate();

    } catch (SQLException e) {
        Logger.getLogger(BoatDAO.class.getName()).log(Level.SEVERE, null, e);
    }

    return 0;
}
}