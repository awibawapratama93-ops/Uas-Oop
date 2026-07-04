package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Schedule;
import util.DBConnection;

public class ScheduleDAO {
    private Connection connection;

    public ScheduleDAO() {
        try {
            connection = DBConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Create
    public int insertSchedule(Schedule schedule) {
        try {
            String sql = "INSERT INTO schedules (boatID, routeID, departureDate, departureTime, availableSeats, createdAt) VALUES (?,?,?,?,?,NOW())";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, schedule.getBoatID());
            stmt.setInt(2, schedule.getRouteID());
            stmt.setString(3, schedule.getDepartureDate());
            stmt.setString(4, schedule.getDepartureTime());
            stmt.setInt(5, schedule.getAvailableSeats());
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println("Error insert: " + e.getMessage());
            return 0;
        }
    }

    // Read
    public List<Schedule> getSchedules() {
        List<Schedule> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM schedules";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Schedule s = new Schedule(
                    rs.getInt("scheduleID"),
                    rs.getInt("boatID"),
                    rs.getInt("routeID"),
                    rs.getString("departureDate"),
                    rs.getString("departureTime"),
                    rs.getInt("availableSeats")
                );
                list.add(s);
            }
        } catch (SQLException e) {
            Logger.getLogger(ScheduleDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    // Update
    public int updateSchedule(Schedule schedule) {
        try {
            String sql = "UPDATE schedules SET boatID=?, routeID=?, departureDate=?, departureTime=?, availableSeats=? WHERE scheduleID=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, schedule.getBoatID());
            stmt.setInt(2, schedule.getRouteID());
            stmt.setString(3, schedule.getDepartureDate());
            stmt.setString(4, schedule.getDepartureTime());
            stmt.setInt(5, schedule.getAvailableSeats());
            stmt.setInt(6, schedule.getScheduleID());
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println("Error update: " + e.getMessage());
            return 0;
        }
    }

    // Delete
    public int deleteSchedule(int scheduleID) {
        try {
            String sql = "DELETE FROM schedules WHERE scheduleID=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, scheduleID);
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println("Error delete: " + e.getMessage());
            return 0;
        }
    }
    
    // Cek apakah boat masih dipakai di schedule (untuk validasi sebelum delete boat)
    public boolean isBoatUsed(int boatID) {
        try {
            String sql = "SELECT COUNT(*) FROM schedules WHERE boatID=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, boatID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            Logger.getLogger(ScheduleDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    // Cek apakah route masih dipakai di schedule (dipakai nanti untuk RouteController)
    public boolean isRouteUsed(int routeID) {
        try {
            String sql = "SELECT COUNT(*) FROM schedules WHERE routeID=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, routeID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            Logger.getLogger(ScheduleDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
    // Kurangi kursi tersedia saat tiket dibayar (Paid)
    public boolean reduceAvailableSeats(int scheduleID) {
        try {
            String sql = "UPDATE schedules SET availableSeats = availableSeats - 1 WHERE scheduleID=? AND availableSeats > 0";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, scheduleID);
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            Logger.getLogger(ScheduleDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    // Kembalikan kursi saat tiket dibatalkan (Cancelled)
    public boolean increaseAvailableSeats(int scheduleID) {
        try {
            String sql = "UPDATE schedules SET availableSeats = availableSeats + 1 WHERE scheduleID=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, scheduleID);
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            Logger.getLogger(ScheduleDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
}