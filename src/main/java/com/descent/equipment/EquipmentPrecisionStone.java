package com.descent.equipment;

import com.descent.EnumStatBonuses;
import com.descent.playercharacter.PlayerCharacter;

public class EquipmentPrecisionStone extends Equipment {

    private String name = "Precision Stone";
    private String bonus = "" + EnumStatBonuses.medCritChance.getStat() + " Crit";

    public String getName(){
        return name;
    }

    public String getBonus(){
        return bonus;
    }

    @Override
    public void statBonus(PlayerCharacter pc){
        pc.setCritChance(pc.getCritChance() + EnumStatBonuses.medCritChance.getStat());
    }
}
