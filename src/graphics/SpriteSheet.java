package graphics;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.Objects;

public class SpriteSheet {
    private final int SIZE_X;
    private final int SIZE_Y;
    private final Image image;
    private final Image[][] spriteImages;
    private final int axisX;
    private final int axisY;

    private static final int TRANSPARENT_COLOR = 0xffff00ff;
    private static final int spriteWidth = 48;
    private static final int spriteHeight = 48;
    private static final int spriteSheetSize = 768;

    public static SpriteSheet tiles = new SpriteSheet("/textures/texture.png", spriteSheetSize
            , spriteSheetSize, spriteWidth, spriteHeight);

    public SpriteSheet(String filePath, int sizeX, int sizeY, int x, int y) {
        SIZE_X = sizeX;
        SIZE_Y = sizeY;
        image = removeBackground(new Image(Objects.requireNonNull(SpriteSheet.class.getResourceAsStream(filePath))));
        axisX = SIZE_X / x;
        axisY = SIZE_Y / y;
        spriteImages = new Image[axisX][axisY];
        this.splitImage();
    }

    private Image removeBackground(Image image) {
        WritableImage writableImage = new WritableImage(SIZE_X, SIZE_Y);
        PixelWriter pixelWriter = writableImage.getPixelWriter();
        PixelReader pixelReader = image.getPixelReader();
        for (int x = 0; x < SIZE_X; x++) {
            for (int y = 0; y < SIZE_Y; y++) {
                if (pixelReader.getArgb(x, y) == SpriteSheet.TRANSPARENT_COLOR) {
                    pixelWriter.setColor(x, y, Color.TRANSPARENT);
                } else {
                    pixelWriter.setColor(x, y, pixelReader.getColor(x, y));
                }
            }
        }
        return writableImage;
    }

    private void splitImage() {
        for (int x = 0; x < axisX; x++) {
            for (int y = 0; y < axisY; y++) {
                spriteImages[x][y] = cropImage(x * spriteWidth, y * spriteHeight);
            }
        }
    }

    private Image cropImage(int x, int y) {
        PixelReader reader = image.getPixelReader();
        return new WritableImage(reader, x, y, SpriteSheet.spriteWidth, SpriteSheet.spriteHeight);
    }

    public Image[][] scaleAll(int scaleRatio) {
        for (int i = 0; i < axisX; i++) {
            for (int j = 0; j < axisY; j++) {
                spriteImages[i][j] = scaleImage(spriteImages[i][j], scaleRatio);
            }
        }
        return spriteImages;
    }

    public static Image scaleImage(Image image, int scaleRatio) {
        PixelReader pixelReader = image.getPixelReader();
        int scaledWidth = (int) image.getWidth() * scaleRatio;
        int scaledHeight = (int) image.getHeight() * scaleRatio;
        WritableImage writableImage = new WritableImage(scaledWidth, scaledHeight);
        PixelWriter pixelWriter = writableImage.getPixelWriter();
        for (int i = -1; i < scaledWidth; ++i) {
            for (int j = -1; j < scaledWidth; ++j) {
                if (i >= 0 && j >= 0) {
                    pixelWriter.setColor(i, j, pixelReader.getColor(i / scaleRatio, j / scaleRatio));
                }
            }
        }
        return writableImage;
    }
}
