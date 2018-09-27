package com.descent;

public enum EnumStatBonuses {
    smallHealth(5), medHealth(25), largeHealth(50),
    smallStrength(2), medStrength(5), largeStrength(7),
    smallDodge(5), medDodge(15), largeDodge(30),
    smallEndurance(2), medEndurance(5), largeEndurance(8),
    smallCritChance(5), medCritChance(10), largeCritChance(15);

    private int stat;

    EnumStatBonuses(int stat) {
        this.stat = stat;
    }

    public int getStat(){
        return stat;
    }
}
