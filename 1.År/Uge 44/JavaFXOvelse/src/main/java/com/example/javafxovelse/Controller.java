package com.example.javafxovelse;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Label sum;
    @FXML
    private double a,b;
    @FXML
    private TextField textFieldA;
    @FXML
    private TextField textFieldB;
    @FXML
    private RadioButton radioButtonA;
    @FXML
    private RadioButton radioButtonB;
    @FXML
    private RadioButton radioButtonC;
    @FXML
    private RadioButton radioButtonD;

    private void setCalc() {
        if (radioButtonA.isSelected()) {
            sum.setText(String.valueOf(a + b));
        } else if (radioButtonB.isSelected()) {
            sum.setText(String.valueOf(a - b));
        } else if (radioButtonC.isSelected()) {
            sum.setText(String.valueOf(a * b));
        } else if (radioButtonD.isSelected()) {
            sum.setText(String.valueOf(a / b));
        }
    }
    @FXML
    public void clearRadioButtonsA() {
        clearRaidoButtons();
        radioButtonA.setSelected(true);
    }
    @FXML
    public void clearRadioButtonsB() {
        clearRaidoButtons();
        radioButtonB.setSelected(true);
    }
    @FXML
    public void clearRadioButtonsC() {
        clearRaidoButtons();
        radioButtonC.setSelected(true);
    }
    @FXML
    public void clearRadioButtonsD() {
        clearRaidoButtons();
        radioButtonD.setSelected(true);
    }


    private void clearRaidoButtons(){
        radioButtonA.setSelected(false);
        radioButtonB.setSelected(false);
        radioButtonC.setSelected(false);
        radioButtonD.setSelected(false);
    }
    @FXML
    protected void onButtonClick() {
        try {
            a = Integer.parseInt(textFieldA.getText());
            b = Integer.parseInt(textFieldB.getText());
            setCalc();
        }
        catch (NumberFormatException e) {
            sum.setText("Please only enter numbers!");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

}