package com.example.testcse360;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDatabase {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/BookStoreDB";
    private static final String USER = "team15";  // Replace with your MySQL username
    private static final String PASSWORD = "abracadabra"; // Replace with your MySQL password

    // Connect to the database
    private static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    // Fetch books by category
    public static List<Book> getBooksByCategory(String category) {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM books WHERE category = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, category);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                books.add(new Book(
                        rs.getInt("id"), // Add ID
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("category"),
                        rs.getString("book_condition"),
                        rs.getDouble("original_price"),
                        rs.getDouble("selling_price")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    // Fetch all books
    public static List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM books";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                books.add(new Book(
                        rs.getInt("id"), // Add ID
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("category"),
                        rs.getString("book_condition"),
                        rs.getDouble("original_price"),
                        rs.getDouble("selling_price")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    // Delete a book by ID
    public static void deleteBookById(int id) {
        String query = "DELETE FROM books WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Add a book to the database
    public static void addBook(Book book) {
        String query = "INSERT INTO books (title, author, category, book_condition, original_price, selling_price) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setString(3, book.getCategory());
            pstmt.setString(4, book.getCondition());
            pstmt.setDouble(5, book.getOriginalPrice());
            pstmt.setDouble(6, book.getSellingPrice());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
