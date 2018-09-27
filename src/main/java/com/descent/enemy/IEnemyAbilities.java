package com.descent.enemy;

import com.descent.playercharacter.PlayerCharacter;

public interface IEnemyAbilities {
    public void basicAttack(Enemy enemy, PlayerCharacter pc);
    public void basicDefend(Enemy enemy);
}
