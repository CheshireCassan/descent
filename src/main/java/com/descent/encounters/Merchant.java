package com.descent.encounters;

import com.descent.equipment.*;
import com.descent.playercharacter.PlayerCharacter;

import java.util.Random;

public class Merchant {

    private Random rnd = new Random();
    private int equipCost = 300;
    private int healCost = 50;
    private int healAmount = 25;

    public int getEquipCost() {
        return equipCost;
    }

    public void setEquipCost(int equipCost) {
        this.equipCost = equipCost;
    }

    public int getHealCost() {
        return healCost;
    }

    public void setHealCost(int healCost) {
        this.healCost = healCost;
    }

    public void healPlayer(PlayerCharacter pc) {
        pc.setGold(pc.getGold() - healCost);
        pc.setHealth(pc.getHealth() + healAmount);
    }

    public Equipment generateItem(){
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

    public void buyEquipment(PlayerCharacter pc){
        pc.setGold(pc.getGold() - equipCost);
        Equipment item = generateItem();
        item.statBonus(pc);
        pc.addToInventory(item);
    }

}
