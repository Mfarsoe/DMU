package com.example.ugeopg;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class DebugView {
    private static DebugView instance; // Singleton instance
    private static Parent root;

    @FXML
    private TextArea debugArea;

    public DebugView() {
        // Public constructor so JavaFX can instantiate it from FXML
    }

    public static DebugView getInstance() {
        if (instance == null) {
            try {
                FXMLLoader loader = new FXMLLoader(DebugView.class.getResource("debug-view.fxml"));
                root = loader.load();
                instance = loader.getController(); // Get the FXML controller
            } catch (IOException e) {
                throw new RuntimeException("Failed to load DebugView.fxml", e);
            }
        }
        return instance;
    }

    public static Parent getRoot() {
        if (root == null) {
            throw new IllegalStateException("DebugView has not been initialized yet.");
        }
        return root;
    }

    public void addBug(String bug) {
        if (debugArea != null) {
            debugArea.appendText(bug + "\n");
        } else {
            System.out.println("debugArea is null! DebugView not initialized.");
        }
    }

    public static void showWindow() {
        if (instance == null) {
            getInstance();
        }

        Stage stage = new Stage();
        stage.setTitle("Debug Window");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
