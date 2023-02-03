package entities.enemies;

import entities.Entity;
import entities.MovingEntity;
import entities.RectangleBox;
import entities.bomb.Bomb;
import entities.bomb.BombExplosion;
import gameplay.MapCreate;
import javafx.scene.image.Image;

public abstract class Enemy extends MovingEntity {
    protected int score;
    protected MovingEnemy movingEnemy;

    public Enemy(int x, int y, Image image) {
        super(x, y, image);
        this.boundedBox = new RectangleBox(x, y, 48, 48);
        this.alive = true;
    }

    public int getScore() {
        return score;
    }

    public void update() {
        this.animation();
        checkBombCollision();
        if (!this.alive) {
            if (this.passAwayTime > 0) {
                --this.passAwayTime;
            } else {
                this.remove();
            }
        }
        this.playAnimation();
        try {
            this.enemySmartMoving();
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    @Override
    public boolean checkFriendlyCollisions(int x, int y) {
        boundedBox.setPosition(x, y);
        for (Entity entity : MapCreate.getTopLayer()) {
            if (entity instanceof Bomb && isColliding(entity)) {
                boundedBox.setPosition(x_pos, y_pos);
                return false;
            }
        }
        return super.checkFriendlyCollisions(x, y);
    }

    public void checkBombCollision() {
        for (Entity entity : MapCreate.getTopLayer()) {
            if (entity instanceof BombExplosion && isColliding(entity)) {
                alive = false;
                break;
            }
        }
    }

    protected void enemySmartMoving() {
        if (this.aBigStep > 0 && this.movableSteps(this.speed, this.currentDirection)) {
            this.move(this.speed, this.currentDirection);
            this.aBigStep -= this.speed;
        } else {
            this.aBigStep = 48;
            switch(this.currentDirection) {
                case UP:
                    --this.y_node;
                    break;
                case DOWN:
                    ++this.y_node;
                    break;
                case LEFT:
                    --this.x_node;
                    break;
                case RIGHT:
                    ++this.x_node;
            }
            this.currentDirection = this.movingEnemy.movingDirection(MapCreate.mapMatrix, this.x_node, this.y_node);
        }
    }
}
