package com.descent.equipment;

import com.descent.EnumStatBonuses;
import com.descent.playercharacter.PlayerCharacter;

public class EquipmentPrecisionStone extends Equipment {

    public String getName(){
        return "Precision Stone";
    }

    public String getBonus(){
        return "" + EnumStatBonuses.medCritChance.getStat() + " Crit";
    }

    @Override
    public void statBonus(PlayerCharacter pc){
        pc.setCritChance(pc.getCritChance() + EnumStatBonuses.medCritChance.getStat());
    }
}
