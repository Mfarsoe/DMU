package com.example.ugeopgmvc1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ValutaController {



    @FXML
    private TextField textFieldEuro, textFieldGBP, textFieldUSD, textFieldYen;

    @FXML
    private TextField textFieldValuta;

    private CurrencyModel model = new CurrencyModel();



    public void initialize() {
        textFieldUSD.setEditable(false);
        textFieldEuro.setEditable(false);
        textFieldGBP.setEditable(false);
        textFieldYen.setEditable(false);
    }

    @FXML
    void opdaterBtn(ActionEvent event) {
        try {
            // Hent beløb fra inputfeltet

            model.setAmountInDKK(Double.parseDouble(textFieldValuta.getText()));

            // Opdater labels med de konverterede beløb
            textFieldUSD.setText(String.format("%.2f", model.getAmountInUSD()));
            textFieldGBP.setText(String.format("%.2f", model.getAmountInGBP()));
            textFieldYen.setText(String.format("%.2f", model.getAmountInYEN()));
            textFieldEuro.setText(String.format("%.2f", model.getAmountInEURO()));
        } catch (NumberFormatException e) {
            // Håndter ugyldigt input
            textFieldUSD.setText("Ugyldigt input");
            textFieldGBP.setText("Ugyldigt input");
            textFieldYen.setText("Ugyldigt input");
            textFieldEuro.setText("Ugyldigt input");
        }
    }


}
