package com.descent.equipment;

import com.descent.EnumStatBonuses;
import com.descent.playercharacter.PlayerCharacter;

public class EquipmentVitalityAmulet extends Equipment {

    private String name = "Vitality Amulet";
    private String bonus = "" + EnumStatBonuses.medHealth.getStat() + " Max Health";

    public String getName(){
        return name;
    }

    public String getBonus(){
        return bonus;
    }

    @Override
    public void statBonus(PlayerCharacter pc){
        pc.setHealth(pc.getHealth() + EnumStatBonuses.medHealth.getStat());
    }
}
