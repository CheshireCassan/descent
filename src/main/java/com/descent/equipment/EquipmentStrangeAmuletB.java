package com.descent.equipment;

import com.descent.EnumStatBonuses;
import com.descent.playercharacter.PlayerCharacter;

public class EquipmentStrangeAmuletB extends Equipment {
    @Override
    public void statBonus(PlayerCharacter pc){
        pc.setHealth(pc.getHealth() + EnumStatBonuses.smallHealth.getStat());
    }
}
