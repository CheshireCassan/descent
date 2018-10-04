package com.descent;

import com.descent.playercharacter.PlayerCharacter;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Inventory {

    public void displayInventory (PlayerCharacter pc, GraphicsContext gc, Scene theScene){
        gc.setFill( Color.BLACK );
        gc.setLineWidth(2);
        Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 22 );
        gc.setFont( theFont );

        gc.fillText("Inventory: ", 700, 40);

        int x = 700;
        int y = 70;

        for (int i = 0; i < pc.getInventory().size(); i++) {
            String display = pc.getInventory().get(i).getName() + ": + " + pc.getInventory().get(i).getBonus();
            gc.fillText(display,x, y);
            y = y + 30;
        }
        y = 70;
    }

    public void displayInventoryCombat(PlayerCharacter pc, GraphicsContext gc, Scene theScene) {
        gc.setFill( Color.BLACK );
        gc.setLineWidth(2);
        Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 22 );
        gc.setFont( theFont );

        gc.fillText("Inventory: ", 50, 40);

        int x = 50;
        int y = 70;

        for (int i = 0; i < pc.getInventory().size(); i++) {
            String display = pc.getInventory().get(i).getName() + ": + " + pc.getInventory().get(i).getBonus();
            gc.fillText(display,x, y);
            y = y + 30;
        }
        y = 70;
    }
}
