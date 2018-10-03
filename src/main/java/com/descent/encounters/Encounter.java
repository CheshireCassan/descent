package com.descent.encounters;
import com.descent.fx.CombatFX;
import com.descent.fx.MerchantFX;
import com.descent.fx.map.MiscEncounterFX;
import com.descent.playercharacter.PlayerCharacter;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public class Encounter {

    public void questionTileClick(List<Integer> encounterIDs, GraphicsContext gc, Scene theScene, PlayerCharacter pc){
        switch (encounterIDs.get(0)){
            case 0:
                CombatFX cfx = new CombatFX();
                cfx.startCombat(gc, theScene, pc);
                break;
            case 1:
                MerchantFX merchant = new MerchantFX();
                merchant.showMerchant(gc, theScene, pc);
                break;
            case 2:
                MiscEncounterFX encounter = new MiscEncounterFX();
                encounter.showEncounter(gc, theScene, pc);
                break;
        }
        encounterIDs.remove(0);
    }

}
