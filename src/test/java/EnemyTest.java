import com.descent.enemy.Enemy;
import com.descent.playercharacter.PlayerCharacter;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EnemyTest {
    private Enemy enemy = new Enemy();
    private PlayerCharacter pc = new PlayerCharacter();

    @Test
    private void damageAppliedProperly(){
        enemy.setStrength(10);
        enemy.setCritChance(0);
        pc.setHealth(20);
        pc.setDodge(0);

        enemy.basicAttack(enemy, pc);

        final int expected = 10;
        final int actual = pc.getHealth();

        Assert.assertEquals(expected, actual);
    }

    @Test
    private void blockAppliedProperly(){
        enemy.setArmour(0);
        enemy.basicDefend(enemy);
        final int expected = 10;
        final int actual = enemy.getArmour();

        Assert.assertEquals(expected, actual);
    }

}
