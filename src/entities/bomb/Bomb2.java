package entities.bomb;

import entities.Entity;
import entities.block.Brick;
import gamelogic.Director;
import entities.AnimatedEntity;
import entities.player.Player;
import entities.player.Player2;
import entities.RectangleBox;
import gameplay.MapCreate;
import graphics.Sprite;

public class Bomb2 extends AnimatedEntity {
    private int countDownTime = 120;
    private int removeTime = 30;
    private boolean allowToPass2 = true;
    private boolean exploded = false;

    public Bomb2(int x, int y) {
        super(x, y, Sprite.bomb);
        boundedBox = new RectangleBox(x, y, Sprite.SCALED_SIZE, Sprite.SCALED_SIZE);
    }

    public void update() {
        if (countDownTime > 0) {
            countDownTime--;
        } else {
            if (!exploded) {
                setExplosions();
                exploded = true;
            }
            if (removeTime > 0) {
                removeTime--;
            } else {
                MapCreate.mapMatrix[y_node][x_node] = ' ';
                remove();
            }
        }
        animation();
        playAnimation();
        setAllowToPass();
    }

    public void playAnimation() {
        if (exploded) {
            image = Sprite.playSpriteAnimation(Sprite.bomb_exploded
                    , Sprite.bomb_exploded_1, Sprite.bomb_exploded_2, animate, 30);
        } else {
            image = Sprite.playSpriteAnimation(Sprite.bomb
                    , Sprite.bomb_1, Sprite.bomb_2, animate, 50);
        }
    }

    private void setAllowToPass() {
        if (!isColliding(Player2.getPlayer())) {
            allowToPass2 = false;
        }
    }

    public boolean allowToPass2() {
        return allowToPass2;
    }

    public void setExplosions() {
        ExplosionDirection[] explosions = new ExplosionDirection[4];
        Entity entity = MapCreate.getFixedEntityAt(x_pos, y_pos);
        if (entity instanceof Brick) {
            ((Brick) entity).setExploded();
        }
        for (int i = 0; i < explosions.length; i++) {
            explosions[i] = new ExplosionDirection(x_pos, y_pos, Director.dir[i], Player.getPlayer().getBombRadius());
            for (int j = 0; j < explosions[i].getExplosions().length; j++) {
                MapCreate.getTopLayer().add(explosions[i].getExplosions()[j]);
            }
        }
    }
}

