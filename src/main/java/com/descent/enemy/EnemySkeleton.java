package com.descent.enemy;

import com.descent.EnumStatBonuses;

public class EnemySkeleton extends Enemy {
    public EnemySkeleton(int health, int armour, int strength, int dodge, int lootChance, int critChance) {
        super(health, armour, strength, dodge, lootChance, critChance);
    }
    public EnemySkeleton(){
    }

    @Override
    public void selfBuff(Enemy enemy){
        enemy.setHealth(enemy.getHealth() + EnumStatBonuses.medHealth.getStat());
    }
}
