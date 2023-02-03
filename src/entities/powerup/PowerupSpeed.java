package entities.powerup;

import entities.player.Player;
import entities.player.Player2;
import gamelogic.SoundEffect;
import graphics.Sprite;
import gameplay.MapCreate;

public class PowerupSpeed extends Powerup {
    public PowerupSpeed(int x, int y) {
        super(x, y, Sprite.powerup_speed);
    }

    public void checkPlayerCollision() {
        if (isColliding(Player.getPlayer())) {
            Player.getPlayer().increaseSpeed();
            MapCreate.mapMatrix[y_pos / Sprite.BLOCK_SIZE][x_pos / Sprite.BLOCK_SIZE] = ' ';
            SoundEffect.EAT_PROPS.play(false);
            remove();
        }
        if (Player2.getPlayer() != null && isColliding(Player.getPlayer())) {
            Player2.getPlayer().increaseSpeed();
            MapCreate.mapMatrix[y_pos / Sprite.BLOCK_SIZE][x_pos / Sprite.BLOCK_SIZE] = ' ';
            SoundEffect.EAT_PROPS.play(false);
            remove();
        }
    }
}
