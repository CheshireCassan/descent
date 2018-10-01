package com.descent.fx;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.awt.*;

public class MapScreen {

    public void showMap(Canvas canvas, GraphicsContext gc){

        Image mapBG = new Image("backgrounds/mapbg.png");
        gc.drawImage(mapBG, 0, 0);

    }

}
