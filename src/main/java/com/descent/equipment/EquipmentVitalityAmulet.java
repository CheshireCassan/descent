package com.descent;

public class EquipmentVitalityAmulet extends Equipment {
    @Override
    public void statBonus(PlayerCharacter pc){
        pc.setHealth(pc.getHealth() + EnumStatBonuses.medHealth.getStat());
    }
}
