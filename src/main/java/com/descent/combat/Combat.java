package com.descent.combat;

import com.descent.enemy.Enemy;
import com.descent.playercharacter.PlayerCharacter;

import java.util.Random;
import java.util.Scanner;

public class Combat {
    public boolean isPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(boolean playerTurn) {
        this.playerTurn = playerTurn;
    }

    private boolean playerTurn = true;
    private Random rnd = new Random();

    public void combatCycle(PlayerCharacter pc, Enemy enemy) {

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

        if (pc.getHealth() <= 0) {
            System.out.println("GAME OVER");
        }
        else {
            System.out.println("VICTORY");
            lootDrop(enemy.getLootChance(), pc);
        }
    }

    private void lootDrop(int lootChance, PlayerCharacter pc){
        int totalGold = pc.getGold() + 10 * lootChance;
        pc.setGold(totalGold);
        System.out.println("You now have " + totalGold + " gold!");
    }
}
