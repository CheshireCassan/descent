package com.descent.playercharacter;

import com.descent.enemy.Enemy;

public class PlayerCharacterDemonForm extends PlayerCharacter {

    public void focusedAttack (PlayerCharacterDemonForm pc, Enemy enemy){
        int startingCrit = pc.getCritChance();
        pc.basicAttack(pc, enemy);
        pc.setCritChance(startingCrit);
        pc.setActionPoints(pc.getActionPoints() - 1);
    }
}
