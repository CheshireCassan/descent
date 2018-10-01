package com.descent;

import com.descent.enemy.Enemy;
import com.descent.enemy.EnemyBat;
import com.descent.enemy.EnemyBrute;
import com.descent.enemy.EnemySkeleton;

import java.util.Random;

public class MapGen {
    private Random rnd = new Random();
    private int merchantCount;
    private int encounterCount;
    private int enemyCount;
    private int totalTileCount;

    private void encounterChoice(){

        if (totalTileCount == 10)
            createBoss();

        else if (totalTileCount == 9)
            createMerchant();

        else {
            int encounterID = rnd.nextInt(3);

            //making sure there isn't more than the desired amount of each map tile
            while ((merchantCount >= 1 && encounterID == 1) || (encounterID == 1 && totalTileCount < 3))
                encounterID = rnd.nextInt(3);
            while (encounterCount >= 4 && encounterID == 2)
                encounterID = rnd.nextInt(3);
            while (enemyCount >= 7 && encounterID == 0)
                encounterID = rnd.nextInt(3);

            switch (encounterID) {
                case 0:
                    createEnemy();
                    return;
                case 1:
                    createMerchant();
                    return;
                case 2:
                    createEncounter();
            }
        }
    }

    private void createEnemy(){
        Enemy enemy = enemyChoice();
        enemyCount++;
        totalTileCount++;
    }

    private Enemy enemyChoice(){
        int nr = rnd.nextInt(3);
        switch (nr){
            case 0:
                return new EnemySkeleton();
            case 1:
                return new EnemyBat();
            case 2:
                return new EnemyBrute();
        }
        return null;
    }

    private void createMerchant(){
        merchantCount++;
        totalTileCount++;
    }

    private void createEncounter(){
        encounterCount++;
        totalTileCount++;
    }

    private void createBoss(){

    }
}
