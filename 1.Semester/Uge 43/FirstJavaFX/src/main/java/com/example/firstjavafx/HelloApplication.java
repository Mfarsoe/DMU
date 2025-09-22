package com.example.firstjavafx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Control;


import java.util.Random;


public class HelloApplication extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        int width = 800;
        int height = 600;
        //GROUP ROOT
        Group root = new Group();

        //Text
        Text text = new Text();
        {
            text.setText("Hello World!");
            text.setX(100);
            text.setY(200);
            text.setFont(new Font("Arial", 24));
        }
        // root.getChildren().add(text);

        //Circle
        Random rnd = new Random();

        Stop[] stops = new Stop[] { new Stop(0, Color.YELLOW), new Stop(1, Color.RED)};
        LinearGradient linearGradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);

        for (int i = 0; i < 5000; i++) {
            Circle circle = new Circle();

            {
                circle.setCenterX(rnd.nextInt(width));
                circle.setCenterY(rnd.nextInt(height));
                circle.setRadius(rnd.nextInt(15,20));
                circle.setFill(linearGradient);
                circle.setStroke(Color.BLACK);
                circle.setStrokeWidth(3);
            }
            root.getChildren().add(circle);
        }

        //Scene
        Scene scene = new Scene(root, width, height);



        //Stage
        stage.setScene(scene);
        stage.setTitle("First JavaFX");
        stage.show();
    }
}