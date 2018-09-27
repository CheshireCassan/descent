package com.descent;

public class EquipmentCloak extends Equipment{
    @Override
    public void statBonus(PlayerCharacter pc) {
        pc.setDodge(pc.getDodge() + EnumStatBonuses.medDodge.getStat());
    }
}
