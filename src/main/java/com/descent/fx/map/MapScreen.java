package com.descent.fx.map;

import com.descent.MapGen;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.List;

public class MapScreen {

    public void createMap(Canvas canvas, GraphicsContext gc){

        Image mapBG = new Image("backgrounds/mapbg.png");
        gc.drawImage(mapBG, 0, 0);

        MapGen mG = new MapGen();
        mG.generateMap();
        List <MapTile> mapTiles = mG.getMapTiles();

        Image questionTile = new Image("maptiles/questiontile.png");
        Image finalShopTile = new Image("maptiles/shoptile.png");
        Image bossTile = new Image("maptiles/bosstile.png");

        int counter = 0;

        int currentXPosition = 90;

        for (int i = 0; i < mapTiles.size(); i++) {
            if (mapTiles.get(i) instanceof FinalShopTile){
                gc.drawImage(finalShopTile, 490, 250);
            }
            else if (mapTiles.get(i) instanceof BossTile){
                gc.drawImage(bossTile, 440, 390);
            }
            else {
                gc.drawImage(questionTile, currentXPosition, 110);
                currentXPosition = currentXPosition + 100;
            }
        }

    }

}
