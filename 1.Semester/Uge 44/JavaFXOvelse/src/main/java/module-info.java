module com.example.javafxovelse {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxovelse to javafx.fxml;
    exports com.example.javafxovelse;
}