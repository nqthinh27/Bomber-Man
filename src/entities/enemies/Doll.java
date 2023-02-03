package entities.enemies;

import gamelogic.SoundEffect;
import graphics.Sprite;
import javafx.scene.image.Image;

public class Doll extends Enemy {

    public Doll(int x, int y) {
        super(x, y, Sprite.doll_right);
        score = 200;
        speed = 2;
        movingEnemy = new MovingEnemy(MovingEnemy.IQ.LOW,
                ableToPassBrick, ableToPassWall);
    }

    public void playAnimation() {
        if (alive) {
            switch (currentDirection) {
                case UP:
                case RIGHT:
                    image = Sprite.playSpriteAnimation(Sprite.doll_right
                            , Sprite.doll_right_1, Sprite.doll_right_2, animate, 20);
                    break;
                case DOWN:
                case LEFT:
                    image = Sprite.playSpriteAnimation(Sprite.doll_left
                            , Sprite.doll_left_1, Sprite.doll_left_2, animate, 20);
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
        return Sprite.doll_right;
    }

    public Image getDownImage() {
        return Sprite.doll_left;
    }

    public Image getRightImage() {
        return Sprite.doll_right;
    }

    public Image getLeftImage() {
        return Sprite.doll_left;
    }

}
