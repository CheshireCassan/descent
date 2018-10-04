package com.descent.encounters;

import com.descent.EnumStatBonuses;
import com.descent.playercharacter.PlayerCharacter;

public class FinalMerchant extends Merchant {

    @Override
    public void healPlayer(PlayerCharacter pc) {
        pc.setGold(pc.getGold() - (getHealCost() * 2));
        pc.setHealth(pc.getHealth() + EnumStatBonuses.medHealth.getStat());
    }
}
