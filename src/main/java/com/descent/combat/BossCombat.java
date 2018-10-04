package com.descent.combat;

import com.descent.enemy.Enemy;
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
                int selection = rnd.nextInt(9);

                switch (selection){
                    case 0:
                    case 1:
                    case 2:
                        enemy.basicAttack(enemy, pc);
                        break;

                    case 3:
                    case 4:
                    case 5:
                        enemy.basicDefend(enemy);
                        break;
                    case 6:
                        enemy.tankUp(enemy);
                        break;
                    case 7:
                    case 8:
                        enemy.focusedAttack(enemy, pc);
                        break;
                }
                playerTurn = true;
            }
        }
    }
}
