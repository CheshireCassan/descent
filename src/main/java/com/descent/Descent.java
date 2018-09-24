package com.descent;

public class Descent {

    public static void main(String[] args) {

        PlayerCharacter pc = new PlayerCharacter(100, 20, 0, 10, 15, 10, 5);
        EnemySkeleton enemy1 = new EnemySkeleton(70, 10, 10, 5, 20);

        Combat fight = new Combat();
        fight.combatCycle(pc, enemy1);

    }
}
