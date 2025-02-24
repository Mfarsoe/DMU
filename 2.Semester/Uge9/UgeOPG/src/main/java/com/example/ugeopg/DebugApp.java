package com.example.ugeopg;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class DebugApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        DebugView.showWindow(); // Open the debug window

        Platform.runLater(() -> {
            DebugView debugView = DebugView.getInstance();
            for (int i = 0; i < 100; i++) {
                debugView.addBug("Text " + i);
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}
