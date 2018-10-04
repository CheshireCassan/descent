package com.descent.equipment;

import com.descent.EnumStatBonuses;
import com.descent.playercharacter.PlayerCharacter;

public class EquipmentCloak extends Equipment {

    private String name = "Cloak";
    private String bonus = "" + EnumStatBonuses.medDodge.getStat() + " Dodge";

    public String getName(){
        return name;
    }

    public String getBonus(){
        return bonus;
    }

    @Override
    public void statBonus(PlayerCharacter pc) {
        pc.setDodge(pc.getDodge() + EnumStatBonuses.medDodge.getStat());
    }
}
