package entities;

import gamelogic.Director;
import entities.block.Brick;
import entities.block.Wall;
import graphics.Sprite;
import javafx.scene.image.Image;
import gameplay.MapCreate;

public abstract class MovingEntity extends AnimatedEntity {
    protected Director currentDirection;
    protected boolean isMoving;
    protected boolean alive;
    protected boolean ableToPassWall = false;
    protected boolean ableToPassBrick = false;
    protected int passAwayTime = 30;
    protected int aBigStep = Sprite.BLOCK_SIZE;
    protected int speed;

    public MovingEntity(int x, int y, Image image) {
        super(x, y, image);
        isMoving = false;
        currentDirection = Director.DOWN;
    }

    public void move(int steps, Director director) {
        if (alive) {
            if (steps == 0 || director == null) {
                isMoving = false;
            } else {
                switch (director) {
                    case UP:
                        if (checkFriendlyCollisions(x_pos, y_pos - steps)) {
                            y_pos -= steps;
                            currentDirection = Director.UP;
                            isMoving = true;
                        } else {
                            isMoving = false;
                            image = this.getUpImage();
                        }
                        break;
                    case DOWN:
                        if (checkFriendlyCollisions(x_pos, y_pos + steps)) {
                            y_pos += steps;
                            currentDirection = Director.DOWN;
                            isMoving = true;
                        } else {
                            isMoving = false;
                            image = this.getDownImage();
                        }
                        break;
                    case LEFT:
                        if (checkFriendlyCollisions(x_pos - steps, y_pos)) {
                            x_pos -= steps;
                            currentDirection = Director.LEFT;
                            isMoving = true;
                        } else {
                            isMoving = false;
                            image = this.getLeftImage();
                        }
                        break;
                    case RIGHT:
                        if (checkFriendlyCollisions(x_pos + steps, y_pos)) {
                            x_pos += steps;
                            currentDirection = Director.RIGHT;
                            isMoving = true;
                        } else {
                            isMoving = false;
                            image = this.getRightImage();
                        }
                        break;
                }
            }
        }
    }

    public boolean movableSteps(int steps, Director director) {
        switch (director) {
            case UP:
                return checkFriendlyCollisions(x_pos, y_pos - steps);
            case DOWN:
                return checkFriendlyCollisions(x_pos, y_pos + steps);
            case LEFT:
                return checkFriendlyCollisions(x_pos - steps, y_pos);
            case RIGHT:
                return checkFriendlyCollisions(x_pos + steps, y_pos);
            default:
                return false;
        }
    }

    public boolean checkFriendlyCollisions(int x, int y) {
        boundedBox.setPosition(x, y);
        for (Entity entity : MapCreate.getBoardLayer()) {
            if (entity instanceof Wall && isColliding(entity) && !ableToPassWall) {
                boundedBox.setPosition(x_pos, y_pos);
                return false;
            }
        }
        for (Entity entity : MapCreate.getTopLayer()) {
            if (entity instanceof Brick && isColliding(entity) && !ableToPassBrick) {
                boundedBox.setPosition(x_pos, y_pos);
                return false;
            }
        }
        boundedBox.setPosition(x_pos, y_pos);
        return true;
    }

    public abstract Image getUpImage();

    public abstract Image getDownImage();

    public abstract Image getRightImage();

    public abstract Image getLeftImage();
}
