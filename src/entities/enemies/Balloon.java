package entities.enemies;

import gamelogic.SoundEffect;
import graphics.Sprite;
import javafx.scene.image.Image;

public class Balloon extends Enemy{

    public Balloon(int x, int y, Image balloon) {
        super(x, y, balloon);
        score = 100;
        speed = 1;
        movingEnemy = new MovingEnemy(MovingEnemy.IQ.LOW,
                ableToPassBrick, ableToPassWall);
    }

    public Balloon(int x, int y) {
        super(x, y, Sprite.balloon_right);
        score = 100;
        speed = 1;
        movingEnemy = new MovingEnemy(MovingEnemy.IQ.LOW,
                ableToPassBrick, ableToPassWall);
    }

    public void playAnimation() {
        if (alive) {
            switch (currentDirection) {
                case UP:
                case RIGHT:
                    image = Sprite.playSpriteAnimation(Sprite.balloon_right
                            , Sprite.balloon_right_1, Sprite.balloon_right_2, animate, 30);
                    break;
                case DOWN:
                case LEFT:
                    image = Sprite.playSpriteAnimation(Sprite.balloon_left
                            , Sprite.balloon_left_1, Sprite.balloon_left_2, animate, 30);
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
        return Sprite.balloon_right;
    }

    public Image getDownImage() {
        return Sprite.balloon_left;
    }

    public Image getRightImage() {
        return Sprite.balloon_right;
    }

    public Image getLeftImage() {
        return Sprite.balloon_left;
    }
}
