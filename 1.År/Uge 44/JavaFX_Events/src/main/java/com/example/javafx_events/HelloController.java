package com.example.javafx_events;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void onHelloButtonClick2() {
        welcomeText.setText("2");
    }
    @FXML
    protected void onHelloButtonClick3() {
        welcomeText.setText("3");
    }

}