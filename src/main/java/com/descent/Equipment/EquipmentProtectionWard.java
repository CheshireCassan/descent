package com.descent;

public class EquipmentProtectionWard extends Equipment {
    @Override
    public void statBonus(PlayerCharacter pc){
        pc.setEndurance(pc.getEndurance() + EnumStatBonuses.medEndurance.getStat());
    }
}
