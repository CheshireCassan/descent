package com.descent.fx.map;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

import java.awt.*;
import java.io.FileInputStream;

public class MapTile {

    private boolean isCompleted = false;
    private boolean isNext = false;

    public Button getButton(MapTile mapTile){
        if (!mapTile.isCompleted) {
            Image image = new Image("maptiles/questiontile.png");
            ImageView imageView = new ImageView(image);

            Button btn = new Button();
            return btn;
        }
        else {
            Image image = new Image("maptiles/clearedtile.png");
            ImageView imageView = new ImageView(image);

            Button btn = new Button();
            return btn;
        }
    }
}
