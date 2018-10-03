package com.descent.enemy;

import java.util.Random;

public class EnemyGenerator {

    private Random rnd = new Random();

    public Enemy generateEnemy(){
        int selection = rnd.nextInt(3);

        switch (selection){
            case 0:
                EnemySkeleton enemySkeleton = new EnemySkeleton(65, 0, 10, 15, 25, 10);
                return enemySkeleton;
            case 1:
                EnemyBat enemyBat = new EnemyBat(45, 0, 10, 25, 25, 15);
                return enemyBat;
            case 2:
                EnemyBrute enemyBrute = new EnemyBrute(80, 0, 15, 0, 25, 10);
                return enemyBrute;
        }

        return null;
    }

}
