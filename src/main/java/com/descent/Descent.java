package com.descent;

import com.descent.fx.TitleScreen;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class Descent extends Application{

    public static void main(String[] args) {
        launch(args);
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
        titleScreen.showTitleScreen(gc, theScene);

        theStage.show();
    }
}
