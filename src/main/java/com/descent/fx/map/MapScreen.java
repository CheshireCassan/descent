package com.descent.fx.map;

import com.descent.MapGen;
import com.descent.encounters.Encounter;
import com.descent.fx.BossCombatFX;
import com.descent.fx.FinalMerchantFX;
import com.descent.playercharacter.PlayerCharacter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;
import java.util.List;

public class MapScreen {

    private boolean mapExists;

    public void createMap(GraphicsContext gc, Scene theScene, PlayerCharacter pc) {

            Image mapBG = new Image("backgrounds/mapbg.png");
            gc.drawImage(mapBG, 0, 0);

            MapGen mG = new MapGen();
            List<MapTile> mapTiles = new ArrayList<>();
            List<Integer> encounterIDs = new ArrayList<>();

            if (!mapExists) {
                mG.generateMap();
                mapTiles = mG.getMapTiles();
                encounterIDs = mG.getEncounterIDs();
                mapExists = true;
            }

            showMap(mapTiles, gc, theScene, encounterIDs, pc);
    }

    public void showMap(List<MapTile> mapTiles, GraphicsContext gc, Scene theScene, List<Integer> encounterIDs, PlayerCharacter pc) {

            Image questionTile = new Image("maptiles/questiontile.png");
            Image finalShopTile = new Image("maptiles/shoptile.png");
            Image bossTile = new Image("maptiles/bosstile.png");
            Image clearedTile = new Image("maptiles/clearedtile.png");

            VBox bossVBox = new VBox();
            bossVBox.setLayoutX(430);
            bossVBox.setLayoutY(490);

            VBox finalShopVBox = new VBox();
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
                    Button shopBtn = new Button();
                    shopBtn.setGraphic(new ImageView(finalShopTile));
                    shopBtn.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            clearScene(bossVBox, finalShopVBox, encounterHBox1, encounterHBox2);
                            FinalMerchantFX fmfx = new FinalMerchantFX();
                            fmfx.showFinalMerchant(gc, theScene, pc);
                        }
                    });
                    finalShopVBox.getChildren().add(shopBtn);
                } else if (mapTiles.get(i) instanceof BossTile) {
                    Button bossBtn = new Button();
                    bossBtn.setGraphic(new ImageView(bossTile));
                    bossBtn.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            clearScene(bossVBox, finalShopVBox, encounterHBox1, encounterHBox2);
                            BossCombatFX bcfx = new BossCombatFX();
                            bcfx.startCombat(gc, theScene, pc);
                        }
                    });
                    bossVBox.getChildren().add(bossBtn);
                } else if (mapTiles.get(i) instanceof ClearedTile) {
                    Button clearedBtn = new Button();
                    clearedBtn.setGraphic(new ImageView(clearedTile));

                    if (encounterHBox1.getChildren().size() < 5)
                        encounterHBox1.getChildren().add(clearedBtn);
                    else
                        encounterHBox2.getChildren().add(clearedBtn);
                } else {
                    Button questionBtn = new Button();
                    questionBtn.setGraphic(new ImageView(questionTile));
                    questionBtn.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            clearScene(bossVBox, finalShopVBox, encounterHBox1, encounterHBox2);
                            Encounter encounter = new Encounter();
                            encounter.questionTileClick(encounterIDs, gc, theScene, pc);
                        }
                    });

                    if (encounterHBox1.getChildren().size() < 5)
                        encounterHBox1.getChildren().add(questionBtn);
                    else
                        encounterHBox2.getChildren().add(questionBtn);
                }
            }

            ((Group) theScene.getRoot()).getChildren().add(finalShopVBox);
            ((Group) theScene.getRoot()).getChildren().add(bossVBox);
            ((Group) theScene.getRoot()).getChildren().add(encounterHBox1);
            ((Group) theScene.getRoot()).getChildren().add(encounterHBox2);

        gc.setFill( Color.BLACK );
        gc.setLineWidth(2);
        Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 22 );
        gc.setFont( theFont );

        gc.fillText( "Health: " + pc.getHealth(), 65, 40 );
        gc.fillText("Gold: " + pc.getGold(), 65, 70);
        }

        private void clearScene(VBox vbox1, VBox vbox2, HBox hbox1, HBox hbox2){
            vbox1.getChildren().clear();
            vbox2.getChildren().clear();
            hbox1.getChildren().clear();
            hbox2.getChildren().clear();
        }
}
