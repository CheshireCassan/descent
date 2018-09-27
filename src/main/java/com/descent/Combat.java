package com.descent;

import com.descent.enemy.Enemy;
import com.descent.playercharacter.PlayerCharacter;

import java.util.Scanner;

public class Combat {
    private boolean playerTurn = true;
    private Scanner scanner = new Scanner(System.in);

    public void combatCycle(PlayerCharacter pc, Enemy enemy) {
        int pcHealth = pc.getHealth();
        int enemyHealth = enemy.getHealth();
        int pcStartingActionPoints = pc.getActionPoints();
        int pcActionPoints = pcStartingActionPoints;

        while (pcHealth > 0 && enemyHealth > 0) {

            //TODO TEXT BASED SYSTEM IS ONLY TEMP, REDO ONCE ASSETS ARE READY, IMPLEMENT ACTIONS FROM THEIR RELEVANT CLASSES
            System.out.println("Player HP: " + pcHealth + "  |  enemy HP: " + enemyHealth);
            if (playerTurn) {
                pcActionPoints = pcStartingActionPoints;
                System.out.println("Your turn! Available actions:");
                System.out.println("1. Attack");
                System.out.println("2. Defend");
                int selection = scanner.nextInt();
                if (selection == 1) {
                    System.out.println("You attacked for " + pc.getStrength() + " damage!");
                    pc.basicAttack(pc, enemy);
                }
                else if (selection == 2) {
                    System.out.println("You gained 10 armour!");
                    pc.basicDefend(pc);
                }
                playerTurn = false;
            }
            else if (!playerTurn){
                System.out.println();
                System.out.println("enemy attacks for " + enemy.getStrength() + " damage!");
                enemy.basicAttack(enemy, pc);
                playerTurn = true;
            }
        }

        if (pcHealth <= 0) {
            System.out.println("GAME OVER");
        }
        else {
            System.out.println("VICTORY");
            pc.setHealth(pcHealth);
            lootDrop(enemy.getLootChance(), pc);
        }
    }

    private void lootDrop(int lootChance, PlayerCharacter pc){
        int totalGold = pc.getGold() + 10 * lootChance;
        pc.setGold(totalGold);
        System.out.println("You now have " + totalGold + " gold!");
    }
}
