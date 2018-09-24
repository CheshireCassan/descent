package com.descent;

public class PlayerCharacter {
    private int health;
    private int armour;
    private int gold;
    private int strength;
    private int dodge;
    private int endurance;
    private int actionPoints;

    public PlayerCharacter(int health, int armour, int gold, int strength, int dodge, int endurance, int actionPoints) {
        this.health = health;
        this.armour = armour;
        this.gold = gold;
        this.strength = strength;
        this.dodge = dodge;
        this.endurance = endurance;
        this.actionPoints = actionPoints;
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

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
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

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getActionPoints() {
        return actionPoints;
    }

    public void setActionPoints(int actionPoints) {
        this.actionPoints = actionPoints;
    }
}
