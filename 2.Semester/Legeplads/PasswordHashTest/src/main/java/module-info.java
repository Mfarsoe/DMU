module com.example.passwordhashtest {
    requires javafx.controls;
    requires javafx.fxml;
    requires jbcrypt;


    opens com.example.passwordhashtest to javafx.fxml;
    exports com.example.passwordhashtest;
}