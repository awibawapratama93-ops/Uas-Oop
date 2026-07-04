package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import util.DBConnection;

public class UserDAO {
    private Connection connection;

    public UserDAO() {
        try {
            connection = DBConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Login
    public User login(String email, String password) {
        try {
            String sql = "SELECT * FROM users WHERE email=? AND password=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                    rs.getInt("userID"),
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("password")
                );
            }
        } catch (SQLException e) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    // Register
    public int register(User user) {
        try {
            String sql = "INSERT INTO users (username, email, password, createdAt) VALUES (?,?,?,NOW())";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println("Error register: " + e.getMessage());
            return 0;
        }
    }
}