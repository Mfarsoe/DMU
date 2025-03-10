module com.example.mediatorpatternopg1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mediatorpatternopg1 to javafx.fxml;
    exports com.example.mediatorpatternopg1;
}