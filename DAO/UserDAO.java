package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import util.PasswordUtil;
import util.DBConnection;

public class UserDAO {

// Login
public User login(String email, String password) {
    String sql = "SELECT * FROM users WHERE email=?";

    try (Connection connection = DBConnection.getConnection();
         PreparedStatement stmt = connection.prepareStatement(sql)) {

        stmt.setString(1, email);

        try (ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                String storedHash = rs.getString("password");

                if (PasswordUtil.verifyPassword(password, storedHash)) {
                    return new User(
                            rs.getInt("userID"),
                            rs.getString("username"),
                            rs.getString("email"),
                            rs.getString("password"),
                            rs.getString("role")
                    );
                }
            }

        }

    } catch (SQLException e) {
        Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
    }

    return null;
}

// Register
public int register(User user) {
    String sql = "INSERT INTO users (username, email, password, createdAt) VALUES (?,?,?,NOW())";

    try (Connection connection = DBConnection.getConnection();
         PreparedStatement stmt = connection.prepareStatement(sql)) {

        stmt.setString(1, user.getUsername());
        stmt.setString(2, user.getEmail());
        stmt.setString(3, PasswordUtil.hashPassword(user.getPassword()));

        return stmt.executeUpdate();

    } catch (SQLException e) {
        Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        return 0;
    }
}
}