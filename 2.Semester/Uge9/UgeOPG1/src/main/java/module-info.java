module com.example.ugeopg1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.ugeopg1 to javafx.fxml;
    exports com.example.ugeopg1;
}