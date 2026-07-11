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
import model.PaymentStatus;
import model.Ticket;
import model.TicketStatus;
import model.TripType;
import util.DBConnection;

public class TicketDAO implements CrudDAO<Ticket> {

    private static final Logger LOGGER = Logger.getLogger(TicketDAO.class.getName());

    // Create
    @Override
    public int insert(Ticket ticket) {

        String sql = "INSERT INTO tickets (passengerID, scheduleID, ticketCode, tripType, totalPrice, paidAmount, changeAmount, paymentMethod, paymentStatus, ticketStatus, createdAt) VALUES (?,?,?,?,?,?,?,?,?,?,NOW())";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, ticket.getPassengerID());
            stmt.setInt(2, ticket.getScheduleID());
            stmt.setString(3, ticket.getTicketCode());
            stmt.setString(4, ticket.getTripType().name());
            stmt.setDouble(5, ticket.getTotalPrice());
            stmt.setDouble(6, ticket.getPaidAmount());
            stmt.setDouble(7, ticket.getChangeAmount());
            stmt.setString(8, ticket.getPaymentMethod());
            stmt.setString(9, ticket.getPaymentStatus().name());
            stmt.setString(10, ticket.getTicketStatus().name());

            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {

                if (generatedKeys.next()) {
                    int ticketID = generatedKeys.getInt(1);
                    ticket.setTicketID(ticketID);
                    return ticketID;
                }

            }

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    // Read
    @Override
    public List<Ticket> getAll() {

        List<Ticket> tickets = new ArrayList<>();

        String sql = "SELECT * FROM tickets";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Ticket ticket = new Ticket(
                        rs.getInt("ticketID"),
                        rs.getInt("passengerID"),
                        rs.getInt("scheduleID"),
                        rs.getString("ticketCode"),
                        TripType.valueOf(rs.getString("tripType")),
                        rs.getDouble("totalPrice"),
                        rs.getDouble("paidAmount"),
                        rs.getDouble("changeAmount"),
                        rs.getString("paymentMethod"),
                        PaymentStatus.valueOf(rs.getString("paymentStatus")),
                        TicketStatus.valueOf(rs.getString("ticketStatus"))
                );

                tickets.add(ticket);
            }

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }

        return tickets;
    }

    // Update
    @Override
    public int update(Ticket ticket) {

        String sql = "UPDATE tickets SET passengerID=?, scheduleID=?, ticketCode=?, tripType=?, totalPrice=?, paidAmount=?, changeAmount=?, paymentMethod=?, paymentStatus=?, ticketStatus=? WHERE ticketID=?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, ticket.getPassengerID());
            stmt.setInt(2, ticket.getScheduleID());
            stmt.setString(3, ticket.getTicketCode());
            stmt.setString(4, ticket.getTripType().name());
            stmt.setDouble(5, ticket.getTotalPrice());
            stmt.setDouble(6, ticket.getPaidAmount());
            stmt.setDouble(7, ticket.getChangeAmount());
            stmt.setString(8, ticket.getPaymentMethod());
            stmt.setString(9, ticket.getPaymentStatus().name());
            stmt.setString(10, ticket.getTicketStatus().name());
            stmt.setInt(11, ticket.getTicketID());

            return stmt.executeUpdate();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    // Update status tiket
    public int updateTicketStatus(int ticketID, TicketStatus ticketStatus, PaymentStatus paymentStatus) {

        String sql = "UPDATE tickets SET ticketStatus=?, paymentStatus=? WHERE ticketID=?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, ticketStatus.name());
            stmt.setString(2, paymentStatus.name());
            stmt.setInt(3, ticketID);

            return stmt.executeUpdate();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    // Update informasi pembayaran
    public int updatePaymentInfo(int ticketID, double paidAmount, double changeAmount, String paymentMethod) {

        String sql = "UPDATE tickets SET paidAmount=?, changeAmount=?, paymentMethod=? WHERE ticketID=?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setDouble(1, paidAmount);
            stmt.setDouble(2, changeAmount);
            stmt.setString(3, paymentMethod);
            stmt.setInt(4, ticketID);

            return stmt.executeUpdate();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    // Delete
    @Override
    public int delete(int ticketID) {

        String sql = "DELETE FROM tickets WHERE ticketID=?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, ticketID);

            return stmt.executeUpdate();

        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    // Cek apakah passenger masih memiliki tiket
    public boolean isPassengerUsed(int passengerID) {

        String sql = "SELECT COUNT(*) FROM tickets WHERE passengerID=?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, passengerID);

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
}