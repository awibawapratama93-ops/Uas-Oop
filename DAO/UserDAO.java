package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import util.PasswordUtil;
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
    String sql = "SELECT * FROM users WHERE email=?";

    try (PreparedStatement stmt = connection.prepareStatement(sql)) {

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

public int register(User user) {
    String sql = "INSERT INTO users (username, email, password, createdAt) VALUES (?,?,?,NOW())";

    try (PreparedStatement stmt = connection.prepareStatement(sql)) {

        stmt.setString(1, user.getUsername());
        stmt.setString(2, user.getEmail());
        stmt.setString(3, PasswordUtil.hashPassword(user.getPassword()));

        return stmt.executeUpdate();

    } catch (SQLException e) {
        Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        return 0;
    }
}

public int insertUser(User user) {
    String sql = "INSERT INTO users (username, email, password, role, createdAt) VALUES (?,?,?,?,NOW())";

    try (PreparedStatement stmt = connection.prepareStatement(sql)) {

        stmt.setString(1, user.getUsername());
        stmt.setString(2, user.getEmail());
        stmt.setString(3, PasswordUtil.hashPassword(user.getPassword())); // tetap di-hash
        stmt.setString(4, user.getRole());

        return stmt.executeUpdate();

    } catch (SQLException e) {
        Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        return 0;
    }
}

public List<User> getAllUsers() {
    List<User> list = new ArrayList<>();
    String sql = "SELECT * FROM users ORDER BY userID";

    try (PreparedStatement stmt = connection.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            list.add(new User(
                    rs.getInt("userID"),
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("role")
            ));
        }

    } catch (SQLException e) {
        Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
    }

    return list;
}

public boolean isEmailExists(String email) {
    String sql = "SELECT userID FROM users WHERE email=?";

    try (PreparedStatement stmt = connection.prepareStatement(sql)) {

        stmt.setString(1, email);

        try (ResultSet rs = stmt.executeQuery()) {
            return rs.next();
        }

    } catch (SQLException e) {
        Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
    }

    return false;
}

// ===== BARU =====
// Update data user (username, email, role) - password TIDAK diupdate di sini
// demi keamanan (ganti password sebaiknya lewat fitur terpisah)
public int updateUser(int userID, String username, String email, String role) {
    String sql = "UPDATE users SET username=?, email=?, role=? WHERE userID=?";

    try (PreparedStatement stmt = connection.prepareStatement(sql)) {

        stmt.setString(1, username);
        stmt.setString(2, email);
        stmt.setString(3, role);
        stmt.setInt(4, userID);

        return stmt.executeUpdate();

    } catch (SQLException e) {
        Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        return 0;
    }
}

// ===== BARU (tambahan lagi) =====
// Hapus user, dipanggil dari UserController.deleteUser()
public int deleteUser(int userID) {
    String sql = "DELETE FROM users WHERE userID=?";

    try (PreparedStatement stmt = connection.prepareStatement(sql)) {

        stmt.setInt(1, userID);
        return stmt.executeUpdate();

    } catch (SQLException e) {
        Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        return 0;
    }
}
}