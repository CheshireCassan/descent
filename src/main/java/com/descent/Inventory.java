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

        //Positions for start of the inventory display
        int xPosition = 700;
        int yPosition = 70;

        //Increasing Y each time to get each item on a new line
        for (int i = 0; i < pc.getInventory().size(); i++) {
            String display = pc.getInventory().get(i).getName() + ": + " + pc.getInventory().get(i).getBonus();
            gc.fillText(display,xPosition, yPosition);
            yPosition = yPosition + 30;
        }
    }

    public void displayInventoryCombat(PlayerCharacter pc, GraphicsContext gc, Scene theScene) {
        gc.setFill( Color.BLACK );
        gc.setLineWidth(2);
        Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 22 );
        gc.setFont( theFont );

        gc.fillText("Inventory: ", 50, 40);

        int xPosition = 50;
        int yPosition = 70;

        for (int i = 0; i < pc.getInventory().size(); i++) {
            String display = pc.getInventory().get(i).getName() + ": + " + pc.getInventory().get(i).getBonus();
            gc.fillText(display,xPosition, yPosition);
            yPosition = yPosition + 30;
        }
    }
}
