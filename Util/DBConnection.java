package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/ticketboat";
    private static final String USER = "root";
    private static final String PASSWORD = "root123";

    private DBConnection() {
        // Mencegah objek DBConnection dibuat
    }

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver MySQL tidak ditemukan.", e);
        }
    }
}