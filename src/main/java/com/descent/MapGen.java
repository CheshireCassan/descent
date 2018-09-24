package com.descent;

import java.util.Random;

public class MapGen {
    private Random rnd = new Random();
    private int merchantCount;
    private int encounterCount;
    private int enemyCount;
    private int totalTileCount;

    private void encounterChoice(){
        int encounterID = rnd.nextInt(3);

        //making sure there isn't more than the desired amount of each map tile
        while ((merchantCount >= 2 && encounterID == 1) || (encounterID == 1 && totalTileCount < 3))
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

    private void createEnemy(){
        enemyCount++;
        totalTileCount++;
    }

    private void createMerchant(){
        merchantCount++;
        totalTileCount++;
    }

    private void createEncounter(){
        encounterCount++;
        totalTileCount++;
    }
}
