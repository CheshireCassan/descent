package com.descent.fx.map;

import com.descent.Descent;
import com.descent.MapGen;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class MapScreen {

    public void createMap(Canvas canvas, GraphicsContext gc, Scene theScene) {

        Image mapBG = new Image("backgrounds/mapbg.png");
        gc.drawImage(mapBG, 0, 0);

        MapGen mG = new MapGen();
        mG.generateMap();
        List<MapTile> mapTiles = mG.getMapTiles();

        showMap(mapTiles, gc, theScene);

    }

    public void showMap(List<MapTile> mapTiles, GraphicsContext gc, Scene theScene){

        int currentXPosition = 90;

        Image questionTile = new Image("maptiles/questiontile.png");
        Image finalShopTile = new Image("maptiles/shoptile.png");
        Image bossTile = new Image("maptiles/bosstile.png");
        Image clearedTile = new Image("maptiles/clearedtile.png");

        VBox bossVBox = new VBox();
        bossVBox.setLayoutX(430);
        bossVBox.setLayoutY(490);

        VBox finalShopVBox = new VBox(0);
        finalShopVBox.setLayoutX(480);
        finalShopVBox.setLayoutY(350);

        HBox encounterHBox1 = new HBox();
        encounterHBox1.setLayoutX(240);
        encounterHBox1.setLayoutY(60);

        HBox encounterHBox2 = new HBox();
        encounterHBox2.setLayoutX(300);
        encounterHBox2.setLayoutY(210);




        for (int i = 0; i < mapTiles.size(); i++) {

            if (mapTiles.get(i) instanceof FinalShopTile) {
//                gc.drawImage(finalShopTile, 490, 250);
                Button shopBtn = new Button();
                shopBtn.setGraphic(new ImageView(finalShopTile));
                finalShopVBox.getChildren().add(shopBtn);
            }

            else if (mapTiles.get(i) instanceof BossTile) {
//                gc.drawImage(bossTile, 440, 390);
                Button bossBtn = new Button();
                bossBtn.setGraphic(new ImageView(bossTile));
                bossVBox.getChildren().add(bossBtn);
            }

            else if (mapTiles.get(i) instanceof ClearedTile) {
//                gc.drawImage(clearedTile, currentXPosition, 110);
//                currentXPosition = currentXPosition + 100;
                Button clearedBtn = new Button();
                clearedBtn.setGraphic(new ImageView(clearedTile));

                if (encounterHBox1.getChildren().size() < 5)
                    encounterHBox1.getChildren().add(clearedBtn);
                else
                    encounterHBox2.getChildren().add(clearedBtn);
            }

            else {
//                gc.drawImage(questionTile, currentXPosition, 110);
//                currentXPosition = currentXPosition + 100;
                Button questionBtn = new Button();
                questionBtn.setGraphic(new ImageView(questionTile));

                if (encounterHBox1.getChildren().size() < 5)
                    encounterHBox1.getChildren().add(questionBtn);
                else
                    encounterHBox2.getChildren().add(questionBtn);
            }
        }

        ((Group)theScene.getRoot()).getChildren().add(finalShopVBox);
        ((Group)theScene.getRoot()).getChildren().add(bossVBox);
        ((Group)theScene.getRoot()).getChildren().add(encounterHBox1);
        ((Group)theScene.getRoot()).getChildren().add(encounterHBox2);
    }

}
