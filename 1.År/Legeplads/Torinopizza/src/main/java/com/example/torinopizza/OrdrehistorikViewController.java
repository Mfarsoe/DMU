package com.example.torinopizza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class OrdrehistorikViewController {

    @FXML
    private DatePicker fraDato;

    @FXML
    private Button opdaterTabelBtn;

    @FXML
    private TableView<?> tableVIewKunde;

    @FXML
    private TableColumn<?, ?> tableViewDato;

    @FXML
    private TableColumn<?, ?> tableViewKundeID;

    @FXML
    private TableColumn<?, ?> tableViewOrdreID;

    @FXML
    private TableColumn<?, ?> tableViewPris;

    @FXML
    private TextField textFieldKundeID;

    @FXML
    private DatePicker tilDato;

    @FXML
    void opdaterTabelPress(ActionEvent event) {

    }

}
