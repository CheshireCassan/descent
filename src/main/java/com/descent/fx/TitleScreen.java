package com.descent.fx;

import com.descent.fx.map.MapScreen;
import com.descent.playercharacter.PlayerCharacter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.nio.file.Paths;

public class TitleScreen {

    public void showTitleScreen(GraphicsContext gc, Scene theScene) {

        music();

        PlayerCharacter playerCharacter = new PlayerCharacter();
        PlayerCharacter pc = playerCharacter.generatePlayer();

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

    MediaPlayer mediaPlayer;
    public void music(){
        String bip = "maintheme.mp3";
        Media hit = new Media(Paths.get(bip).toUri().toString());
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }
}
