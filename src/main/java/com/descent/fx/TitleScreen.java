package com.descent.fx;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class TitleScreen {

    public void showTitleScreen(Canvas canvas, GraphicsContext gc, Scene theScene){

        Image background = new Image("backgrounds/mainmenubg.png");
        gc.drawImage(background, 0, 0);
        Image logo = new Image("misc/logo.png");
        gc.drawImage(logo, 240, 200);

        Image beginBtn = new Image("buttons/beginbtn.png");
        gc.drawImage(beginBtn, 330, 500);

        theScene.setOnMouseClicked(
                e -> {
                    MapScreen ms = new MapScreen();
                    ms.showMap(canvas, gc);
                });

    }

}