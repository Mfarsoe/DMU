module com.example.sortalgs {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.sortalgs to javafx.fxml;
    exports com.example.sortalgs;
}