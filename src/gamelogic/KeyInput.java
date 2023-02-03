package gamelogic;

import entities.player.Player;
import entities.player.Player2;
import javafx.scene.input.KeyCode;

import java.util.List;

public class KeyInput {
    private final List<KeyCode> keyBoardInputs = KeyController.getPlayerController();

    public void playerKeyHandler() {
        Player player = Player.getPlayer();

        if (keyBoardInputs.contains(KeyCode.UP)) {
            player.move(player.getSpeed(), Director.UP);
        }

        if (keyBoardInputs.contains(KeyCode.DOWN)) {
            player.move(player.getSpeed(), Director.DOWN);
        }

        if (keyBoardInputs.contains(KeyCode.LEFT)) {
            player.move(player.getSpeed(), Director.LEFT);
        }

        if (keyBoardInputs.contains(KeyCode.RIGHT)) {
            player.move(player.getSpeed(), Director.RIGHT);
        }

        if (!keyBoardInputs.contains(KeyCode.UP) && !keyBoardInputs.contains(KeyCode.W)
                && !keyBoardInputs.contains(KeyCode.DOWN) && !keyBoardInputs.contains(KeyCode.S)
                && !keyBoardInputs.contains(KeyCode.LEFT) && !keyBoardInputs.contains(KeyCode.A)
                && !keyBoardInputs.contains(KeyCode.RIGHT) && !keyBoardInputs.contains(KeyCode.D)) {
            player.move(0, Director.DOWN);
        }

        if (keyBoardInputs.contains(KeyCode.SPACE)) {
            player.placeBomb();
        }
    }

    public void player2KeyHandler() {
        Player2 player2 = Player2.getPlayer();

        if (keyBoardInputs.contains(KeyCode.W)) {
            player2.move(player2.getSpeed(), Director.UP);
        }

        if (keyBoardInputs.contains(KeyCode.S)) {
            player2.move(player2.getSpeed(), Director.DOWN);
        }

        if (keyBoardInputs.contains(KeyCode.A)) {
            player2.move(player2.getSpeed(), Director.LEFT);
        }

        if (keyBoardInputs.contains(KeyCode.D)) {
            player2.move(player2.getSpeed(), Director.RIGHT);
        }

        if (!keyBoardInputs.contains(KeyCode.W)
                && !keyBoardInputs.contains(KeyCode.S)
                && !keyBoardInputs.contains(KeyCode.A)
                && !keyBoardInputs.contains(KeyCode.D)) {
            player2.move(0, Director.DOWN);
        }

        if (keyBoardInputs.contains(KeyCode.SHIFT)) {
            player2.placeBomb();
        }
    }
}
