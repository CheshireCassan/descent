package com.descent;

public class EquipmentRefinedBlade extends Equipment {
    @Override
    public void statBonus(PlayerCharacter pc){
        pc.setStrength(pc.getStrength() + EnumStatBonuses.medStrength.getStat());
    }
}
