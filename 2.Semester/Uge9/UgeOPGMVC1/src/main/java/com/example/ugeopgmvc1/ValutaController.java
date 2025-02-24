package com.example.ugeopgmvc1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ValutaController {

    private final double USDVALUTAKURS = 0.1405;
    private final double GBPVALUTAKURS = 0.1113;
    private final double YENVALUTAKURS = 21.28;
    private final double EUROVALUTAKURS = 0.1341;


    @FXML
    private TextField textFieldEuro;

    @FXML
    private TextField textFieldGBP;

    @FXML
    private TextField textFieldUSD;

    @FXML
    private TextField textFieldValuta;

    @FXML
    private TextField textFieldYen;

    public void initialize() {
        textFieldUSD.setEditable(false);
        textFieldEuro.setEditable(false);
        textFieldGBP.setEditable(false);
        textFieldYen.setEditable(false);
    }

    @FXML
    void opdaterBtn(ActionEvent event) {
        setTextField(textFieldUSD, USDVALUTAKURS);
        setTextField(textFieldEuro, EUROVALUTAKURS);
        setTextField(textFieldGBP, GBPVALUTAKURS);
        setTextField(textFieldYen, YENVALUTAKURS);
    }

    private String calcValuta(int indtast, double valutakurs){
        return String.format("%.2f",(indtast * valutakurs));
    }
    private void setTextField(TextField textField,double valutakurs) {
        textField.setText(calcValuta(Integer.parseInt(textFieldValuta.getText()), valutakurs));
    }
}
