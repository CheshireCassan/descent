package com.descent;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Descent extends Application{

    public static void main(String[] args) {

        launch(args);

//        playercharacter pc = new playercharacter(100, 0, 0, 10, 15, 10, 5, 5);
//        EnemySkeleton enemy1 = new EnemySkeleton(70, 0, 10, 5, 20, 5);
//
//        //test
//        Combat fight = new Combat();
//        fight.combatCycle(pc, enemy1);

    }

    public void start(Stage theStage) {
        theStage.setTitle( "Descent" );

        Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);

        Canvas canvas = new Canvas(1080, 720);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.RED);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        Font theFont = Font.font ("Times New Roman", FontWeight.BOLD, 48);
        gc.setFont(theFont);
        gc.fillText("DESCENT", 60, 50);
        gc.strokeText("DESCENT", 60, 50);

        theStage.show();
    }
}
