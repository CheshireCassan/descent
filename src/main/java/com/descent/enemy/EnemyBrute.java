package com.descent.enemy;

import com.descent.EnumStatBonuses;

public class EnemyBrute extends Enemy {
    public EnemyBrute(int health, int armour, int strength, int dodge, int lootChance, int critChance) {
        super(health, armour, strength, dodge, lootChance, critChance);
    }

    public EnemyBrute(){
    }

    @Override
    public void selfBuff(Enemy enemy){
        enemy.setStrength(enemy.getStrength() + EnumStatBonuses.smallStrength.getStat());
    }
}
