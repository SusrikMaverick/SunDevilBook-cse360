import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SellerScreen extends Application {
    private final BookStore store = BookStore.getInstance();  // Access the singleton instance

    @Override
    public void start(Stage stage) {
        // Input fields for book details
        TextField titleField = new TextField();
        titleField.setPromptText("Book Title");

        TextField authorField = new TextField();
        authorField.setPromptText("Author");

        // ComboBox for book category with a prompt
        ComboBox<String> categoryBox = new ComboBox<>();
        categoryBox.getItems().addAll("Natural Science", "Computer Science", "Math", "English", "Other");
        categoryBox.setPromptText("Select Category");  // Set the placeholder prompt

        // ComboBox for book condition with a prompt
        ComboBox<String> conditionBox = new ComboBox<>();
        conditionBox.getItems().addAll("Used Like New", "Moderately Used", "Heavily Used");
        conditionBox.setPromptText("Select Condition");  // Set the placeholder prompt

        // TextField for the original price of the book
        TextField priceField = new TextField();
        priceField.setPromptText("Original Price");

        // Button to list the book for sale
        Button listBookButton = new Button("List My Book");

        // Handle the book listing action
        listBookButton.setOnAction(e -> {
            String title = titleField.getText();
            String author = authorField.getText();
            String category = categoryBox.getValue();
            String condition = conditionBox.getValue();
            
            // Ensure all fields are filled
            if (title.isEmpty() || author.isEmpty() || category == null || condition == null || priceField.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Please fill in all fields.");
                alert.showAndWait();
                return;
            }

            double originalPrice = Double.parseDouble(priceField.getText());
            double sellingPrice = Utils.calculateSellingPrice(category, condition, originalPrice);

            Book newBook = new Book(title, author, category, condition, originalPrice, sellingPrice);
            store.addBook(newBook);  // Add the new book to the store

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Book listed successfully!");
            alert.showAndWait();

            // Clear input fields after successful listing
            titleField.clear();
            authorField.clear();
            categoryBox.setValue(null);
            conditionBox.setValue(null);
            priceField.clear();
        });

        // Layout and Scene Setup
        VBox layout = new VBox(10, titleField, authorField, categoryBox, conditionBox, priceField, listBookButton);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Seller Screen");
        stage.show();
    }
}
