package com.descent;

import com.descent.playercharacter.PlayerCharacter;

public class Merchant {

    public void healPlayer(PlayerCharacter pc) {
        pc.setGold(pc.getGold() - 50);
        pc.setHealth(pc.getHealth() + 25);
    }

}
