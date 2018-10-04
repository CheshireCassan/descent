package com.descent.equipment;

import com.descent.playercharacter.PlayerCharacter;

public abstract class Equipment {

    private String name;
    private String bonus;

    public String getName(){
        return name;
    }

    public String getBonus(){
        return bonus;
    }

    public void statBonus(PlayerCharacter pc){
    }

}
