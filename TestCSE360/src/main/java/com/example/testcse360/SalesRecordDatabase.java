package com.example.testcse360;

import java.sql.*;

public class SalesRecordDatabase {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/SalesRecord";
    private static final String USER = "team15";  // Replace with your MySQL username
    private static final String PASSWORD = "abracadabra"; // Replace with your MySQL password

    // Connect to the database
    private static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    // Add a sales record (stores the admin's profit, which is 20% of the book price)
    public static void addSale(String title, double adminProfit, String category) {
        String query = "INSERT INTO sales (title, profit, category) VALUES (?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, title);
            pstmt.setDouble(2, adminProfit); // Store the profit (20% of book price)
            pstmt.setString(3, category);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
