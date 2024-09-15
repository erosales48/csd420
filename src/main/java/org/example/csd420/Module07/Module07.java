package org.example.csd420.Module07;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.layout.HBox;

public class Module07 extends Application {

     @Override
    public void start(Stage primaryStage) {

        HBox hBox = new HBox(5);
        Scene scene = new Scene(hBox, 480, 300);

        scene.getStylesheets().add("myStyle.css");
        Pane pane1 = new Pane();
        Circle circle1 = new Circle(60, 150, 50);
        pane1.getChildren().addAll(circle1);
        pane1.getStyleClass().add("border");

        Pane pane2 = new Pane();
        Circle circle2 = new Circle(60, 150, 50);
        pane2.getChildren().addAll(circle2);

        Pane pane3 = new Pane();
        Circle circle3 = new Circle(60, 150, 50);
        pane3.getChildren().addAll(circle3);

        Pane pane4 = new Pane();
        Circle circle4 = new Circle(60, 150, 50);
        pane4.getChildren().addAll(circle4);

        circle1.getStyleClass().add("plainCircle");
        circle2.getStyleClass().add("circleBorder");
        circle3.setId("redCircle");
        circle4.setId("greenCircle");

        hBox.getChildren().addAll(pane1, pane2, pane3, pane4);

        primaryStage.setTitle("Module 07");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
