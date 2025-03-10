package com.example.mediatorpatternopg1;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextArea textAreaPrint;

    @FXML
    private TextField textFieldAntal, textFieldOrd;

    @FXML
    private Button printBtn;

    @FXML
    void printBtnPress(ActionEvent event) {
        //TextArea bliver clearet
        textAreaPrint.clear();
        //Indtastninger
        int antal = Integer.valueOf(textFieldAntal.getText());
        String ord = textFieldOrd.getText();
        //Tilføjer ordet antal gange med ny linje for hver tilføjelse
        for (int i = 0; i < antal; i++) {
            textAreaPrint.appendText(ord + "\n");
        }
    }

    public void initialize() {
        //Sætter properties for textArea og sætter btnproperties
        textAreaPrint.setEditable(false);
        setButtonProperties();
    }

    private void setButtonProperties() {
        // Deaktiver knappen, hvis ord-feltet er tomt eller antal-feltet ikke er et positivt heltal
        printBtn.disableProperty().bind(
                Bindings.createBooleanBinding(() -> {
                    String ord = textFieldOrd.getText();
                    String antalStr = textFieldAntal.getText();
                    return ord.isEmpty() || !antalStr.matches("\\d+") || Integer.parseInt(antalStr) <= 0;
                }, textFieldOrd.textProperty(), textFieldAntal.textProperty())
        );
    }

}
