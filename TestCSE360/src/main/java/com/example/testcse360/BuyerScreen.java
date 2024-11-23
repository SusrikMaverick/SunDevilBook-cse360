package com.example.testcse360;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class BuyerScreen extends Application {

    @Override
    public void start(Stage stage) {
        // Filters and UI elements
        ComboBox<String> categoryBox = new ComboBox<>();
        categoryBox.getItems().addAll("All", "Natural Science", "Computer Science", "Math", "English", "Other");
        categoryBox.setPromptText("Select Category");
        categoryBox.setValue("All");

        ComboBox<String> conditionBox = new ComboBox<>();
        conditionBox.getItems().addAll("All Conditions", "Used Like New", "Moderately Used", "Heavily Used");
        conditionBox.setPromptText("Select Condition");
        conditionBox.setValue("All Conditions");

        TextField searchField = new TextField();
        searchField.setPromptText("Search by Book Title");

        ListView<String> bookList = new ListView<>();
        Button filterButton = new Button("Apply Filter");
        Button searchButton = new Button("Search");
        Button purchaseButton = new Button("Purchase Book");

        // Internal map to track books with their ID
        Map<String, Integer> bookMap = new HashMap<>();

        // Filter Button Logic
        filterButton.setOnAction(e -> {
            String selectedCategory = categoryBox.getValue();
            String selectedCondition = conditionBox.getValue();
            bookList.getItems().clear();
            bookMap.clear(); // Clear the map for a new filter set
            BookDatabase.getAllBooks().stream()
                    .filter(book -> selectedCategory.equals("All") || book.getCategory().equals(selectedCategory))
                    .filter(book -> selectedCondition.equals("All Conditions") || book.getCondition().equals(selectedCondition))
                    .forEach(book -> {
                        // Display price with a 20% markup (buyer pays 120% of the seller's price)
                        double buyerPrice = book.getSellingPrice() * 1.2;
                        String displayText = book.getTitle() + " (" + book.getCondition() + ") - $" + String.format("%.2f", buyerPrice);
                        bookList.getItems().add(displayText);
                        bookMap.put(displayText, book.getId()); // Map display text to book ID
                    });
        });

        // Search Button Logic
        searchButton.setOnAction(e -> {
            String query = searchField.getText().toLowerCase();
            bookList.getItems().clear();
            bookMap.clear(); // Clear the map for a new search set
            BookDatabase.getAllBooks().stream()
                    .filter(book -> book.getTitle().toLowerCase().contains(query)) // String matching
                    .forEach(book -> {
                        // Display price with a 20% markup (buyer pays 120% of the seller's price)
                        double buyerPrice = book.getSellingPrice() * 1.2;
                        String displayText = book.getTitle() + " (" + book.getCondition() + ") - $" + String.format("%.2f", buyerPrice);
                        bookList.getItems().add(displayText);
                        bookMap.put(displayText, book.getId()); // Map display text to book ID
                    });
        });

        // Purchase Button Logic
        purchaseButton.setOnAction(e -> {
            String selectedBook = bookList.getSelectionModel().getSelectedItem();
            if (selectedBook != null) {
                int bookId = bookMap.get(selectedBook); // Retrieve the ID using the internal map
                String[] bookDetails = selectedBook.split(" \\(");
                String title = bookDetails[0].trim();
                String condition = bookDetails[1].split("\\)")[0];
                double buyerPrice = Double.parseDouble(bookDetails[1].split("\\$")[1].trim()); // Extract the buyer's price
                double sellerPrice = buyerPrice / 1.2; // Calculate seller's price from buyer's price
                double adminProfit = buyerPrice - sellerPrice; // Admin profit is the markup

                // Fetch the category from the selected item
                String selectedCategory = categoryBox.getValue();

                // Log the sale into the SalesRecord database
                SalesRecordDatabase.addSale(title, adminProfit, selectedCategory);

                // Delete the specific book from the database
                BookDatabase.deleteBookById(bookId); // Use book ID for deletion

                // Refresh the book list
                filterButton.fire();

                // Show confirmation
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "You have purchased: " + title);
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Please select a book to purchase.");
                alert.showAndWait();
            }
        });

        // Layout
        HBox filtersLayout = new HBox(10, categoryBox, conditionBox, filterButton);
        filtersLayout.setStyle("-fx-padding: 10;");

        HBox searchLayout = new HBox(10, searchField, searchButton);
        searchLayout.setStyle("-fx-padding: 10;");

        VBox topLayout = new VBox(5, new Label("Filters:"), filtersLayout, searchLayout);
        BorderPane layout = new BorderPane();
        layout.setTop(topLayout);
        layout.setCenter(bookList);
        layout.setBottom(purchaseButton);

        // Scene
        Scene scene = new Scene(layout, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Buyer Screen");
        stage.show();
    }
}
