package entities.enemies;

import gamelogic.SoundEffect;
import graphics.Sprite;
import javafx.scene.image.Image;

public class Oneal extends Enemy {
    public Oneal(int x, int y, Image oneal) {
        super(x, y, oneal);
        score = 500;
        speed = 2;
        movingEnemy = new MovingEnemy(MovingEnemy.IQ.MEDIUM,
                ableToPassBrick, ableToPassWall);
    }

    public Oneal(int x, int y) {
        super(x, y, Sprite.oneal_right);
        score = 200;
        speed = 2;
        movingEnemy = new MovingEnemy(MovingEnemy.IQ.MEDIUM,
                ableToPassBrick, ableToPassWall);
    }

    public void playAnimation() {
        if (alive) {
            switch (currentDirection) {
                case UP:
                case RIGHT:
                    image = Sprite.playSpriteAnimation(Sprite.oneal_right
                            , Sprite.oneal_right_1, Sprite.oneal_right_2, animate, 30);
                    break;
                case DOWN:
                case LEFT:
                    image = Sprite.playSpriteAnimation(Sprite.oneal_left
                            , Sprite.oneal_left_1, Sprite.oneal_left_2, animate, 30);
                    break;
            }
        }
        else {
            SoundEffect.ENEMY_KILL.play(false);
            image = Sprite.playSpriteAnimation(Sprite.mob_dead_1
                    , Sprite.mob_dead_2, Sprite.mob_dead_3, animate, 30);
        }
    }

    public Image getUpImage() {
        return Sprite.oneal_right;
    }

    public Image getDownImage() {
        return Sprite.oneal_left;
    }

    public Image getRightImage() {
        return Sprite.oneal_right;
    }

    public Image getLeftImage() {
        return Sprite.oneal_left;
    }
}
