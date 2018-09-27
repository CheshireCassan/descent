package com.descent.enemy;

import com.descent.EnumStatBonuses;

public class EnemySkeleton extends Enemy {
    public EnemySkeleton(int health, int armour, int strength, int dodge, int lootChance, int critChance) {
        super(health, armour, strength, dodge, lootChance, critChance);
    }
    public EnemySkeleton(){
    }

    public void reconstruct(EnemySkeleton enemy){
        enemy.setHealth(enemy.getHealth() + EnumStatBonuses.medHealth.getStat());
    }
}
