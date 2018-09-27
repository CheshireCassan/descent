package com.descent;

public class EnemyBoss extends Enemy {

    public EnemyBoss(int health, int armour, int strength, int dodge, int lootChance, int critChance) {
        super(health, armour, strength, dodge, lootChance, critChance);
    }

    public void tankUp(EnemyBoss boss) {
        boss.setArmour(100);
    }

    public void buffUp(EnemyBoss boss) {
        boss.setStrength(boss.getStrength() + 5);
    }
}
