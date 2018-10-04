package com.descent.equipment;

import com.descent.EnumStatBonuses;
import com.descent.playercharacter.PlayerCharacter;

public class EquipmentRefinedBlade extends Equipment {

    private String name = "Refined Blade";
    private String bonus = "" + EnumStatBonuses.medStrength.getStat() + " Strength";

    public String getName(){
        return name;
    }

    public String getBonus(){
        return bonus;
    }

    @Override
    public void statBonus(PlayerCharacter pc){
        pc.setStrength(pc.getStrength() + EnumStatBonuses.medStrength.getStat());
    }
}
