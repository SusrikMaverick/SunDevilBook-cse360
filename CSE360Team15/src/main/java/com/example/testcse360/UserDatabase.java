package com.example.testcse360;

import java.sql.*;

public class UserDatabase {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/UserDB";
    private static final String USER = "team15";  // Replace with your MySQL username
    private static final String PASSWORD = "abracadabra"; // Replace with your MySQL password

    // Connect to the database
    private static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    // Login user: Check if username and password match
    public static boolean loginUser(String username, String password) {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            return rs.next(); // Returns true if a match is found
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Register user: Add a new user
    public static boolean registerUser(String username, String password) {
        String query = "INSERT INTO users (username, password) VALUES (?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            return true; // User successfully added
        } catch (SQLIntegrityConstraintViolationException e) {
            // Username already exists
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
