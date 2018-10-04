package com.descent.combat;

import com.descent.enemy.EnemyBoss;
import com.descent.playercharacter.PlayerCharacter;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;

import java.util.Random;

public class BossCombat {
    private boolean playerTurn = true;

    public boolean isPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(boolean playerTurn) {
        this.playerTurn = playerTurn;
    }

    private Random rnd = new Random();

    public void combatCycle(PlayerCharacter pc, EnemyBoss enemy, GraphicsContext gc, Scene theScene) {

        while (pc.getHealth() > 0 && enemy.getHealth() > 0) {

            if (playerTurn) {
                return;
            }
            else if (!playerTurn){
                int selection = rnd.nextInt(14);

                switch (selection){
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        enemy.basicAttack(enemy, pc);
                        break;

                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        enemy.basicDefend(enemy);
                        break;
                    case 10:
                        enemy.tankUp(enemy);
                        break;
                    case 11:
                    case 12:
                    case 13:
                        enemy.focusedAttack(enemy, pc);
                        break;
                }
                playerTurn = true;
            }
        }
    }
}
