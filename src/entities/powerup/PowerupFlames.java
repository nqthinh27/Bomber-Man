package entities.powerup;

import entities.player.Player;
import entities.player.Player2;
import gamelogic.SoundEffect;
import graphics.Sprite;

import gameplay.MapCreate;

public class PowerupFlames extends Powerup {
    public PowerupFlames(int x, int y) {
        super(x, y, Sprite.powerup_flames);
    }

    public void checkPlayerCollision() {
        if (isColliding(Player.getPlayer())) {
            Player.getPlayer().increaseFlames();
            MapCreate.mapMatrix[y_pos / Sprite.BLOCK_SIZE][x_pos / Sprite.BLOCK_SIZE] = ' ';
            SoundEffect.EAT_PROPS.play(false);
            remove();
        }
        if (Player2.getPlayer() != null && isColliding(Player2.getPlayer())) {
            Player2.getPlayer().increaseFlames();
            MapCreate.mapMatrix[y_pos / Sprite.BLOCK_SIZE][x_pos / Sprite.BLOCK_SIZE] = ' ';
            SoundEffect.EAT_PROPS.play(false);
            remove();
        }
    }
}
