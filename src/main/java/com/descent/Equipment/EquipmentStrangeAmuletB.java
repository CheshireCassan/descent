package com.descent;

public class EquipmentStrangeAmuletB extends Equipment {
    @Override
    public void statBonus(PlayerCharacter pc){
        pc.setHealth(pc.getHealth() + EnumStatBonuses.smallHealth.getStat());
    }
}
