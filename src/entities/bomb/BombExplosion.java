package entities.bomb;

import gamelogic.Director;
import entities.AnimatedEntity;
import entities.RectangleBox;
import graphics.Sprite;

public class BombExplosion extends AnimatedEntity {

    private int removeTime = 60;

    private Director explosionDir;

    private boolean isLast;

    public BombExplosion(int x, int y, Director dir, boolean last) {
        super(x, y, Sprite.transparent);
        boundedBox = new RectangleBox(x , y, Sprite.SCALED_SIZE, Sprite.SCALED_SIZE);
        explosionDir = dir;
        isLast = last;
    }

    public void update() {
        if (removeTime > 0) {
            removeTime--;
        } else {
            remove();
        }
        animation();
        playAnimation();
    }

    public void playAnimation() {
        switch (explosionDir) {
            case UP:
                if (isLast) {
                    image = Sprite.playSpriteAnimation(Sprite.explosion_vertical_top_last,
                            Sprite.explosion_vertical_top_last_1, Sprite.explosion_vertical_top_last_2, animate, 60);
                } else {
                    image = Sprite.playSpriteAnimation(Sprite.explosion_vertical,
                            Sprite.explosion_vertical_1, Sprite.explosion_vertical_2, animate, 60);
                }
                break;
            case DOWN:
                if (isLast) {
                    image = Sprite.playSpriteAnimation(Sprite.explosion_vertical_down_last,
                            Sprite.explosion_vertical_down_last_1, Sprite.explosion_vertical_down_last_2, animate, 60);
                } else {
                    image = Sprite.playSpriteAnimation(Sprite.explosion_vertical,
                            Sprite.explosion_vertical_1, Sprite.explosion_vertical_2, animate, 60);
                }
                break;
            case LEFT:
                if (isLast) {
                    image = Sprite.playSpriteAnimation(Sprite.explosion_horizontal_left_last,
                            Sprite.explosion_horizontal_left_last_1, Sprite.explosion_horizontal_left_last_2, animate, 60);
                } else {
                    image = Sprite.playSpriteAnimation(Sprite.explosion_horizontal,
                            Sprite.explosion_horizontal_1, Sprite.explosion_horizontal_2, animate, 60);
                }
                break;
            case RIGHT:
                if (isLast) {
                    image = Sprite.playSpriteAnimation(Sprite.explosion_horizontal_right_last,
                            Sprite.explosion_horizontal_right_last_1, Sprite.explosion_horizontal_right_last_2, animate, 60);
                } else {
                    image = Sprite.playSpriteAnimation(Sprite.explosion_horizontal,
                            Sprite.explosion_horizontal_1, Sprite.explosion_horizontal_2, animate, 60);
                }
                break;
        }
    }
}
