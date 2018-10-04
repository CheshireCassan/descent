package com.descent.combat;

import com.descent.enemy.Enemy;
import com.descent.playercharacter.PlayerCharacter;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Random;
import java.util.Scanner;

public class Combat {

    private boolean playerTurn = true;

    public boolean isPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(boolean playerTurn) {
        this.playerTurn = playerTurn;
    }

    private Random rnd = new Random();

    public void combatCycle(PlayerCharacter pc, Enemy enemy, GraphicsContext gc, Scene theScene) {

        while (pc.getHealth() > 0 && enemy.getHealth() > 0) {

            if (playerTurn) {
                return;
            }
            else if (!playerTurn){
                int selection = rnd.nextInt(3);

                switch (selection){
                    case 0:
                        enemy.basicAttack(enemy, pc);
                        break;
                    case 1:
                        enemy.basicDefend(enemy);
                        break;
                    case 2:
                        enemy.selfBuff(enemy);
                        break;
                }
                playerTurn = true;
            }
        }
    }
}
