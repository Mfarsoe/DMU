module com.example.ugeopg {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ugeopg to javafx.fxml;
    exports com.example.ugeopg;
}