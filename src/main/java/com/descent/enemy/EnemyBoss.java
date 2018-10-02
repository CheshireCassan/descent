package com.descent.enemy;

import com.descent.EnumStatBonuses;
import com.descent.playercharacter.PlayerCharacter;

public class EnemyBoss extends Enemy {

    public EnemyBoss(int health, int armour, int strength, int dodge, int lootChance, int critChance) {
        super(health, armour, strength, dodge, lootChance, critChance);
    }

    public EnemyBoss(){}

    public void tankUp(EnemyBoss boss) {
        boss.setArmour(100);
    }

    @Override
    public void selfBuff(Enemy boss){
        boss.setStrength(boss.getStrength() + EnumStatBonuses.largeStrength.getStat());
    }

    public void focusedAttack(EnemyBoss boss, PlayerCharacter pc) {
        int startingCrit = boss.getCritChance();
        boss.setCritChance(startingCrit + EnumStatBonuses.largeCritChance.getStat());
        boss.basicAttack(boss, pc);
        boss.setCritChance(startingCrit);
    }
}
