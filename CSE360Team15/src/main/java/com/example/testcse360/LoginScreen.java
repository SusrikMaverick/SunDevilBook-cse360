package com.example.testcse360;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginScreen extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Add "Login:" Label
        Label loginLabel = new Label("Login:");
        loginLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        // Username and Password fields
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginButton = new Button("Sign In");
        Button signupButton = new Button("Sign Up");

        // Login Action
        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (UserDatabase.loginUser(username, password)) {
                // Redirect to MainApp UI
                new MainApp().start(new Stage());
                primaryStage.close();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Account not found. Please sign up.");
                alert.showAndWait();
            }
        });

        // Signup Action
        signupButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (username.isEmpty() || password.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Please fill in all fields.");
                alert.showAndWait();
                return;
            }

            if (UserDatabase.registerUser(username, password)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Account created successfully! You can now log in.");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Username already exists. Please try a different one.");
                alert.showAndWait();
            }
        });

        // Layout
        VBox layout = new VBox(10, loginLabel, usernameField, passwordField, loginButton, signupButton);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login Screen");
        primaryStage.show();
    }

    public static void main(String[] args) {
        // Launch the login screen
        launch(args);
    }
}
