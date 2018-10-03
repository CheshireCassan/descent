package com.descent.fx;

import com.descent.fx.map.MapScreen;
import com.descent.playercharacter.PlayerCharacter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class TitleScreen {

    boolean titleScreenOn;

    public void showTitleScreen(Canvas canvas, GraphicsContext gc, Scene theScene) {

        PlayerCharacter pc = new PlayerCharacter(
                100, 0, 0, 10, 10, 5, 3, 5);

        Image titleBG = new Image("backgrounds/mainmenubg.png");
        gc.drawImage(titleBG, 0, 0);
        Image logo = new Image("misc/logo.png");
        gc.drawImage(logo, 240, 200);

        Image begin = new Image("buttons/beginbtn.png");
        HBox hbox = new HBox();
        hbox.setLayoutX(320);
        hbox.setLayoutY(500);

        Button beginBtn = new Button();
        beginBtn.setGraphic(new ImageView(begin));
        beginBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MapScreen ms = new MapScreen();
                ms.createMap(gc, theScene, pc);
                hbox.getChildren().remove(beginBtn);
            }

        });
        hbox.getChildren().add(beginBtn);
        ((Group)theScene.getRoot()).getChildren().add(hbox);
    }
}
