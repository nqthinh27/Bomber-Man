package entities.enemies;

import gamelogic.SoundEffect;
import graphics.Sprite;
import javafx.scene.image.Image;

public class Kondoria extends Enemy {

    public Kondoria(int x, int y, Image kondoria) {
        super(x, y, kondoria);
        score = 1000;
        ableToPassBrick = true;
        speed = 2;
        movingEnemy = new MovingEnemy(MovingEnemy.IQ.MEDIUM,
                ableToPassBrick, ableToPassWall);
    }

    public Kondoria(int x, int y) {
        super(x, y, Sprite.kondoria_right);
        score = 1000;
        ableToPassBrick = true;
        speed = 2;
        movingEnemy = new MovingEnemy(MovingEnemy.IQ.MEDIUM,
                ableToPassBrick, ableToPassWall);
    }


    public void playAnimation() {
        if (alive) {
            switch (currentDirection) {
                case UP:
                case RIGHT:
                    image = Sprite.playSpriteAnimation(Sprite.kondoria_right
                            , Sprite.kondoria_right_1, Sprite.kondoria_right_2, animate, 60);
                    break;
                case DOWN:
                case LEFT:
                    image = Sprite.playSpriteAnimation(Sprite.kondoria_left
                            , Sprite.kondoria_left_1, Sprite.kondoria_left_2, animate, 60);
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
        return Sprite.kondoria_right;
    }

    public Image getDownImage() {
        return Sprite.kondoria_left;
    }

    public Image getRightImage() {
        return Sprite.kondoria_right;
    }

    public Image getLeftImage() {
        return Sprite.kondoria_left;
    }

}
