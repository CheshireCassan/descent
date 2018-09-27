package com.descent.equipment;

import com.descent.EnumStatBonuses;
import com.descent.playercharacter.PlayerCharacter;

public class EquipmentRefinedBlade extends Equipment {
    @Override
    public void statBonus(PlayerCharacter pc){
        pc.setStrength(pc.getStrength() + EnumStatBonuses.medStrength.getStat());
    }
}