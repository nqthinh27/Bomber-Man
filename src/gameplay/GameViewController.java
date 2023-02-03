package gameplay;

import gamelogic.SoundEffect;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class GameViewController implements Initializable {
    @FXML
    private ImageView mute, unmute;

    @FXML
    public void PlaySound() {
        unmute.setVisible(true);
        mute.setVisible(false);
        SoundEffect.unmute();
        SoundEffect.GAMEPLAY.play(true);
    }

    @FXML
    public void PauseSound() {
        unmute.setVisible(false);
        mute.setVisible(true);
        SoundEffect.mute();
        SoundEffect.GAMEPLAY.stop();
    }

    public void switchToMenu(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/menu/Menu.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 850, 624);
        MapCreate.pause1 = true;
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        SoundEffect.GAMEPLAY.stop();
        SoundEffect.BACKGROUND.play(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(!SoundEffect.BACKGROUND.isPlaying()) {
            unmute.setVisible(false);
            mute.setVisible(true);
        }
    }
}