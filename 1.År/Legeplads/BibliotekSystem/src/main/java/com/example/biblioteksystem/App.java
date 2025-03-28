package com.example.biblioteksystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        
        Scene loginScene = new Scene(FXMLLoader.load(getClass().getResource("login.fxml")));
        stage.setTitle("BibSys");
        stage.setScene(loginScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}