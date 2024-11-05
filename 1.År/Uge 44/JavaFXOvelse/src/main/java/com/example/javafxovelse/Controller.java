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
        radioButtonA.setSelected(true);
        radioButtonB.setSelected(false);
        radioButtonC.setSelected(false);
        radioButtonD.setSelected(false);
    }
    @FXML
    public void clearRadioButtonsB() {
        radioButtonA.setSelected(false);
        radioButtonB.setSelected(true);
        radioButtonC.setSelected(false);
        radioButtonD.setSelected(false);
    }
    @FXML
    public void clearRadioButtonsC() {
        radioButtonA.setSelected(false);
        radioButtonB.setSelected(false);
        radioButtonC.setSelected(true);
        radioButtonD.setSelected(false);
    }
    @FXML
    public void clearRadioButtonsD() {
        radioButtonA.setSelected(false);
        radioButtonB.setSelected(false);
        radioButtonC.setSelected(false);
        radioButtonD.setSelected(true);
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