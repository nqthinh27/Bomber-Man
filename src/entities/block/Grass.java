package entities.block;

import entities.Entity;
import entities.RectangleBox;
import graphics.Sprite;

public class Grass extends Entity {

    public Grass(int x, int y) {
        super(x, y, Sprite.grass);
        boundedBox = new RectangleBox(x, y, Sprite.BLOCK_SIZE, Sprite.BLOCK_SIZE);
    }

    public void update() {

    }
}
