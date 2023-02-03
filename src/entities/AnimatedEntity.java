package entities;

import javafx.scene.image.Image;

public abstract class AnimatedEntity extends Entity {

    protected int animate = 0;
    protected final int MAX_ANIMATE = 7500;

    public AnimatedEntity(int x, int y, Image image) {
        super(x, y, image);
    }

    protected void animation() {
        if (animate < MAX_ANIMATE) {
            animate++;
        } else {
            animate = 0;
        }
    }

    public abstract void playAnimation();
}
