package com.descent.equipment;

import com.descent.EnumStatBonuses;
import com.descent.playercharacter.PlayerCharacter;

public class EquipmentRefinedBlade extends Equipment {

    public String getName(){
        return "Refined Blade";
    }

    public String getBonus(){
        return "" + EnumStatBonuses.medStrength.getStat() + " Strength";
    }

    @Override
    public void statBonus(PlayerCharacter pc){
        pc.setStrength(pc.getStrength() + EnumStatBonuses.medStrength.getStat());
    }
}
