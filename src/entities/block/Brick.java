package entities.block;

import entities.AnimatedEntity;
import entities.RectangleBox;
import graphics.Sprite;
import javafx.scene.image.Image;
import gameplay.MapCreate;

public class Brick extends AnimatedEntity {

    private int removeTime = 30;

    private boolean exploded = false;

    public Brick(int x, int y, Image brick) {
        super(x, y, brick);
        boundedBox = new RectangleBox(x, y, Sprite.BLOCK_SIZE, Sprite.BLOCK_SIZE);
    }

    public Brick(int x, int y) {
        super(x, y, Sprite.brick);
        boundedBox = new RectangleBox(x, y, Sprite.BLOCK_SIZE, Sprite.BLOCK_SIZE);
    }

    public void playAnimation() {
        if (!exploded) {
            image = Sprite.brick;
        } else {
            image = Sprite.playSpriteAnimation(Sprite.brick_exploded
                    , Sprite.brick_exploded_1, Sprite.brick_exploded_2, animate, 30);
        }
    }

    public void update() {
        if (exploded) {
            if (removeTime > 0) {
                removeTime--;
            } else {
                remove();
                if ('*' == MapCreate.mapMatrix[y_pos / Sprite.BLOCK_SIZE][x_pos / Sprite.BLOCK_SIZE]) {
                    MapCreate.mapMatrix[y_pos / Sprite.BLOCK_SIZE][x_pos / Sprite.BLOCK_SIZE] = ' ';
                }
            }
        }
        animation();
        playAnimation();
    }

    public void setExploded() {
        exploded = true;
    }

}
