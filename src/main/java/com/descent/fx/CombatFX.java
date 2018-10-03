package com.descent.fx;

import com.descent.combat.Combat;
import com.descent.enemy.*;
import com.descent.fx.map.MapScreen;
import com.descent.playercharacter.PlayerCharacter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.print.PageLayout;
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

        Button attackBtn = new Button("Basic Attack");
        attackBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pc.basicAttack(pc, enemy);
                updateScreen(gc, theScene, pc, enemy);
            }
        });
        playerActions.getChildren().add(attackBtn);

        Button defendBtn = new Button("Basic Defend");
        defendBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pc.basicDefend(pc);
                updateScreen(gc, theScene, pc, enemy);
            }
        });
        playerActions.getChildren().add(defendBtn);

        Button fleeBtn = new Button("Flee");
        fleeBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
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
                combat.setPlayerTurn(false);
                combat.combatCycle(pc, enemy);
                updateScreen(gc, theScene, pc, enemy);
            }
        });
        playerActions.getChildren().add(endTurnBtn);

        ((Group)theScene.getRoot()).getChildren().add(playerActions);

        gc.setFill( Color.BLACK );
        gc.setStroke( Color.BLACK );
        gc.setLineWidth(2);
        Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 22 );
        gc.setFont( theFont );

        gc.fillText( "Health: " + pc.getHealth(), 230, 580 );
        gc.fillText( "Armour: " + pc.getArmour(), 230, 610 );

        gc.fillText( "Health: " + enemy.getHealth(), 700, 580 );
        gc.fillText( "Armour: " + enemy.getArmour(), 700, 610 );



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

        gc.fillText( "Health: " + pc.getHealth(), 230, 580 );
        gc.fillText( "Armour: " + pc.getArmour(), 230, 610 );
        gc.fillText( "Health: " + enemy.getHealth(), 700, 580 );
        gc.fillText( "Armour: " + enemy.getArmour(), 700, 610 );
    }

}
