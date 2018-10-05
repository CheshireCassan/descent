import com.descent.MapGen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MapGenTest {
    private MapGen mG = new MapGen();

    @Test
    private void MapTileCount(){
        mG.generateMap();

        final int expected = mG.getDESIRED_TILE_COUNT() + 1;
        final int actual = mG.getMapTiles().size();

        Assert.assertEquals(expected, actual);

    }

}
