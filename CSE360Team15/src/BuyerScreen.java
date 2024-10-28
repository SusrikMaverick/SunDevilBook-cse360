import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BuyerScreen extends Application {
    private final BookStore store = BookStore.getInstance();  // Access the same store

    @Override
    public void start(Stage stage) {
        // ComboBox to select book category with a prompt text
        ComboBox<String> categoryBox = new ComboBox<>();
        categoryBox.getItems().addAll("Natural Science", "Computer Science", "Math", "English", "Other");
        categoryBox.setPromptText("Select Category");  // Set the placeholder prompt

        // ListView to display books based on the selected category
        ListView<String> bookList = new ListView<>();

        // Button to purchase the selected book
        Button purchaseButton = new Button("Purchase Book");
        purchaseButton.setStyle("-fx-font-size: 14px; -fx-padding: 10;");  // Styling for button

        // Event: Load books when a category is selected
        categoryBox.setOnAction(e -> {
            String selectedCategory = categoryBox.getValue();
            bookList.getItems().clear();  // Clear old books
            store.getBooksByCategory(selectedCategory).forEach(book ->
                bookList.getItems().add(book.getTitle() + " (" + book.getCondition() + ") - $" + book.getSellingPrice())
            );
        });

        // Event: Handle book purchase
        purchaseButton.setOnAction(e -> {
            String selectedBook = bookList.getSelectionModel().getSelectedItem();
            if (selectedBook != null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "You have purchased: " + selectedBook);
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Please select a book to purchase.");
                alert.showAndWait();
            }
        });

        // Center the Purchase Button using HBox
        HBox buttonContainer = new HBox(purchaseButton);
        buttonContainer.setAlignment(Pos.CENTER);  // Center the button horizontally

        // Layout: VBox to organize the ComboBox and ListView
        VBox layout = new VBox(10, categoryBox, bookList, buttonContainer);
        layout.setStyle("-fx-padding: 20;");
        layout.setAlignment(Pos.CENTER);  // Align the entire layout to the center

        // Scene and Stage Setup
        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Buyer Screen");
        stage.show();
    }
}
