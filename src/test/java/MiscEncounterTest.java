import com.descent.encounters.MiscEncounter;
import com.descent.playercharacter.PlayerCharacter;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MiscEncounterTest {
    private MiscEncounter miscEncounter = new MiscEncounter();
    private PlayerCharacter pc = new PlayerCharacter();

    @Test
    public void goldIsRewardedProperly(){
        pc.setGold(0);
        final int expected = miscEncounter.getGoldReward();
        miscEncounter.giveGold(pc);
        final int actual = pc.getGold();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void equipmentAssignedProperly(){
        miscEncounter.giveEquipment(pc);
        final int expected = 1;
        final int actual = pc.getInventory().size();
        Assert.assertEquals(expected, actual);
    }

}
