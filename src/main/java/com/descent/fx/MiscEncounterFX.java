package com.descent.fx;

import com.descent.Inventory;
import com.descent.encounters.MiscEncounter;
import com.descent.fx.map.MapScreen;
import com.descent.playercharacter.PlayerCharacter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MiscEncounterFX {

    public void showEncounter(GraphicsContext gc, Scene theScene, PlayerCharacter pc){

        updateStatInfo(pc, gc, theScene);

        HBox leaveBtnBox = new HBox();
        leaveBtnBox.setLayoutX(510);
        leaveBtnBox.setLayoutY(500);

        gc.setFill( Color.BLACK );
        gc.setLineWidth(2);
        Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 36 );
        gc.setFont( theFont );
        gc.fillText("You found a treasure chest", 330, 300);


        Button openBtn = new Button("Open");
        openBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                leaveBtnBox.getChildren().clear();
                MiscEncounter me = new MiscEncounter();
                me.openChest(pc);
                updateStatInfo(pc, gc, theScene);
                Button leaveBtn = new Button("Leave");
                leaveBtn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        leaveBtnBox.getChildren().clear();
                        MapScreen ms = new MapScreen();
                        ms.createMap(gc, theScene, pc);
                    }
                });
                leaveBtnBox.getChildren().add(leaveBtn);
            }
        });
        leaveBtnBox.getChildren().add(openBtn);

        ((Group)theScene.getRoot()).getChildren().add(leaveBtnBox);
    }

    private void updateStatInfo(PlayerCharacter pc, GraphicsContext gc, Scene theScene){
        gc.clearRect(0, 0, 1080, 720);
        Image encounterBG = new Image("backgrounds/mainmenubg.png");
        gc.drawImage(encounterBG, 0, 0);
        gc.setFill( Color.BLACK );
        gc.setLineWidth(2);
        Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 22 );
        gc.setFont( theFont );

        gc.fillText( "Health: " + pc.getHealth(), 65, 40 );
        gc.fillText("Gold: " + pc.getGold(), 65, 70);

        Inventory inven = new Inventory();
        inven.displayInventory(pc, gc, theScene);
    }

}
