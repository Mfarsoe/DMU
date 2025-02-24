package com.example.ugeopg1;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class STController {

    @FXML
    private TextArea textArea;

    public static STController instance;
    public static STController getInstance() {
        if (instance == null) {
            instance = new STController();
        }
        return instance;
    }
    public STController() {
        instance = this;
    }
    public void initialize() {
        textArea.setEditable(false);
        for (int i=0; i<100; i++){
            STController.message("Bug : " + i + "\n");
        }
    }
    public static void message(String message) {
        instance.textArea.appendText(message);
    }
}
