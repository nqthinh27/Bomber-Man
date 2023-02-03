package gameplay;

import entities.block.Brick;
import entities.block.Grass;
import entities.block.Wall;
import entities.enemies.*;
import entities.player.Player;
import entities.player.Player2;
import entities.powerup.Portal;
import entities.powerup.PowerupBombs;
import entities.powerup.PowerupFlames;
import entities.powerup.PowerupSpeed;
import gamelogic.KeyController;
import gamelogic.GameLoop;
import entities.*;
import gamelogic.MultiPlayerGameLoop;
import gamelogic.SoundEffect;
import graphics.Sprite;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class MapCreate {
    static Canvas canvas;
    public static GraphicsContext graphicsContext;
    static Player player;
    static Player2 player2;

    public static int mapWidth;
    public static int mapHeight;
    public static int mapLevel;
    public static int CANVAS_WIDTH;
    public static int CANVAS_HEIGHT;
    public static boolean pause1 = false;
    public static boolean pause2 = false;
    public static char[][] myMap;
    public static char[][] mapMatrix;

    public static int currentLevel = 1;
    public static int gameScore = 0;

    private static final List<Entity> boardLayer = new ArrayList<>();
    private static final List<Entity> topLayer = new ArrayList<>();
    private static final List<Entity> midLayer = new ArrayList<>();
    private static final List<Enemy> enemyLayer = new ArrayList<>();

    public static ImageView avatar, avatar1, avatar2;
    public static Label name, name1, name2;
    public static Label score;
    public static Label life, life1, life2;
    public static Label bombs, bombs1, bombs2;
    public static Label range, range1, range2;
    public static Label speed, speed1, speed2;
    public static Label levels;
    public static Label enemies;
    public static ImageView loseImage;

    public static void initGame(Pane root, Scene scene) {
        pause1 = false;
        canvas = new Canvas();
        initLabel();
        loseImage = new ImageView();
        root.getChildren().addAll(canvas, avatar, name, score,
                life, bombs, levels, enemies, range, speed, loseImage);
        graphicsContext = canvas.getGraphicsContext2D();
        createLevel(currentLevel);
        GameLoop.start(graphicsContext);
        KeyController.setOnKeys(scene);
    }

    public static void initMultiPlayerGame(Pane root, Scene scene) {
        pause2 = false;
        canvas = new Canvas();
        initMultiLabel();
        loseImage = new ImageView();
        root.getChildren().addAll(canvas, avatar1, avatar2, name1, name2,
                bombs1, bombs2, range1, range2, speed1, speed2, life1, life2, loseImage);
        graphicsContext = canvas.getGraphicsContext2D();
        createMultiPlayerLevel();
        MultiPlayerGameLoop.multiplayerStart(graphicsContext);
        KeyController.setOnKeys(scene);
    }

    public static void createLevel(int level) {
        clearMap();
        loadMapFile("/levels/Level" + level + ".txt");
        for (int i = 0; i < mapHeight; i++) {
            for (int j = 0; j < mapWidth; j++) {
                char c = myMap[i][j];
                addEntity(c, j * Sprite.SCALED_SIZE, i * Sprite.SCALED_SIZE);
            }
        }
        canvas.setHeight(CANVAS_HEIGHT);
        canvas.setWidth(CANVAS_WIDTH);
    }

    public static void createMultiPlayerLevel() {
        clearMap();
        loadMapFile("/levels/MultiPlayerMap.txt");
        for (int i = 0; i < mapHeight; i++) {
            for (int j = 0; j < mapWidth; j++) {
                char c = myMap[i][j];
                addEntity(c, j * Sprite.SCALED_SIZE, i * Sprite.SCALED_SIZE);
            }
        }
        canvas.setHeight(CANVAS_HEIGHT);
        canvas.setWidth(CANVAS_WIDTH);
    }

    public static void removeEntity() {
        for (int i = 0; i < midLayer.size(); i++) {
            if (midLayer.get(i).isRemoved()) {
                midLayer.remove(i);
                --i;
            }
        }

        for (int i = 0; i < topLayer.size(); i++) {
            if (topLayer.get(i).isRemoved()) {
                topLayer.remove(i);
                --i;
            }
        }
        for (int i = 0; i < enemyLayer.size(); i++) {
            if (enemyLayer.get(i).isRemoved()) {
                gameScore += enemyLayer.get(i).getScore();
                enemyLayer.remove(i);
                --i;
            }
        }
    }

    public static void nextLevel() {
        if (currentLevel < 5) {
            currentLevel += 1;
        } else {
            pause1 = true;
            WinEffect();
        }
        createLevel(currentLevel);
        player.resetBombList();
    }

    public static void resetLevel() {
        currentLevel = 1;
    }

    public static List<Entity> getBoardLayer() {
        return boardLayer;
    }

    public static List<Entity> getMidLayer() {
        return midLayer;
    }

    public static List<Entity> getTopLayer() {
        return topLayer;
    }

    public static List<Enemy> getEnemyLayer() {
        return enemyLayer;
    }


    public static void addEntity(char c, int x, int y) {
        switch (c) {
            // background and Player
            case '#':
                boardLayer.add(new Wall(x, y));
                break;
            case '*':
                boardLayer.add(new Grass(x, y));
                topLayer.add(new Brick(x, y));
                break;
            case ' ':
                boardLayer.add(new Grass(x, y));
                break;
            case 'p':
                boardLayer.add(new Grass(x, y));
                player = Player.setPlayer(x, y, false);
                break;
            case 'q':
                boardLayer.add(new Grass(x, y));
                player2 = Player2.setPlayer(x, y, false);
                break;
            //enemies
            case '1':
                boardLayer.add(new Grass(x, y));
                enemyLayer.add(new Balloon(x, y));
                break;
            case '2':
                boardLayer.add(new Grass(x, y));
                enemyLayer.add(new Doll(x, y));
                break;
            case '3':
                boardLayer.add(new Grass(x, y));
                enemyLayer.add(new Oneal(x, y));
                break;
            case '4':
                boardLayer.add(new Grass(x, y));
                enemyLayer.add(new Minvo(x, y));
                break;
            case '5':
                boardLayer.add(new Grass(x, y));
                enemyLayer.add(new Kondoria(x, y));
                break;
            case 'x':
                boardLayer.add(new Grass(x, y));
                midLayer.add(new Portal(x, y));
                topLayer.add(new Brick(x, y));
                break;
            case 'b':
                boardLayer.add(new Grass(x, y));
                midLayer.add(new PowerupBombs(x,y));
                topLayer.add(new Brick(x, y));
                break;
            case 'f':
                boardLayer.add(new Grass(x, y));
                midLayer.add(new PowerupFlames(x,y));
                topLayer.add(new Brick(x, y));
                break;
            case 's':
                boardLayer.add(new Grass(x, y));
                midLayer.add(new PowerupSpeed(x,y));
                topLayer.add(new Brick(x, y));
                break;
        }
    }

    public static void loadMapFile(String filePath) {
        try {
            URL fileMapPath = MapCreate.class.getResource(filePath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(fileMapPath).openStream()));
            String data = reader.readLine();
            StringTokenizer tokens = new StringTokenizer(data);
            mapLevel = Integer.parseInt(tokens.nextToken());
            mapHeight = Integer.parseInt(tokens.nextToken());
            mapWidth = Integer.parseInt(tokens.nextToken());
            CANVAS_HEIGHT = mapHeight * Sprite.BLOCK_SIZE;
            CANVAS_WIDTH = mapWidth * Sprite.BLOCK_SIZE;
            myMap = new char[mapHeight][mapWidth];
            mapMatrix = new char[mapHeight][mapWidth];
            for (int i = 0; i < mapHeight; i++) {
                char[] temp = reader.readLine().toCharArray();
                for (int j = 0; j < mapWidth; j++) {
                    myMap[i][j] = temp[j];
                    if ('#' == temp[j] || '*' == temp[j] || 'x' == temp[j]
                            || 'b' == temp[j] || 'f' == temp[j] || 's' == temp[j]
                            || 'w' == temp[j] || 'm' == temp[j] || 'n' == temp[j]) {
                        mapMatrix[i][j] = temp[j];
                    } else {
                        mapMatrix[i][j] = ' ';
                    }
                }
            }
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    public static void clearMap() {
        graphicsContext.clearRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
        enemyLayer.clear();
        topLayer.clear();
        midLayer.clear();
        boardLayer.clear();
    }

    public static Entity getFixedEntityAt(int x, int y) {
        for (Entity entity : boardLayer) {
            if (entity instanceof Wall && entity.getX_pos() == x && entity.getY_pos() == y) {
                return entity;
            }
        }
        for (Entity entity : topLayer) {
            if (entity instanceof Brick && entity.getX_pos() == x && entity.getY_pos() == y) {
                return entity;
            }
        }
        return null;
    }

    private static void initLabel() {
        // constructor
        avatar = new ImageView();
        name = new Label("Player");
        levels = new Label("Level");
        score = new Label("Score");
        life = new Label("Life");
        bombs = new Label("Bomb");
        range = new Label("Range");
        speed = new Label("Speed");
        enemies = new Label("Enemies");
        //font
        name.setFont(new Font("Berlin Sans FB", 20));
        levels.setFont(new Font("Berlin Sans FB", 17));
        score.setFont(new Font("Berlin Sans FB", 17));
        life.setFont(new Font("Berlin Sans FB", 17));
        bombs.setFont(new Font("Berlin Sans FB", 17));
        range.setFont(new Font("Berlin Sans FB", 17));
        speed.setFont(new Font("Berlin Sans FB", 17));
        enemies.setFont(new Font("Berlin Sans FB", 17));
        //layout
        avatar.setLayoutX(875); avatar.setLayoutY(40);
        name.setLayoutX(842); name.setLayoutY(512);
        levels.setLayoutX(885); levels.setLayoutY(130);
        score.setLayoutX(885); score.setLayoutY(175);
        life.setLayoutX(885); life.setLayoutY(220);
        bombs.setLayoutX(885); bombs.setLayoutY(265);
        range.setLayoutX(885); range.setLayoutY(310);
        speed.setLayoutX(885); speed.setLayoutY(355);
        enemies.setLayoutX(885); enemies.setLayoutY(400);
        // size
        avatar.setFitHeight(70); avatar.setFitWidth(65);
        name.setPrefWidth(135); name.setAlignment(Pos.CENTER);
    }

    private static void initMultiLabel() {
        // constructor
        avatar1 = new ImageView();
        avatar2 = new ImageView();
        name1 = new Label("Player");
        name2 = new Label("Player");
        life1 = new Label("Life");
        life2 = new Label("Life");
        bombs1 = new Label("Bomb");
        bombs2 = new Label("Bomb");
        range1 = new Label("Range");
        range2 = new Label("Range");
        speed1 = new Label("Speed");
        speed2 = new Label("Speed");
        //font
        name1.setFont(new Font("Berlin Sans FB", 20));
        name2.setFont(new Font("Berlin Sans FB", 20));
        life1.setFont(new Font("Berlin Sans FB", 17));
        life2.setFont(new Font("Berlin Sans FB", 17));
        bombs1.setFont(new Font("Berlin Sans FB", 17));
        bombs2.setFont(new Font("Berlin Sans FB", 17));
        range1.setFont(new Font("Berlin Sans FB", 17));
        range2.setFont(new Font("Berlin Sans FB", 17));
        speed1.setFont(new Font("Berlin Sans FB", 17));
        speed2.setFont(new Font("Berlin Sans FB", 17));
        //layout
        avatar1.setLayoutX(859); avatar1.setLayoutY(34);
        avatar2.setLayoutX(859); avatar2.setLayoutY(311);
        name1.setLayoutX(842); name1.setLayoutY(240);
        name2.setLayoutX(842); name2.setLayoutY(512);
        life1.setLayoutX(925); life1.setLayoutY(64);
        life2.setLayoutX(925); life2.setLayoutY(337);
        bombs1.setLayoutX(887); bombs1.setLayoutY(108);
        bombs2.setLayoutX(886); bombs2.setLayoutY(382);
        range1.setLayoutX(887); range1.setLayoutY(153);
        range2.setLayoutX(886); range2.setLayoutY(427);
        speed1.setLayoutX(887); speed1.setLayoutY(198);
        speed2.setLayoutX(886); speed2.setLayoutY(472);
        // size
        avatar1.setFitHeight(57); avatar1.setFitWidth(57);
        avatar2.setFitHeight(57); avatar2.setFitWidth(57);
        name1.setPrefWidth(135); name1.setAlignment(Pos.CENTER);
        name2.setPrefWidth(135); name2.setAlignment(Pos.CENTER);
    }

    public static void updateLabel() {
        if (Sprite.player_down == Sprite.blue_down) {
            avatar.setImage(Sprite.blue_ava);
        } else if(Sprite.player_down == Sprite.green_down) {
            avatar.setImage(Sprite.green_ava);
        } else if(Sprite.player_down == Sprite.red_down) {
            avatar.setImage(Sprite.red_ava);
        }
        name.setText("Player " + Player.getPlayer().getName());
        levels.setText("Level: " + currentLevel);
        life.setText("Life: " + Player.getPlayer().getLifeCount());
        bombs.setText("Bomb: " + Player.getPlayer().getRemainBombs());
        score.setText("Score: " + gameScore);
        speed.setText("Speed: " + Player.getPlayer().getSpeed());
        range.setText("Range: " + Player.getPlayer().getBombRadius());
        enemies.setText("Left: " + getEnemyLayer().size());
    }

    public static void updateMultiLabel() {
        if (Sprite.player_down == Sprite.blue_down) {
            avatar1.setImage(Sprite.blue_ava);
        } else if(Sprite.player_down == Sprite.green_down) {
            avatar1.setImage(Sprite.green_ava);
        } else if(Sprite.player_down == Sprite.red_down) {
            avatar1.setImage(Sprite.red_ava);
        }
        if (Sprite.player2_down == Sprite.blue_down) {
            avatar2.setImage(Sprite.blue_ava);
        } else if(Sprite.player2_down == Sprite.green_down) {
            avatar2.setImage(Sprite.green_ava);
        } else if(Sprite.player2_down == Sprite.red_down) {
            avatar2.setImage(Sprite.red_ava);
        }
        name1.setText("Player " + Player.getPlayer().getName());
        name2.setText("Player2 " + Player2.getPlayer().getName());
        life1.setText("" + Player.getPlayer().getLifeCount());
        life2.setText("" + Player2.getPlayer().getLifeCount());
        bombs1.setText("Bomb: " + Player.getPlayer().getRemainBombs());
        bombs2.setText("Bomb: " + Player2.getPlayer().getRemainBombs());
        speed1.setText("Speed: " + Player.getPlayer().getSpeed());
        speed2.setText("Speed: " + Player2.getPlayer().getSpeed());
        range1.setText("Range: " + Player.getPlayer().getBombRadius());
        range2.setText("Range: " + Player2.getPlayer().getBombRadius());
    }

    public static void LoseEffect() {
        SoundEffect.GAMEPLAY.stop();
        SoundEffect.DEFEAT.play(false);
        Image image = new Image("/gameview/lose.png");
        loseImage.setImage(image);
        loseImage.setLayoutX(300);
        loseImage.setLayoutY(280);
    }

    public static void WinEffect() {
        SoundEffect.GAMEPLAY.stop();
        SoundEffect.WIN.play(false);
        Image image = new Image("/gameview/win.png");
        loseImage.setImage(image);
        loseImage.setLayoutX(300);
        loseImage.setLayoutY(280);
    }
}
