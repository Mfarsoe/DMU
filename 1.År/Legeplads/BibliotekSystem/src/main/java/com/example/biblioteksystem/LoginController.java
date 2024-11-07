package com.example.biblioteksystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private TextField Username;
    @FXML
    private PasswordField Password;
    @FXML
    private static Button Login;
    @FXML
    private Label Check;


    @FXML
    public void onButtonClick(ActionEvent event) {
        String username = Username.getText();
        String password = Password.getText();
        LoginService loginService = new LoginService();
        if (loginService.authenticateUser(username, password)) {
            Check.setText("Login Successful");
        } else
            Check.setText("Login Failed");
    }

}