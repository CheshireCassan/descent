package com.descent.equipment;

import com.descent.playercharacter.PlayerCharacter;

public class EquipmentEnergyRing extends Equipment {
    @Override
    public void statBonus(PlayerCharacter pc){
        pc.setActionPoints(pc.getActionPoints() + 1);
    }
}
