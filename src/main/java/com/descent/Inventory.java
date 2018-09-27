package com.descent;

import com.descent.equipment.Equipment;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

   private List<Equipment> inventory = new ArrayList<>();

    public List<Equipment> getInventory() {
        return inventory;
    }

    public void setInventory(List<Equipment> inventory) {
        this.inventory = inventory;
    }
}
