package com.descent.equipment;

import com.descent.EnumStatBonuses;
import com.descent.playercharacter.PlayerCharacter;

public class EquipmentProtectionWard extends Equipment {

    public String getName(){
        return "Protection Ward";
    }

    public String getBonus(){
        return "" + EnumStatBonuses.medEndurance.getStat() + " Endurance";
    }

    @Override
    public void statBonus(PlayerCharacter pc){
        pc.setEndurance(pc.getEndurance() + EnumStatBonuses.medEndurance.getStat());
    }
}
