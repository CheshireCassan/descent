package com.descent;

public class EquipmentPrecisionStone extends Equipment {
    @Override
    public void statBonus(PlayerCharacter pc){
        pc.setCritChance(pc.getCritChance() + EnumStatBonuses.medCritChance.getStat());
    }
}
