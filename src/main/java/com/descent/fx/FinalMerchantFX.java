package com.descent.fx;

import com.descent.encounters.FinalMerchant;
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

public class FinalMerchantFX {

    public void showFinalMerchant(GraphicsContext gc, Scene theScene, PlayerCharacter pc){
        updateStatInfo(pc, gc);
        HBox leaveBtnBox = new HBox();
        leaveBtnBox.setLayoutX(450);
        leaveBtnBox.setLayoutY(500);

        FinalMerchant fmerch = new FinalMerchant();

        Button healBtn = new Button("Heal (100 Gold)");
            healBtn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (pc.getGold() >= 100) {
                        fmerch.healPlayer(pc);
                        updateStatInfo(pc, gc);
                    }
                }
            });
        leaveBtnBox.getChildren().add(healBtn);

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

    private void updateStatInfo(PlayerCharacter pc, GraphicsContext gc){
        gc.clearRect(0, 0, 1080, 720);
        Image shopBG = new Image("backgrounds/mainmenubg.png");
        gc.drawImage(shopBG, 0, 0);
        gc.setFill( Color.BLACK );
        gc.setLineWidth(2);
        Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 22 );
        gc.setFont( theFont );

        gc.fillText( "Health: " + pc.getHealth(), 65, 40 );
        gc.fillText("Gold: " + pc.getGold(), 65, 70);
    }
}
