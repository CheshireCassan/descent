package com.descent.equipment;

import com.descent.EnumStatBonuses;
import com.descent.playercharacter.PlayerCharacter;

public class EquipmentProtectionWard extends Equipment {
    private String name = "Protection Ward";
    private String bonus = "" + EnumStatBonuses.medEndurance.getStat() + " Endurance";

    public String getName(){
        return name;
    }

    public String getBonus(){
        return bonus;
    }

    @Override
    public void statBonus(PlayerCharacter pc){
        pc.setEndurance(pc.getEndurance() + EnumStatBonuses.medEndurance.getStat());
    }
}
