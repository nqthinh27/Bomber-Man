package entities.bomb;

import gamelogic.Director;
import entities.AnimatedEntity;
import entities.Entity;
import entities.player.Player;
import entities.RectangleBox;
import entities.block.Brick;
import graphics.Sprite;
import javafx.scene.image.Image;
import gameplay.MapCreate;
import gamelogic.SoundEffect;

public class Bomb extends AnimatedEntity {
    private int countDownTime = 120;
    private int removeTime = 30;
    private boolean allowToPass = true;
    private boolean exploded = false;

    public Bomb(int x, int y, Image boom) {
        super(x, y, boom);
        boundedBox = new RectangleBox(x, y, Sprite.SCALED_SIZE, Sprite.SCALED_SIZE);
    }

    public Bomb(int x, int y) {
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
                SoundEffect.EXPLOSION.play(false);
            }
            if (removeTime > 0) {
                removeTime--;
                if(x_pos == Player.getPlayer().getX_pos() && y_pos == Player.getPlayer().getY_pos()) {
                    Player.getPlayer().setLifeCount();
                }
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

    public boolean isExploded() {
        return exploded;
    }

    private void setAllowToPass() {
        if (!isColliding(Player.getPlayer())) {
            allowToPass = false;
        }
    }

    public boolean allowToPass() {
        return allowToPass;
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