package com.example.torinopizza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class KundeSysController {

    @FXML
    private Button opdaterKundePress;

    @FXML
    private Button opretKundeBtn;

    @FXML
    private Button sletKundeBtn;

    @FXML
    private TableView<?> tableViewKunde;

    @FXML
    private TableColumn<?, ?> tableViewKundeAdresse;

    @FXML
    private TableColumn<?, ?> tableViewKundeID;

    @FXML
    private TableColumn<?, ?> tableViewKundeNavn;

    @FXML
    private TableColumn<?, ?> tableViewKundeTelefon;

    @FXML
    private TextField textFieldAdresse;

    @FXML
    private TextField textFieldNavn;

    @FXML
    private TextField textFieldTelefon;

    @FXML
    void opdaterKundePress(ActionEvent event) {

    }

    @FXML
    void opretKundePress(ActionEvent event) {

    }

    @FXML
    void sletKundePress(ActionEvent event) {

    }

}
