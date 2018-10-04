package com.descent;

import com.descent.fx.map.BossTile;
import com.descent.fx.map.FinalShopTile;
import com.descent.fx.map.MapTile;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapGen {

    private final int DESIRED_TILE_COUNT = 10;
    private Random rnd = new Random();

    private List<MapTile> mapTiles = new ArrayList<>();
    private List<Integer> encounterIDs = new ArrayList<>();

    public void generateMap() {

        int merchantCount = 0;
        int encounterCount = 0;
        int enemyCount = 0;
        int totalTileCount = 0;

        for (int i = 0; i <= DESIRED_TILE_COUNT; i++) {

            if (totalTileCount == DESIRED_TILE_COUNT)
                mapTiles.add(new BossTile());

                // Tile before the boss should always be a merchant
            else if (totalTileCount == DESIRED_TILE_COUNT - 1) {
                totalTileCount++;
                mapTiles.add(new FinalShopTile());
            } else {
                int encounterID = rnd.nextInt(3);

                //making sure there isn't more than the desired amount of each map tile
                while ((merchantCount >= 1 && encounterID == 1) || (encounterID == 1 && totalTileCount < 3))
                    encounterID = rnd.nextInt(3);
                while (encounterCount >= 3 && encounterID == 2)
                    encounterID = rnd.nextInt(3);
                while (enemyCount >= 7 && encounterID == 0)
                    encounterID = rnd.nextInt(3);

                switch (encounterID) {
                    case 0:
                        enemyCount++;
                        totalTileCount++;
                        mapTiles.add(new MapTile());
                        encounterIDs.add(0);
                        break;
                    case 1:
                        merchantCount++;
                        totalTileCount++;
                        mapTiles.add(new MapTile());
                        encounterIDs.add(1);
                        break;
                    case 2:
                        encounterCount++;
                        totalTileCount++;
                        mapTiles.add(new MapTile());
                        encounterIDs.add(2);
                        break;
                }
            }
        }
    }

    public List<MapTile> getMapTiles() {
        return mapTiles;
    }

    public List<Integer> getEncounterIDs() {
        return encounterIDs;
    }
}
