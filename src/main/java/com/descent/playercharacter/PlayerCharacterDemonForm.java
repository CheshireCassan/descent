package com.descent.playercharacter;

import com.descent.enemy.Enemy;

public class PlayerCharacterDemonForm extends PlayerCharacter {

    public PlayerCharacterDemonForm(int health, int armour, int gold, int strength, int dodge, int endurance, int actionPoints, int critChance) {
        super(health, armour, gold, strength, dodge, endurance, actionPoints, critChance);
    }

    public void focusedAttack (PlayerCharacterDemonForm pc, Enemy enemy){
        int startingCrit = pc.getCritChance();
        pc.basicAttack(pc, enemy);
        pc.setCritChance(startingCrit);
        pc.setActionPoints(pc.getActionPoints() - 1);
    }
}
