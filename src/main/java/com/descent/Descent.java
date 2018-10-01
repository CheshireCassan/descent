package com.descent;

import com.descent.fx.MapScreen;
import com.descent.fx.TitleScreen;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Descent extends Application{

    public static void main(String[] args) {

        launch(args);

//        playercharacter pc = new playercharacter(100, 0, 0, 10, 15, 10, 5, 5);
//        EnemySkeleton enemy1 = new EnemySkeleton(70, 0, 10, 5, 20, 5);
//
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

        TitleScreen titleScreen = new TitleScreen();
        titleScreen.showTitleScreen(canvas, gc, theScene);

//        Image background = new Image("backgrounds/forestbg.png");
//        gc.drawImage(background, 0, 0);
//
//        Image player = new Image("characters/playercharacter2.png");
//        gc.drawImage(player, 150, 300);


        final long startNanoTime = System.nanoTime();
        new AnimationTimer() {
            public void handle(long currentNanoTime) {

            }
        }.start();

        theStage.show();
    }



}
