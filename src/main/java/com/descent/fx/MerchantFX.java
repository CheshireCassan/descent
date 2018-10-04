package com.descent.fx;

import com.descent.Inventory;
import com.descent.encounters.Merchant;
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

public class MerchantFX {

    public void showMerchant(GraphicsContext gc, Scene theScene, PlayerCharacter pc) {
        updateStatInfo(pc, gc, theScene);
        HBox leaveBtnBox = new HBox();
        leaveBtnBox.setLayoutX(355);
        leaveBtnBox.setLayoutY(500);
        Merchant merch = new Merchant();

        Button healBtn = new Button("Heal (50 Gold)");
            healBtn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (pc.getGold() >= 50) {
                        merch.healPlayer(pc);
                        updateStatInfo(pc, gc, theScene);
                    }
                }
            });
        leaveBtnBox.getChildren().add(healBtn);

        Button buyItemBtn = new Button("Buy Equipment (" + merch.getEquipCost() + " Gold)");
        buyItemBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (pc.getGold() >= 300) {
                    merch.buyEquipment(pc);
                    updateStatInfo(pc, gc, theScene);
                }
            }
        });
        leaveBtnBox.getChildren().add(buyItemBtn);

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
        ((Group)theScene.getRoot()).getChildren().add(leaveBtnBox);
    }

    private void updateStatInfo(PlayerCharacter pc, GraphicsContext gc, Scene theScene){
        gc.clearRect(0, 0, 1080, 720);
        Image shopBG = new Image("backgrounds/mainmenubg.png");
        gc.drawImage(shopBG, 0, 0);
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
