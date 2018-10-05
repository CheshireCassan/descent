package com.descent.equipment;

import com.descent.EnumStatBonuses;
import com.descent.playercharacter.PlayerCharacter;

public class EquipmentCloak extends Equipment {

    public String getName(){
        return "Cloak";
    }

    public String getBonus(){
        return "" + EnumStatBonuses.medDodge.getStat() + " Dodge";
    }

    @Override
    public void statBonus(PlayerCharacter pc) {
        pc.setDodge(pc.getDodge() + EnumStatBonuses.medDodge.getStat());
    }
}
