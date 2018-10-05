package com.descent.equipment;

import com.descent.playercharacter.PlayerCharacter;

public class EquipmentEnergyRing extends Equipment {

    public String getName(){
        return "Energy Ring";
    }

    public String getBonus(){
        return "1 Action Points";
    }

    @Override
    public void statBonus(PlayerCharacter pc){
        pc.setActionPoints(pc.getActionPoints() + 1);
    }
}
