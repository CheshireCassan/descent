package com.descent.equipment;

import com.descent.EnumStatBonuses;
import com.descent.playercharacter.PlayerCharacter;

public class EquipmentVitalityAmulet extends Equipment {

    public String getName(){
        return "Vitality Amulet";
    }

    public String getBonus(){
        return "" + EnumStatBonuses.medHealth.getStat() + " Max Health";
    }

    @Override
    public void statBonus(PlayerCharacter pc){
        pc.setHealth(pc.getHealth() + EnumStatBonuses.medHealth.getStat());
    }
}
