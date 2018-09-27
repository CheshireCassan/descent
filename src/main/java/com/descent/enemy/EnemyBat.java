package com.descent.enemy;

import com.descent.EnumStatBonuses;

public class EnemyBat extends Enemy {
    public EnemyBat(int health, int armour, int strength, int dodge, int lootChance, int critChance) {
        super(health, armour, strength, dodge, lootChance, critChance);
    }
    public EnemyBat(){
    }

    public void evasiveManeuvers(EnemyBat enemy){
        enemy.setDodge(enemy.getDodge() + EnumStatBonuses.medDodge.getStat());
    }
}
