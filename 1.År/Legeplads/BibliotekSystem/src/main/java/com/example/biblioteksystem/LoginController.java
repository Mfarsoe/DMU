package com.example.biblioteksystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField Username;
    @FXML
    private PasswordField Password;

    @FXML
    private Label Check;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;


    @FXML
    public void onLoginButtonClick(ActionEvent event) throws IOException {
        String username = Username.getText();
        String password = Password.getText();
        LoginService loginService = new LoginService();
        if (loginService.authenticateUser(username, password)) {
            Check.setText("Login Successful");
            switchSceneLib(event);
        } else
            Check.setText("Login Failed");
    }


    @FXML
    public void switchSceneLib(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("librarian.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}