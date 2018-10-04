package com.descent.fx;

import com.descent.Inventory;
import com.descent.combat.Combat;
import com.descent.enemy.*;
import com.descent.fx.map.MapScreen;
import com.descent.playercharacter.PlayerCharacter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CombatFX {

    public void startCombat(GraphicsContext gc, Scene theScene, PlayerCharacter pc){

        EnemyGenerator eg = new EnemyGenerator();
        Enemy enemy = eg.generateEnemy();

        Combat combat = new Combat();

        updateScreen(gc, theScene, pc, enemy);

        HBox playerActions = new HBox();
        playerActions.setLayoutX(100);
        playerActions.setLayoutY(650);

        int startingActionPoints = pc.getActionPoints();

        Button attackBtn = new Button("Basic Attack");
        attackBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (pc.getActionPoints() > 0) {
                    pc.basicAttack(pc, enemy);
                    updateScreen(gc, theScene, pc, enemy);
                }
            }
        });
        playerActions.getChildren().add(attackBtn);

        Button defendBtn = new Button("Basic Defend");
        defendBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (pc.getActionPoints() > 0) {
                    pc.basicDefend(pc);
                    updateScreen(gc, theScene, pc, enemy);
                }
            }
        });
        playerActions.getChildren().add(defendBtn);

        Button fleeBtn = new Button("Flee");
        fleeBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pc.setActionPoints(startingActionPoints);
                pc.setArmour(0);
                playerActions.getChildren().clear();
                MapScreen ms = new MapScreen();
                ms.createMap(gc, theScene, pc);
            }
        });
        playerActions.getChildren().add(fleeBtn);

        Button endTurnBtn = new Button("End Turn");
        endTurnBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (enemy.getHealth() > 0 && pc.getHealth() > 0) {
                    pc.setActionPoints(startingActionPoints);
                    combat.setPlayerTurn(false);
                    combat.combatCycle(pc, enemy, gc, theScene);
                    updateScreen(gc, theScene, pc, enemy);
                }
                else {
                    pc.setActionPoints(startingActionPoints);
                    pc.setArmour(0);
                    playerActions.getChildren().clear();
                    endOfCombat(pc, enemy, gc, theScene);
                }
            }
        });
        playerActions.getChildren().add(endTurnBtn);

        ((Group)theScene.getRoot()).getChildren().add(playerActions);
    }

    private void endOfCombat(PlayerCharacter pc, Enemy enemy, GraphicsContext gc, Scene theScene) {
        gc.clearRect(0, 0, 1080, 720);
        Image combatBG = new Image("backgrounds/mainmenubg.png");
        gc.drawImage(combatBG, 0, 0);

        gc.setFill( Color.BLACK );
        gc.setLineWidth(2);
        Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 42 );
        gc.setFont( theFont );

        HBox endButtons = new HBox();
        endButtons.setLayoutX(490);
        endButtons.setLayoutY(550);

        if (pc.getHealth() <= 0){
            gc.drawImage(combatBG, 0, 0);
            gc.fillText("GAME OVER", 420, 300);

            Button backBtn = new Button("Back to Menu");
            backBtn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    endButtons.getChildren().clear();
                    TitleScreen ts = new TitleScreen();
                    ts.showTitleScreen(gc, theScene);
                }
            });
            endButtons.getChildren().add(backBtn);

        }
        else {
            gc.fillText("VICTORY", 445, 300);
            pc.setGold(pc.getGold() + 10 * enemy.getLootChance());
            gc.fillText("YOU NOW HAVE " + pc.getGold() + " GOLD", 265, 350);

            Button backBtn = new Button("Back to Map");
            backBtn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    endButtons.getChildren().clear();
                    MapScreen ms = new MapScreen();
                    ms.createMap(gc, theScene, pc);
                }
            });
            endButtons.getChildren().add(backBtn);
        }
        ((Group)theScene.getRoot()).getChildren().add(endButtons);
    }

    public void updateScreen(GraphicsContext gc, Scene theScene, PlayerCharacter pc, Enemy enemy) {
        gc.clearRect(0, 0, 1080, 720);
        Image combatBG = new Image("backgrounds/mainmenubg.png");
        gc.drawImage(combatBG, 0, 0);

        Image player = new Image("characters/playercharacter2.png");
        gc.drawImage(player, 200, 200);

        Image enemyskeleton = new Image("characters/enemyskeleton.png");
        Image enemybat = new Image("characters/enemybat.png");
        Image enemybrute = new Image("characters/enemybrute.png");

        if (enemy instanceof EnemySkeleton){
            gc.drawImage(enemyskeleton, 600, 200);
        }
        else if (enemy instanceof EnemyBat){
            gc.drawImage(enemybat, 600, 200);
        }
        else if (enemy instanceof EnemyBrute){
            gc.drawImage(enemybrute, 600, 200);
        }

        gc.setFill( Color.BLACK );
        gc.setLineWidth(2);
        Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 22 );
        gc.setFont( theFont );

        gc.fillText("Action points: " + pc.getActionPoints(), 230, 550);
        gc.fillText( "Health: " + pc.getHealth(), 230, 580 );
        gc.fillText( "Armour: " + pc.getArmour(), 230, 610 );
        gc.fillText( "Health: " + enemy.getHealth(), 700, 580 );
        gc.fillText( "Armour: " + enemy.getArmour(), 700, 610 );

        Inventory inven = new Inventory();
        inven.displayInventoryCombat(pc, gc, theScene);
    }
}
