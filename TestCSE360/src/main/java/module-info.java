module com.example.testcse360 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.testcse360 to javafx.fxml;
    exports com.example.testcse360;
}