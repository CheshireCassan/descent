package com.descent;

public class Enemy {
    private int health;
    private int armour;
    private int strength;
    private int dodge;
    private int lootChance;

    public Enemy(int health, int armour, int strength, int dodge, int lootChance) {
        this.health = health;
        this.armour = armour;
        this.strength = strength;
        this.dodge = dodge;
        this.lootChance = lootChance;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getArmour() {
        return armour;
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDodge() {
        return dodge;
    }

    public void setDodge(int dodge) {
        this.dodge = dodge;
    }

    public int getLootChance() {
        return lootChance;
    }

    public void setLootChance(int lootChance) {
        this.lootChance = lootChance;
    }
}
