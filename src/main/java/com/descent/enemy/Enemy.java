package com.descent.enemy;

import com.descent.playercharacter.PlayerCharacter;

import java.util.Random;

public class Enemy implements IEnemyAbilities {
    private int health;
    private int armour;
    private int strength;
    private int dodge;
    private int lootChance;
    private int critChance;

    private Random rnd = new Random();


    public Enemy(int health, int armour, int strength, int dodge, int lootChance, int critChance) {
        this.health = health;
        this.armour = armour;
        this.strength = strength;
        this.dodge = dodge;
        this.lootChance = lootChance;
        this.critChance = critChance;
    }

    public Enemy(){
    }

    public int getCritChance() {
        return critChance;
    }

    public void setCritChance(int critChance) {
        this.critChance = critChance;
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

    @Override
    public void basicAttack(Enemy enemy, PlayerCharacter pc) {
        int pcHP = pc.getHealth();
        int pcArmor = pc.getArmour();
        int hitChance = rnd.nextInt(101);
        if (hitChance > pc.getDodge()) {
            int totalDamage = enemy.getStrength();
            int crit = rnd.nextInt(101);
            if (crit < enemy.getCritChance()) {
                totalDamage = totalDamage + enemy.getStrength();
                //TODO Add 'CRITICAL' pop up
            }
            if (totalDamage <= pcArmor){
                pc.setArmour(pcArmor - totalDamage);
            }
            else {
                pcHP = pcHP + pcArmor - totalDamage;
                pc.setHealth(pcHP);
            }
        }
        else {
            //TODO Add 'DODGED' pop up
        }
    }

    @Override
    public void basicDefend(Enemy enemy) {
        enemy.setArmour(enemy.getArmour() + 10);
    }
}
