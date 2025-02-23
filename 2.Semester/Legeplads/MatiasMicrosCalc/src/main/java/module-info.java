module com.example.matiasmicroscalc {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.matiasmicroscalc to javafx.fxml;
    exports com.example.matiasmicroscalc;
}