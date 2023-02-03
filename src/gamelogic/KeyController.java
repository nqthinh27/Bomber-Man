package gamelogic;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.List;

public class KeyController {

    public static List<KeyCode> playerController = new ArrayList<>();

    public static List<KeyCode> getPlayerController() {
        return playerController;
    }

    public static void setOnKeys(Scene scene) {
        playerController.clear();
        scene.setOnKeyPressed(event -> {
            if (!playerController.contains(event.getCode())) {
                playerController.add(event.getCode());
            }
        });
        scene.setOnKeyReleased(event -> playerController.remove(event.getCode()));
    }
}