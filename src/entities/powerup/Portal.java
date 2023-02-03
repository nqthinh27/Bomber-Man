package entities.powerup;

import entities.player.Player;
import gamelogic.SoundEffect;
import gameplay.MapCreate;
import graphics.Sprite;
import javafx.scene.image.Image;

public class Portal extends Powerup {
    public Portal(int x, int y) {
        super(x, y, Sprite.portal);
    }
    public Portal(int x, int y, Image powerup) {
        super(x, y, powerup);
    }

    public void checkPlayerCollision() {
        if (isColliding(Player.getPlayer()) && MapCreate.getEnemyLayer().size() == 0) {
            SoundEffect.GAME_START.play(false);
            MapCreate.nextLevel();
        }
    }

    public void checkPlayer2Collision() {
    }

    public void update() {
        checkPlayerCollision();
    }
}