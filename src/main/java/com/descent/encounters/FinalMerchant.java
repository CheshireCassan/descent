package com.descent.encounters;

import com.descent.playercharacter.PlayerCharacter;

public class FinalMerchant extends Merchant {

    @Override
    public void healPlayer(PlayerCharacter pc) {
        pc.setGold(pc.getGold() - 100);
        pc.setHealth(pc.getHealth() + 25);
    }
}
