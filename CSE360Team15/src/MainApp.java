import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create Buttons for Buyer and Seller
        Button buyerButton = new Button("Buyer");
        Button sellerButton = new Button("Seller");
        Button adminButton = new Button("Admin"); // Optional admin button for future

        // Set Button Styles for Consistency
        buyerButton.setStyle("-fx-font-size: 16px; -fx-padding: 10;");
        sellerButton.setStyle("-fx-font-size: 16px; -fx-padding: 10;");
        adminButton.setStyle("-fx-font-size: 16px; -fx-padding: 10;");

        // Button Actions to Open Different Screens
        buyerButton.setOnAction(e -> new BuyerScreen().start(new Stage()));
        sellerButton.setOnAction(e -> new SellerScreen().start(new Stage()));
        adminButton.setOnAction(e -> new AdminScreen().start(new Stage()));

        // Layout Setup (VBox with Spacing and Center Alignment)
        VBox layout = new VBox(20, buyerButton, sellerButton, adminButton);
        layout.setAlignment(Pos.CENTER);  // Center the VBox elements
        layout.setStyle("-fx-background-color: #f0f4f8; -fx-padding: 50;");

        // Scene and Stage Setup
        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setTitle("SunDevil Book System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
