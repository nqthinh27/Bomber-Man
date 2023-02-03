package entities.powerup;

import entities.Entity;
import entities.RectangleBox;
import graphics.Sprite;
import javafx.scene.image.Image;

public abstract class Powerup extends Entity {
    public Powerup(int x, int y, Image powerup) {
        super(x, y, powerup);
        boundedBox = new RectangleBox(x, y, Sprite.SCALED_SIZE, Sprite.SCALED_SIZE);
    }

    public abstract void checkPlayerCollision();

    public void update() {
        checkPlayerCollision();
    }
}