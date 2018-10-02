package com.descent;

import com.descent.enemy.*;
import com.descent.fx.map.BossTile;
import com.descent.fx.map.FinalShopTile;
import com.descent.fx.map.MapTile;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapGen {

    private final int DESIRED_TILE_COUNT = 10;
    private Random rnd = new Random();
    private int merchantCount;
    private int encounterCount;
    private int enemyCount;
    private int totalTileCount = 0;

    private List<MapTile> mapTiles = new ArrayList<>();

    public void generateMap() {

        for (int i = 0; i <= DESIRED_TILE_COUNT; i++) {

            if (totalTileCount == DESIRED_TILE_COUNT)
                createBoss();

                // Tile before the boss should always be a merchant
            else if (totalTileCount == DESIRED_TILE_COUNT - 1)
                createFinalMerchant();


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
                        break;
                    case 1:
                        createMerchant();
                        break;
                    case 2:
                        createEncounter();
                        break;
                }
            }
        }
    }


    private void createEnemy(){
        Enemy enemy = enemyChoice();
        enemyCount++;
        totalTileCount++;
        mapTiles.add(new MapTile());
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
        mapTiles.add(new MapTile());
    }

    private void createFinalMerchant() {
        totalTileCount++;
        mapTiles.add(new FinalShopTile());
    }

    private void createEncounter(){
        encounterCount++;
        totalTileCount++;
        mapTiles.add(new MapTile());
    }

    private void createBoss(){
        EnemyBoss boss = new EnemyBoss();
        mapTiles.add(new BossTile());
    }

    public List<MapTile> getMapTiles(){
        return mapTiles;
    }
}
