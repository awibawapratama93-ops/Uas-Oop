package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Ticket;
import util.DBConnection;

public class TicketDAO {
    private Connection connection;

    public TicketDAO() {
        try {
            connection = DBConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Create
    public int insertTicket(Ticket ticket) {
        try {
            String sql = "INSERT INTO tickets (passengerID, scheduleID, ticketCode, tripType, totalPrice, paidAmount, changeAmount, paymentMethod, paymentStatus, ticketStatus, createdAt) VALUES (?,?,?,?,?,?,?,?,?,?,NOW())";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, ticket.getPassengerID());
            stmt.setInt(2, ticket.getScheduleID());
            stmt.setString(3, ticket.getTicketCode());
            stmt.setString(4, ticket.getTripType());
            stmt.setDouble(5, ticket.getTotalPrice());
            stmt.setDouble(6, ticket.getPaidAmount());
            stmt.setDouble(7, ticket.getChangeAmount());
            stmt.setString(8, ticket.getPaymentMethod());
            stmt.setString(9, ticket.getPaymentStatus());
            stmt.setString(10, ticket.getTicketStatus());
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println("Error insert: " + e.getMessage());
            return 0;
        }
    }

    // Read
    public List<Ticket> getTickets() {
        List<Ticket> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tickets";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Ticket t = new Ticket(
                    rs.getInt("ticketID"),
                    rs.getInt("passengerID"),
                    rs.getInt("scheduleID"),
                    rs.getString("ticketCode"),
                    rs.getString("tripType"),
                    rs.getDouble("totalPrice"),
                    rs.getDouble("paidAmount"),
                    rs.getDouble("changeAmount"),
                    rs.getString("paymentMethod"),
                    rs.getString("paymentStatus"),
                    rs.getString("ticketStatus")
                );
                list.add(t);
            }
        } catch (SQLException e) {
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    // Update status tiket
    public int updateTicketStatus(int ticketID, String ticketStatus, String paymentStatus) {
        try {
            String sql = "UPDATE tickets SET ticketStatus=?, paymentStatus=? WHERE ticketID=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, ticketStatus);
            stmt.setString(2, paymentStatus);
            stmt.setInt(3, ticketID);
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println("Error update: " + e.getMessage());
            return 0;
        }
    }

    // Delete
    public int deleteTicket(int ticketID) {
        try {
            String sql = "DELETE FROM tickets WHERE ticketID=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, ticketID);
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println("Error delete: " + e.getMessage());
            return 0;
        }
    }
    
    // Cek apakah passenger masih punya tiket (untuk validasi sebelum delete passenger)
    public boolean isPassengerUsed(int passengerID) {
        try {
            String sql = "SELECT COUNT(*) FROM tickets WHERE passengerID=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, passengerID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            Logger.getLogger(TicketDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
}