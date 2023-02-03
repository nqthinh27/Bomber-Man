package entities.block;

import entities.Entity;
import entities.RectangleBox;
import graphics.Sprite;

public class Wall extends Entity {
    public Wall(int x, int y) {
        super(x, y, Sprite.wall);
        boundedBox = new RectangleBox(x, y, Sprite.BLOCK_SIZE, Sprite.BLOCK_SIZE);
    }

    public void update() {
    }
}
