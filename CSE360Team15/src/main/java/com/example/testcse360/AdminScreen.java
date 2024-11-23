package com.example.testcse360;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;

//THIS IS NOT THE ENTRY POINT OF THE PROGRAM. LAUNCH LOGINSCREEN INSTEAD.

public class AdminScreen extends Application {

    private static final String SALES_RECORD_DB_URL = "jdbc:mysql://localhost:3306/SalesRecord";
    private static final String USER_DB_URL = "jdbc:mysql://localhost:3306/UserDB";
    private static final String BOOK_STORE_DB_URL = "jdbc:mysql://localhost:3306/BookStoreDB";
    private static final String USER = "team15";  // Replace with your MySQL username
    private static final String PASSWORD = "abracadabra"; // Replace with your MySQL password

    @Override
    public void start(Stage stage) {
        // TableViews for each database table
        TableView<ObservableList<String>> salesTable = new TableView<>();
        TableView<ObservableList<String>> userTable = new TableView<>();
        TableView<ObservableList<String>> bookTable = new TableView<>();

        Button loadDataButton = new Button("Load Data");
        loadDataButton.setOnAction(e -> {
            // Load data for each table
            loadTableData(SALES_RECORD_DB_URL, "sales", salesTable);
            loadTableData(USER_DB_URL, "users", userTable);
            loadTableData(BOOK_STORE_DB_URL, "books", bookTable);
        });

        // Layout
        VBox layout = new VBox(10, new Label("Admin Panel - View Database Tables"),
                loadDataButton,
                new Label("Sales Record:"), salesTable,
                new Label("User Database:"), userTable,
                new Label("Book Store Database:"), bookTable);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");

        // Scene and Stage Setup
        Scene scene = new Scene(layout, 800, 800);
        stage.setTitle("Admin Screen");
        stage.setScene(scene);
        stage.show();
    }

    private void loadTableData(String dbUrl, String tableName, TableView<ObservableList<String>> tableView) {
        tableView.getColumns().clear();
        ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();

        try (Connection conn = DriverManager.getConnection(dbUrl, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName)) {

            // Create columns dynamically based on ResultSet metadata
            int columnCount = rs.getMetaData().getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                final int colIndex = i - 1; // Index adjustment for zero-based ObservableList
                TableColumn<ObservableList<String>, String> column = new TableColumn<>(rs.getMetaData().getColumnName(i));
                column.setCellValueFactory(cellData ->
                        new SimpleStringProperty(cellData.getValue().get(colIndex))
                );
                tableView.getColumns().add(column);
            }

            // Add rows dynamically
            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(rs.getString(i));
                }
                data.add(row);
            }

            tableView.setItems(data);

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error loading data: " + e.getMessage());
            alert.showAndWait();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
