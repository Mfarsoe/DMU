package com.example.javafxovelse;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends javafx.application.Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("gui.fxml")));
        stage.setTitle("Sum Calculator");
        stage.setScene(scene);


        stage.show();
    }
}