module com.example.ugeopgmvc1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ugeopgmvc1 to javafx.fxml;
    exports com.example.ugeopgmvc1;
}