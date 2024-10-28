module com.example.javafx_events {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafx_events to javafx.fxml;
    exports com.example.javafx_events;
}