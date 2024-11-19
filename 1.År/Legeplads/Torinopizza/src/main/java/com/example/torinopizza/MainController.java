package com.example.torinopizza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.PreparedStatement;

public class MainController {

    @FXML
    private Button brugerHBtn;

    @FXML
    private Button nyOrdreBtn;

    @FXML
    private Button opdaterOrdreBtn;

    @FXML
    private Button ordreHistorikBtn;

    @FXML
    private TableView<?> ordreTableView;

    @FXML
    private Button sletOrdreBtn;

    @FXML
    private TableColumn<?, ?> tableVIewPris;

    @FXML
    private TableColumn<?, ?> tableViewKunde;

    @FXML
    private TableColumn<?, ?> tableViewOrdre;

    @FXML
    private TableColumn<?, ?> tableViewStatus;

    @FXML
    void nyOrdrePress(ActionEvent event) throws IOException {
        Stage nyOrdreStage = new Stage();
        FXMLLoader nyOrdreLoader = new FXMLLoader(getClass().getResource("nyordre-view.fxml"));
        Scene nyOrdreScene = new Scene(nyOrdreLoader.load());
        nyOrdreStage.setScene(nyOrdreScene);
        nyOrdreStage.setTitle("Torino Pizza - Ny Ordre");
        nyOrdreStage.show();
    }

    @FXML
    void brugerHPress(ActionEvent event) throws IOException {
        Stage brugerH = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("kundesys-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        brugerH.setScene(scene);
        brugerH.setTitle("Torino Pizza - Bruger Håndtering");
        brugerH.show();
    }

    @FXML
    void seOrdrePress(ActionEvent event) {

    }

    @FXML
    void ordreHistorikPress(ActionEvent event) throws IOException {
        Stage ordreHis = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ordrehistorik-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        ordreHis.setScene(scene);
        ordreHis.show();

    }

    @FXML
    void sletOrdrePress(ActionEvent event) {

    }

}
