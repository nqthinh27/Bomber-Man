package gamelogic;

import entities.Entity;
import entities.player.Player;
import entities.player.Player2;
import graphics.Sprite;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import gameplay.MapCreate;

public class MultiPlayerGameLoop {
    public static void multiplayerStart(GraphicsContext graphicsContext) {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                graphicsContext.clearRect(0, 0
                        , MapCreate.mapWidth * Sprite.SCALED_SIZE
                        , MapCreate.mapHeight * Sprite.SCALED_SIZE);
                updateGame();
                MapCreate.updateMultiLabel();
                renderGame(graphicsContext);
                if(MapCreate.pause2) {
                    Player.getPlayer().resetPlayer1();
                    Player2.getPlayer().resetPlayer2();
                    stop();
                }
            }
        };
        timer.start();
    }

    private static void updateGame() {
        for (int i = 0; i < MapCreate.getMidLayer().size(); i++) {
            MapCreate.getMidLayer().get(i).update();
        }
        for (int i = 0; i < MapCreate.getTopLayer().size(); i++) {
            MapCreate.getTopLayer().get(i).update();
        }
        for (int i = 0; i < MapCreate.getEnemyLayer().size(); i++) {
            MapCreate.getEnemyLayer().get(i).update();
        }
        Player.getPlayer().update();
        Player2.getPlayer().update();
        MapCreate.removeEntity();
    }

    private static void renderGame(GraphicsContext graphicsContext) {
        for (Entity entity : MapCreate.getBoardLayer()) {
            entity.render(graphicsContext);
        }
        for (Entity entity : MapCreate.getMidLayer()) {
            entity.render(graphicsContext);
        }
        for (Entity entity : MapCreate.getTopLayer()) {
            entity.render(graphicsContext);
        }
        for (Entity entity : MapCreate.getEnemyLayer()) {
            entity.render(graphicsContext);
        }
        Player.getPlayer().render(graphicsContext);
        Player2.getPlayer().render(graphicsContext);
    }
}
