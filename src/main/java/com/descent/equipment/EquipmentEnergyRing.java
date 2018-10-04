package com.descent.equipment;

import com.descent.playercharacter.PlayerCharacter;

public class EquipmentEnergyRing extends Equipment {

    private String name = "Energy Ring";
    private String bonus = "" + 1 + " Action Points";

    public String getName(){
        return name;
    }

    public String getBonus(){
        return bonus;
    }

    @Override
    public void statBonus(PlayerCharacter pc){
        pc.setActionPoints(pc.getActionPoints() + 1);
    }
}
