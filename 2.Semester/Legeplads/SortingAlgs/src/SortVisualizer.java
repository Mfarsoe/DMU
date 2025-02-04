package com.example.sortingvisualizer;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SortVisualizer extends Application {

    private static final int ARRAY_SIZE = 50;
    private static final int CANVAS_WIDTH = 800;
    private static final int CANVAS_HEIGHT = 400;
    private int[] array;
    private List<int[]> steps;  // Listen over array-tilstande under sorteringen

    @Override
    public void start(Stage primaryStage) {
        // Opret brugerflade
        BorderPane root = new BorderPane();
        Canvas canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.setCenter(canvas);

        // Top-bar med ComboBox og Start-knap
        ComboBox<String> algorithmCombo = new ComboBox<>(FXCollections.observableArrayList(
                "Bubble Sort", "Selection Sort"
        ));
        algorithmCombo.getSelectionModel().selectFirst();

        Button startButton = new Button("Start");
        HBox topBar = new HBox(10, algorithmCombo, startButton);
        topBar.setPadding(new Insets(10));
        root.setTop(topBar);

        // Opret et tilfældigt array
        generateRandomArray();

        // Tegn det oprindelige array
        drawArray(gc, array);

        startButton.setOnAction(e -> {
            String algorithm = algorithmCombo.getSelectionModel().getSelectedItem();
            if ("Bubble Sort".equals(algorithm)) {
                steps = bubbleSortSteps(array);
            } else if ("Selection Sort".equals(algorithm)) {
                steps = selectionSortSteps(array);
            }
            animateSorting(gc, steps);
        });

        Scene scene = new Scene(root, CANVAS_WIDTH, CANVAS_HEIGHT + 50);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sorteringsvisualisering med JavaFX");
        primaryStage.show();
    }

    // Generer et tilfældigt array
    private void generateRandomArray() {
        array = new int[ARRAY_SIZE];
        Random rand = new Random();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = rand.nextInt(CANVAS_HEIGHT); // Højde baseret på canvas-højde
        }
    }

    // Tegn arrayet som lodrette søjler
    private void drawArray(GraphicsContext gc, int[] arr) {
        gc.clearRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
        double barWidth = (double) CANVAS_WIDTH / ARRAY_SIZE;
        for (int i = 0; i < arr.length; i++) {
            double x = i * barWidth;
            double y = CANVAS_HEIGHT - arr[i];
            gc.setFill(Color.DARKCYAN);
            gc.fillRect(x, y, barWidth - 2, arr[i]);  // 2 px mellemrum mellem søjlerne
        }
    }

    // Animation af sorteringen
    private void animateSorting(GraphicsContext gc, List<int[]> steps) {
        if (steps == null || steps.isEmpty()) return;
        Timeline timeline = new Timeline();
        int numSteps = steps.size();
        Duration frameDuration = Duration.millis(50); // Juster hastigheden ved at ændre varigheden

        for (int i = 0; i < numSteps; i++) {
            int[] state = steps.get(i);
            KeyFrame kf = new KeyFrame(frameDuration.multiply(i), event -> drawArray(gc, state));
            timeline.getKeyFrames().add(kf);
        }
        timeline.play();
    }

    // Bubble Sort med optagelse af hvert trin (array-kopi)
    private List<int[]> bubbleSortSteps(int[] original) {
        int[] arr = original.clone();
        List<int[]> steps = new ArrayList<>();
        steps.add(arr.clone());
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    steps.add(arr.clone());
                }
            }
        }
        return steps;
    }

    // Selection Sort med optagelse af hvert trin
    private List<int[]> selectionSortSteps(int[] original) {
        int[] arr = original.clone();
        List<int[]> steps = new ArrayList<>();
        steps.add(arr.clone());
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
                steps.add(arr.clone());
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
