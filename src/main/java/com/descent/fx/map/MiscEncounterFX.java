package com.descent.fx.map;

import com.descent.playercharacter.PlayerCharacter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;

public class MiscEncounterFX {

    public void showEncounter(GraphicsContext gc, Scene theScene, PlayerCharacter pc){
        Image encounterBG = new Image("backgrounds/mainmenubg.png");
        gc.drawImage(encounterBG, 0, 0);

        HBox leaveBtnBox = new HBox();
        leaveBtnBox.setLayoutX(400);
        leaveBtnBox.setLayoutY(500);

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

}
