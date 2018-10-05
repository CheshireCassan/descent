package com.descent.encounters;

import com.descent.equipment.*;
import com.descent.playercharacter.PlayerCharacter;

import java.util.Random;

public class MiscEncounter {

    private Random rnd = new Random();
    private int goldReward = 40;

    public int getGoldReward() {
        return goldReward;
    }

    public void openChest(PlayerCharacter pc) {
        int selection = rnd.nextInt(4);
        switch (selection){
            case 0:
                giveEquipment(pc);
                break;
            case 1:
            case 2:
            case 3:
                giveGold(pc);
        }
    }

    public void giveGold(PlayerCharacter pc) {
        pc.setGold(pc.getGold() + goldReward);
    }

    private Equipment generateItem(){
        int selection = rnd.nextInt(6);
        switch (selection){
            case 0:
                return new EquipmentCloak();
            case 1:
                return new EquipmentEnergyRing();
            case 2:
                return new EquipmentPrecisionStone();
            case 3:
                return new EquipmentProtectionWard();
            case 4:
                return new EquipmentRefinedBlade();
            case 5:
                return new EquipmentVitalityAmulet();
        }
        return null;
    }

    public void giveEquipment(PlayerCharacter pc){
        Equipment item = generateItem();
        item.statBonus(pc);
        pc.addToInventory(item);
    }
}
