module com.example.biblioteksystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens com.example.biblioteksystem to javafx.fxml;
    exports com.example.biblioteksystem;
}