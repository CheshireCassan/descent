package com.descent.playercharacter;

import com.descent.EnumStatBonuses;
import com.descent.enemy.Enemy;

import java.util.Random;

public class PlayerCharacter {
    private int health;
    private int armour;
    private int gold;
    private int strength;
    private int dodge;
    private int endurance;
    private int actionPoints;
    private int critChance;

    private Random rnd = new Random();

    public PlayerCharacter(int health, int armour, int gold, int strength, int dodge, int endurance, int actionPoints, int critChance) {
        this.health = health;
        this.armour = armour;
        this.gold = gold;
        this.strength = strength;
        this.dodge = dodge;
        this.endurance = endurance;
        this.actionPoints = actionPoints;
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

    public int getCritChance() {
        return critChance;
    }

    public void setCritChance(int critChance) {
        this.critChance = critChance;
    }

    public void basicAttack(PlayerCharacter pc, Enemy enemy) {
        int enemyHP = enemy.getHealth();
        int enemyArmor = enemy.getArmour();
        int hitChance = rnd.nextInt(101);
        if (hitChance > enemy.getDodge()) {
            int totalDamage = pc.getStrength();
            int crit = rnd.nextInt(101);
            if (crit < pc.getCritChance()) {
                totalDamage = totalDamage + pc.getStrength();
                //TODO Add 'CRITICAL' pop up
            }
            if (totalDamage <= enemyArmor){
                enemy.setArmour(enemyArmor - totalDamage);
            }
            else {
                enemyHP = enemyHP + enemyArmor - totalDamage;
                enemy.setHealth(enemyHP);
            }
        }
        else {
            //TODO Add 'MISSED' pop up
        }
        pc.setActionPoints(pc.getActionPoints() - 1);
    }

    public void basicDefend(PlayerCharacter pc) {
        pc.setArmour(pc.getArmour() + pc.getEndurance());
        pc.setActionPoints(pc.getActionPoints() - 1);
    }

    public PlayerCharacterDemonForm transform(PlayerCharacter pc){
        PlayerCharacterDemonForm pcdf = new PlayerCharacterDemonForm(
                pc.getHealth() + 200, pc.getArmour(), pc.getGold(), pc.getStrength() * 2,
                pc.getDodge() + EnumStatBonuses.largeDodge.getStat(), pc.getEndurance() * 2,
                pc.getActionPoints() + 2, pc.getCritChance() + EnumStatBonuses.largeCritChance.getStat());
        return pcdf;
    }

}
