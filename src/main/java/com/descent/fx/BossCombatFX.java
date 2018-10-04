package com.descent.fx;

import com.descent.Inventory;
import com.descent.combat.BossCombat;
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

public class BossCombatFX {
    public void startCombat(GraphicsContext gc, Scene theScene, PlayerCharacter pc){

        EnemyBoss boss = new EnemyBoss(250, 0, 20, 10, 0, 10);

        BossCombat combat = new BossCombat();

        updateScreen(gc, theScene, pc, boss);

        HBox playerActions = new HBox();
        playerActions.setLayoutX(100);
        playerActions.setLayoutY(650);

        int startingActionPoints = pc.getActionPoints();

        Button attackBtn = new Button("Basic Attack");
        attackBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (pc.getActionPoints() > 0) {
                    pc.basicAttack(pc, boss);
                    updateScreen(gc, theScene, pc, boss);
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
                    updateScreen(gc, theScene, pc, boss);
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
                if (boss.getHealth() > 0 && pc.getHealth() > 0) {
                    pc.setActionPoints(startingActionPoints);
                    combat.setPlayerTurn(false);
                    combat.combatCycle(pc, boss, gc, theScene);
                    updateScreen(gc, theScene, pc, boss);
                }
                else {
                    pc.setActionPoints(startingActionPoints);
                    pc.setArmour(0);
                    playerActions.getChildren().clear();
                    endOfCombat(pc, boss, gc, theScene);
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

            Button fleeBtn = new Button("Back to Menu");
            fleeBtn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    endButtons.getChildren().clear();
                    TitleScreen ts = new TitleScreen();
                    ts.showTitleScreen(gc, theScene);
                }
            });
            endButtons.getChildren().add(fleeBtn);

        }
        else {
            gc.fillText("VICTORY!", 445, 300);
            gc.fillText("YOU HAVE DEFEATED THE BOSS", 200, 350);
            gc.fillText("AND CLEARED THE DUNGEON.", 220, 400);
            gc.fillText("CONGRATULATIONS!", 315, 450);

            endButtons.setLayoutX(490);
            endButtons.setLayoutY(550);

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
        ((Group)theScene.getRoot()).getChildren().add(endButtons);
    }

    public void updateScreen(GraphicsContext gc, Scene theScene, PlayerCharacter pc, Enemy enemy) {
        gc.clearRect(0, 0, 1080, 720);
        Image combatBG = new Image("backgrounds/mainmenubg.png");
        gc.drawImage(combatBG, 0, 0);

        Image player = new Image("characters/playercharacter2.png");
        gc.drawImage(player, 200, 200);

        Image enemysBoss = new Image("characters/enemyboss.png");
        gc.drawImage(enemysBoss, 550, 100);

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
