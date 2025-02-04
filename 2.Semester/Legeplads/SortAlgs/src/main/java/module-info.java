module com.example.sortalgs {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.sortalgs to javafx.fxml;
    exports com.example.sortalgs;
}