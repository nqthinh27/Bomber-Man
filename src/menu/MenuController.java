package menu;

import entities.player.Player;
import entities.player.Player2;
import gamelogic.SoundEffect;
import gameplay.*;
import graphics.Sprite;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.*;

public class MenuController implements Initializable {

    @FXML
    private Button SinglePlayerButton, ExitButton, MultiplayerButton, Button3, TutorialButton;

    @FXML
    private AnchorPane GamePane, MultiPlayerPane, ControlPane, TutorialPane;

    @FXML
    private RadioButton blue, red, green, blue1, red1, green1, blue2, red2, green2;

    @FXML
    private ToggleGroup Character, Character1, Character2;

    @FXML
    private ImageView mute, unmute;

    @FXML
    public TextField NameField, NameField1, NameField2;

    @FXML
    public void PlaySound() {
        unmute.setVisible(true);
        mute.setVisible(false);
        SoundEffect.unmute();
        SoundEffect.BACKGROUND.play(true);
    }

    @FXML
    public void PauseSound() {
        unmute.setVisible(false);
        mute.setVisible(true);
        SoundEffect.mute();
        SoundEffect.BACKGROUND.stop();
    }

    @FXML
    public void PlayGame(MouseEvent event) throws Exception {
        Stage gameStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Pane appRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/gameview/GameView.fxml")));
        Scene scene = new Scene(appRoot);
        MapCreate.initGame(appRoot, scene);
        Player.getPlayer().setName(NameField.getText());
        if (blue.isSelected()) {
            Player.getPlayer().setImage(Sprite.blue_down);
            Sprite.setBlue();
        }
        if (red.isSelected()) {
            Player.getPlayer().setImage(Sprite.red_down);
            Sprite.setRed();
        }
        if (green.isSelected()) {
            Player.getPlayer().setImage(Sprite.green_down);
            Sprite.setGreen();
        }
        gameStage.setScene(scene);
        gameStage.centerOnScreen();
        gameStage.show();
        SoundEffect.BACKGROUND.stop();
        SoundEffect.GAME_START.play(false);
        SoundEffect.GAMEPLAY.play(true);
    }

    @FXML
    public void PlayMultiPlayerGame(MouseEvent event) throws Exception {
        Stage gameStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Pane appRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/gameview/GameMPView.fxml")));
        Scene scene = new Scene(appRoot);
        MapCreate.initMultiPlayerGame(appRoot, scene);
        Player.getPlayer().setName(NameField1.getText());
        Player2.getPlayer().setName(NameField2.getText());
        if(blue1.isSelected()) {
            Player.getPlayer().setImage(Sprite.blue_down);
            Sprite.setBlue();
        }
        if(red1.isSelected()) {
            Player.getPlayer().setImage(Sprite.red_down);
            Sprite.setRed();
        }
        if(green1.isSelected()) {
            Player.getPlayer().setImage(Sprite.green_down);
            Sprite.setGreen();
        }
        if(blue2.isSelected()) {
            Player2.getPlayer().setImage(Sprite.blue_down);
            Sprite.setBlue2();
        }
        if(red2.isSelected()) {
            Player2.getPlayer().setImage(Sprite.red_down);
            Sprite.setRed2();
        }
        if(green2.isSelected()) {
            Player2.getPlayer().setImage(Sprite.green_down);
            Sprite.setGreen2();
        }
        gameStage.setScene(scene);
        gameStage.centerOnScreen();
        gameStage.show();
        SoundEffect.BACKGROUND.stop();
        SoundEffect.GAME_START.play(false);
        SoundEffect.GAMEPLAY.play(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SinglePlayerButton.setOnAction(event -> {
            if(MultiPlayerPane.getTranslateX() == -720) {
                moveChildPane(MultiPlayerPane);
            }
            if(ControlPane.getTranslateX() == -720) {
                moveChildPane(ControlPane);
            }
            else if(TutorialPane.getTranslateX() == -720) {
                moveChildPane(TutorialPane);
            }
            moveChildPane(GamePane);
        });
        MultiplayerButton.setOnAction(event -> {
            if(GamePane.getTranslateX() == -720) {
                moveChildPane(GamePane);
            }
            if(ControlPane.getTranslateX() == -720) {
                moveChildPane(ControlPane);
            }
            else if(TutorialPane.getTranslateX() == -720) {
                moveChildPane(TutorialPane);
            }
            moveChildPane(MultiPlayerPane);
        });
        Button3.setOnAction(event -> {
            if(GamePane.getTranslateX() == -720) {
                moveChildPane(GamePane);
            }
            if(MultiPlayerPane.getTranslateX() == -720) {
                moveChildPane(MultiPlayerPane);
            }
            else if(TutorialPane.getTranslateX() == -720) {
                moveChildPane(TutorialPane);
            }
            moveChildPane(ControlPane);
        });
        TutorialButton.setOnAction(event -> {
            if(GamePane.getTranslateX() == -720) {
                moveChildPane(GamePane);
            }
            if(ControlPane.getTranslateX() == -720) {
                moveChildPane(ControlPane);
            }
            else if(MultiPlayerPane.getTranslateX() == -720) {
                moveChildPane(MultiPlayerPane);
            }
            moveChildPane(TutorialPane);
        });
        ExitButton.setOnAction(event -> System.exit(0));
    }

    private void moveChildPane(AnchorPane childPane) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.3));
        slide.setNode(childPane);
        if((childPane.getTranslateX() == 0)) {
            slide.setToX(-720);
        } else {
            slide.setToX(0);
        }
        slide.play();
    }
}

