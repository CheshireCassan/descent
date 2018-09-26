package com.descent;

public class EnemyBrute extends Enemy{
    public EnemyBrute(int health, int armour, int strength, int dodge, int lootChance, int critChance) {
        super(health, armour, strength, dodge, lootChance, critChance);
    }

    public EnemyBrute(){
    }

    public void gainStrength(EnemyBrute enemy) {
        enemy.setStrength(enemy.getStrength() + EnumStatBonuses.smallStrength.getStat());
    }
}
