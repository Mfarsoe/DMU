package com.example.passwordhashtest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        System.out.println(PasswordUtils.hashPassword("321"));
        System.out.println(PasswordUtils.checkPassword("321","$2a$10$3eVdjK28i3eNT9pacOkMKO59nuTlVYElS.c5cVjTXdPpYEQ0D5vAi"));
        launch();
    }
}