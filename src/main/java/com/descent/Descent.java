package com.descent;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

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

        Image background = new Image("backgrounds/mainmenubg.png");
        gc.drawImage(background, 0, 0);
        Image logo = new Image("misc/logo.png");
        gc.drawImage(logo, 240, 200);

        Image beginBtn = new Image("buttons/beginbtn.png");
        gc.drawImage(beginBtn, 330, 500);

        final long startNanoTime = System.nanoTime();
        new AnimationTimer() {
            public void handle(long currentNanoTime) {

            }
        }.start();

        theStage.show();
    }
}
