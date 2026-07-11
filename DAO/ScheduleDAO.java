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
import model.Schedule;
import util.DBConnection;

public class ScheduleDAO implements CrudDAO<Schedule> {

    private static final Logger LOGGER = Logger.getLogger(ScheduleDAO.class.getName());

    // Mapping satu baris ResultSet menjadi objek Schedule (dipakai getAll & findById)
    private Schedule mapResultSetToSchedule(ResultSet rs) throws SQLException {
        return new Schedule(
                rs.getInt("scheduleID"),
                rs.getInt("boatID"),
                rs.getInt("routeID"),
                rs.getString("departureDate"),
                rs.getString("departureTime"),
                rs.getInt("availableSeats")
        );
    }

    // Create
    @Override
    public int insert(Schedule schedule) {

        String sql = "INSERT INTO schedules (boatID, routeID, departureDate, departureTime, availableSeats, createdAt) VALUES (?,?,?,?,?,NOW())";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, schedule.getBoatID());
            stmt.setInt(2, schedule.getRouteID());
            stmt.setString(3, schedule.getDepartureDate());
            stmt.setString(4, schedule.getDepartureTime());
            stmt.setInt(5, schedule.getAvailableSeats());

            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {

                if (generatedKeys.next()) {
                    int scheduleID = generatedKeys.getInt(1);
                    schedule.setScheduleID(scheduleID);
                    return scheduleID;
                }

            }

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    // Read
    @Override
    public List<Schedule> getAll() {

        List<Schedule> schedules = new ArrayList<>();

        String sql = "SELECT * FROM schedules";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                schedules.add(mapResultSetToSchedule(rs));
            }

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }

        return schedules;
    }

    // Cari schedule berdasarkan ID
    public Schedule findById(int scheduleID) {

        String sql = "SELECT * FROM schedules WHERE scheduleID=?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, scheduleID);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return mapResultSetToSchedule(rs);
                }

            }

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }

        return null;
    }

    // Update
    @Override
    public int update(Schedule schedule) {

        String sql = "UPDATE schedules SET boatID=?, routeID=?, departureDate=?, departureTime=?, availableSeats=? WHERE scheduleID=?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, schedule.getBoatID());
            stmt.setInt(2, schedule.getRouteID());
            stmt.setString(3, schedule.getDepartureDate());
            stmt.setString(4, schedule.getDepartureTime());
            stmt.setInt(5, schedule.getAvailableSeats());
            stmt.setInt(6, schedule.getScheduleID());

            return stmt.executeUpdate();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    // Delete
    @Override
    public int delete(int scheduleID) {

        String sql = "DELETE FROM schedules WHERE scheduleID=?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, scheduleID);

            return stmt.executeUpdate();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    // Cek apakah boat masih digunakan
    public boolean isBoatUsed(int boatID) {

        String sql = "SELECT COUNT(*) FROM schedules WHERE boatID=?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, boatID);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }

            }

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }

        return false;
    }

    // Cek apakah route masih digunakan
    public boolean isRouteUsed(int routeID) {

        String sql = "SELECT COUNT(*) FROM schedules WHERE routeID=?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, routeID);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }

            }

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }

        return false;
    }

    // Kurangi kursi tersedia
    public boolean reduceAvailableSeats(int scheduleID) {

        String sql = "UPDATE schedules SET availableSeats = availableSeats - 1 WHERE scheduleID=? AND availableSeats > 0";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, scheduleID);

            return stmt.executeUpdate() > 0;

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }

        return false;
    }

    // Tambah kembali kursi tersedia
    public boolean increaseAvailableSeats(int scheduleID) {

        String sql = "UPDATE schedules SET availableSeats = availableSeats + 1 WHERE scheduleID=?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, scheduleID);

            return stmt.executeUpdate() > 0;

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }

        return false;
    }
}