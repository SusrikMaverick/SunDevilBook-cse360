package com.example.testcse360;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// THIS IS NOT THE ENTRY POINT OF THE PROGRAM. LAUNCH LOGINSCREEN INSTEAD.

public class SellerScreen extends Application {

    @Override
    public void start(Stage stage) {
        // Input fields for book details
        TextField titleField = new TextField();
        titleField.setPromptText("Book Title");

        TextField authorField = new TextField();
        authorField.setPromptText("Author");

        ComboBox<String> categoryBox = new ComboBox<>();
        categoryBox.getItems().addAll("Natural Science", "Computer Science", "Math", "English", "Other");
        categoryBox.setPromptText("Select Category");

        ComboBox<String> conditionBox = new ComboBox<>();
        conditionBox.getItems().addAll("Used Like New", "Moderately Used", "Heavily Used");
        conditionBox.setPromptText("Select Condition");

        TextField priceField = new TextField();
        priceField.setPromptText("Original Price");

        // Quantity dropdown for selecting how many books to list
        ComboBox<Integer> quantityBox = new ComboBox<>();
        for (int i = 1; i <= 10; i++) { // Add quantities 1 to 10
            quantityBox.getItems().add(i);
        }
        quantityBox.setPromptText("Select Quantity");

        // Label to display the calculated selling price
        Label sellingPriceLabel = new Label("Calculated Selling Price: $0.00");

        // Add listener to update the calculated price dynamically
        ChangeListener<String> updatePriceListener = (observable, oldValue, newValue) -> {
            updateSellingPrice(conditionBox, priceField, sellingPriceLabel);
        };

        conditionBox.valueProperty().addListener(updatePriceListener);
        priceField.textProperty().addListener(updatePriceListener);

        Button listBookButton = new Button("List My Book");

        // Handle the book listing action
        listBookButton.setOnAction(e -> {
            String title = titleField.getText();
            String author = authorField.getText();
            String category = categoryBox.getValue();
            String condition = conditionBox.getValue();
            Integer quantity = quantityBox.getValue();

            // Validate fields
            if (title.isEmpty() || author.isEmpty() || category == null || condition == null ||
                    priceField.getText().isEmpty() || quantity == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Please fill in all fields.");
                alert.showAndWait();
                return;
            }

            try {
                double originalPrice = Double.parseDouble(priceField.getText());
                double sellingPrice = Utils.calculateSellingPrice(category, condition, originalPrice);

                // Add the specified quantity of the book to the database
                for (int i = 0; i < quantity; i++) {
                    Book newBook = new Book(title, author, category, condition, originalPrice, sellingPrice);
                    BookDatabase.addBook(newBook);
                }

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Books listed successfully!");
                alert.showAndWait();

                // Clear fields
                titleField.clear();
                authorField.clear();
                categoryBox.setValue(null);
                conditionBox.setValue(null);
                priceField.clear();
                quantityBox.setValue(null);
                sellingPriceLabel.setText("Calculated Selling Price: $0.00");
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid price. Please enter a valid number.");
                alert.showAndWait();
            }
        });

        // Layout
        VBox layout = new VBox(10, titleField, authorField, categoryBox, conditionBox, priceField,
                quantityBox, sellingPriceLabel, listBookButton);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(layout, 400, 400); // Adjusted height for the additional field
        stage.setScene(scene);
        stage.setTitle("Seller Screen");
        stage.show();
    }

    // Method to update the calculated selling price dynamically
    private void updateSellingPrice(ComboBox<String> conditionBox, TextField priceField, Label sellingPriceLabel) {
        String condition = conditionBox.getValue();
        String originalPriceText = priceField.getText();

        if (condition != null && !originalPriceText.isEmpty()) {
            try {
                double originalPrice = Double.parseDouble(originalPriceText);
                double sellingPrice = Utils.calculateSellingPrice("", condition, originalPrice); // Category is unused for price calc
                sellingPriceLabel.setText(String.format("Calculated Selling Price: $%.2f", sellingPrice));
            } catch (NumberFormatException e) {
                sellingPriceLabel.setText("Calculated Selling Price: $0.00");
            }
        } else {
            sellingPriceLabel.setText("Calculated Selling Price: $0.00");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
