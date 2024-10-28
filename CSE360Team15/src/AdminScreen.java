import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminScreen extends Application {

    @Override
    public void start(Stage stage) {
        // Admin Screen Components
        Label label = new Label("Admin Options - Manage System");

        // Layout
        VBox layout = new VBox(20, label);
        layout.setStyle("-fx-padding: 50; -fx-alignment: center;");

        // Scene and Stage Setup
        Scene scene = new Scene(layout, 300, 200);
        stage.setTitle("Admin Screen");
        stage.setScene(scene);
        stage.show();
    }
}
