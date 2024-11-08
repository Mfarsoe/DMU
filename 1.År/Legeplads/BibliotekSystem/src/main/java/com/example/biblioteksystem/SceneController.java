package com.example.biblioteksystem;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;

import java.io.IOException;

public class SceneController {
    @FXML
    private Scene scene;
    @FXML
    private Stage stage;

    @FXML
    public void switchSceneLib(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("librarian.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
