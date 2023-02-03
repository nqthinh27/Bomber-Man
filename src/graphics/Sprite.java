package graphics;

import javafx.scene.image.Image;

public class Sprite {
    public static final int SCALE_RATIO = 1;
    public static final int SCALED_SIZE = 48;
    public static final int BLOCK_SIZE = 48;

    private static final Image[][] spriteImages = SpriteSheet.tiles.scaleAll(SCALE_RATIO);

    // avatar
    public static Image blue_ava = new Image("/gameview/faceimage/faceblue.png");
    public static Image green_ava = new Image("/gameview/faceimage/facegreen.png");
    public static Image red_ava = new Image("/gameview/faceimage/facered.png");

    // background
    public static Image wall = spriteImages[5][0];
    public static Image grass = spriteImages[6][0];
    public static Image brick = spriteImages[7][0];
    public static Image transparent = spriteImages[15][15];
    public static Image portal = spriteImages[4][0];

    public static Image brick_exploded = spriteImages[7][1];
    public static Image brick_exploded_1 = spriteImages[7][2];
    public static Image brick_exploded_2 = spriteImages[7][3];

    // Player
    public static Image player_up = spriteImages[0][0];
    public static Image player_up_1 = spriteImages[0][1];
    public static Image player_up_2 = spriteImages[0][2];

    public static Image player_right = spriteImages[1][0];
    public static Image player_right_1 = spriteImages[1][1];
    public static Image player_right_2 = spriteImages[1][2];

    public static Image player_down = spriteImages[2][0];
    public static Image player_down_1 = spriteImages[2][1];
    public static Image player_down_2 = spriteImages[2][2];

    public static Image player_left = spriteImages[3][0];
    public static Image player_left_1 = spriteImages[3][1];
    public static Image player_left_2 = spriteImages[3][2];

    public static Image player_dead = spriteImages[4][2];
    public static Image player_dead_1 = spriteImages[5][2];
    public static Image player_dead_2 = spriteImages[6][2];

    public static Image player2_up = spriteImages[0][0];
    public static Image player2_up_1 = spriteImages[0][1];
    public static Image player2_up_2 = spriteImages[0][2];

    public static Image player2_right = spriteImages[1][0];
    public static Image player2_right_1 = spriteImages[1][1];
    public static Image player2_right_2 = spriteImages[1][2];

    public static Image player2_down = spriteImages[2][0];
    public static Image player2_down_1 = spriteImages[2][1];
    public static Image player2_down_2 = spriteImages[2][2];

    public static Image player2_left = spriteImages[3][0];
    public static Image player2_left_1 = spriteImages[3][1];
    public static Image player2_left_2 = spriteImages[3][2];

    public static Image player2_dead = spriteImages[4][2];
    public static Image player2_dead_1 = spriteImages[5][2];
    public static Image player2_dead_2 = spriteImages[6][2];

    public static Image blue_up = spriteImages[0][0];
    public static Image blue_up_1 = spriteImages[0][1];
    public static Image blue_up_2 = spriteImages[0][2];

    public static Image blue_right = spriteImages[1][0];
    public static Image blue_right_1 = spriteImages[1][1];
    public static Image blue_right_2 = spriteImages[1][2];

    public static Image blue_down = spriteImages[2][0];
    public static Image blue_down_1 = spriteImages[2][1];
    public static Image blue_down_2 = spriteImages[2][2];

    public static Image blue_left = spriteImages[3][0];
    public static Image blue_left_1 = spriteImages[3][1];
    public static Image blue_left_2 = spriteImages[3][2];

    public static Image blue_dead = spriteImages[4][2];
    public static Image blue_dead_1 = spriteImages[5][2];
    public static Image blue_dead_2 = spriteImages[6][2];

    public static Image red_up = spriteImages[4][11];
    public static Image red_up_1 = spriteImages[4][12];
    public static Image red_up_2 = spriteImages[4][13];

    public static Image red_right = spriteImages[5][11];
    public static Image red_right_1 = spriteImages[5][12];
    public static Image red_right_2 = spriteImages[5][13];

    public static Image red_down = spriteImages[6][11];
    public static Image red_down_1 = spriteImages[6][12];
    public static Image red_down_2 = spriteImages[6][13];

    public static Image red_left = spriteImages[7][11];
    public static Image red_left_1 = spriteImages[7][12];
    public static Image red_left_2 = spriteImages[7][13];

    public static Image red_dead = spriteImages[4][14];
    public static Image red_dead_1 = spriteImages[5][14];
    public static Image red_dead_2 = spriteImages[5][14];

    public static Image green_up = spriteImages[0][11];
    public static Image green_up_1 = spriteImages[0][12];
    public static Image green_up_2 = spriteImages[0][13];

    public static Image green_right = spriteImages[1][11];
    public static Image green_right_1 = spriteImages[1][12];
    public static Image green_right_2 = spriteImages[1][13];

    public static Image green_down = spriteImages[2][11];
    public static Image green_down_1 = spriteImages[2][12];
    public static Image green_down_2 = spriteImages[2][13];

    public static Image green_left = spriteImages[3][11];
    public static Image green_left_1 = spriteImages[3][12];
    public static Image green_left_2 = spriteImages[3][13];

    public static Image green_dead = spriteImages[0][14];
    public static Image green_dead_1 = spriteImages[1][14];
    public static Image green_dead_2 = spriteImages[2][14];

    // Balloon
    public static Image balloon_left = spriteImages[9][0];
    public static Image balloon_left_1 = spriteImages[9][1];
    public static Image balloon_left_2 = spriteImages[9][2];

    public static Image balloon_right = spriteImages[10][0];
    public static Image balloon_right_1 = spriteImages[10][1];
    public static Image balloon_right_2 = spriteImages[10][2];

    public static Image balloon_dead = spriteImages[9][3];

    // Doll
    public static Image doll_left = spriteImages[13][0];
    public static Image doll_left_1 = spriteImages[13][1];
    public static Image doll_left_2 = spriteImages[13][2];

    public static Image doll_right = spriteImages[14][0];
    public static Image doll_right_1 = spriteImages[14][1];
    public static Image doll_right_2 = spriteImages[14][2];

    public static Image doll_dead = spriteImages[13][3];

    // Kondoria
    public static Image kondoria_left = spriteImages[10][5];
    public static Image kondoria_left_1 = spriteImages[10][6];
    public static Image kondoria_left_2 = spriteImages[10][7];

    public static Image kondoria_right = spriteImages[11][5];
    public static Image kondoria_right_1 = spriteImages[11][6];
    public static Image kondoria_right_2 = spriteImages[11][7];

    public static Image kondoria_dead = spriteImages[10][8];

    public static void setBlue() {
        player_up = blue_up;
        player_up_1 = blue_up_1;
        player_up_2 = blue_up_2;

        player_right = blue_right;
        player_right_1 = blue_right_1;
        player_right_2 = blue_right_2;

        player_down = blue_down;
        player_down_1 = blue_down_1;
        player_down_2 = blue_down_2;

        player_left = blue_left;
        player_left_1 = blue_left_1;
        player_left_2 = blue_left_2;

        player_dead = blue_dead;
        player_dead_1 = blue_dead_1;
        player_dead_2 = blue_dead_2;
    }

    public static void setGreen() {
        player_up = green_up;
        player_up_1 = green_up_1;
        player_up_2 = green_up_2;

        player_right = green_right;
        player_right_1 = green_right_1;
        player_right_2 = green_right_2;

        player_down = green_down;
        player_down_1 = green_down_1;
        player_down_2 = green_down_2;

        player_left = green_left;
        player_left_1 = green_left_1;
        player_left_2 = green_left_2;

        player_dead = green_dead;
        player_dead_1 = green_dead_1;
        player_dead_2 = green_dead_2;
    }

    public static void setRed() {
        player_up = red_up;
        player_up_1 = red_up_1;
        player_up_2 = red_up_2;

        player_right = red_right;
        player_right_1 = red_right_1;
        player_right_2 = red_right_2;

        player_down = red_down;
        player_down_1 = red_down_1;
        player_down_2 = red_down_2;

        player_left = red_left;
        player_left_1 = red_left_1;
        player_left_2 = red_left_2;

        player_dead = red_dead;
        player_dead_1 = red_dead_1;
        player_dead_2 = red_dead_2;
    }

    public static void setBlue2() {
        player2_up = blue_up;
        player2_up_1 = blue_up_1;
        player2_up_2 = blue_up_2;

        player2_right = blue_right;
        player2_right_1 = blue_right_1;
        player2_right_2 = blue_right_2;

        player2_down = blue_down;
        player2_down_1 = blue_down_1;
        player2_down_2 = blue_down_2;

        player2_left = blue_left;
        player2_left_1 = blue_left_1;
        player2_left_2 = blue_left_2;

        player2_dead = blue_dead;
        player2_dead_1 = blue_dead_1;
        player2_dead_2 = blue_dead_2;
    }

    public static void setGreen2() {
        player2_up = green_up;
        player2_up_1 = green_up_1;
        player2_up_2 = green_up_2;

        player2_right = green_right;
        player2_right_1 = green_right_1;
        player2_right_2 = green_right_2;

        player2_down = green_down;
        player2_down_1 = green_down_1;
        player2_down_2 = green_down_2;

        player2_left = green_left;
        player2_left_1 = green_left_1;
        player2_left_2 = green_left_2;

        player2_dead = green_dead;
        player2_dead_1 = green_dead_1;
        player2_dead_2 = green_dead_2;
    }

    public static void setRed2() {
        player2_up = red_up;
        player2_up_1 = red_up_1;
        player2_up_2 = red_up_2;

        player2_right = red_right;
        player2_right_1 = red_right_1;
        player2_right_2 = red_right_2;

        player2_down = red_down;
        player2_down_1 = red_down_1;
        player2_down_2 = red_down_2;

        player2_left = red_left;
        player2_left_1 = red_left_1;
        player2_left_2 = red_left_2;

        player2_dead = red_dead;
        player2_dead_1 = red_dead_1;
        player2_dead_2 = red_dead_2;
    }

    // Oneal
    public static Image oneal_left = spriteImages[11][0];
    public static Image oneal_left_1 = spriteImages[11][1];
    public static Image oneal_left_2 = spriteImages[11][2];

    public static Image oneal_right = spriteImages[12][0];
    public static Image oneal_right_1 = spriteImages[12][1];
    public static Image oneal_right_2 = spriteImages[12][2];

    public static Image oneal_dead = spriteImages[11][3];

    //MINVO
    public static Image minvo_left = spriteImages[8][5];
    public static Image minvo_left_1 = spriteImages[8][6];
    public static Image minvo_left_2 = spriteImages[8][7];

    public static Image minvo_right = spriteImages[9][5];
    public static Image minvo_right_1 = spriteImages[9][6];
    public static Image minvo_right_2 = spriteImages[9][7];

    public static Image minvo_dead = spriteImages[8][8];

    //bomb
    public static Image bomb = spriteImages[0][3];
    public static Image bomb_1 = spriteImages[1][3];
    public static Image bomb_2 = spriteImages[2][3];

    public static Image bomb_exploded = spriteImages[0][5];
    public static Image bomb_exploded_1 = spriteImages[0][6];
    public static Image bomb_exploded_2 = spriteImages[0][4];

    public static Image explosion_horizontal = spriteImages[1][8];
    public static Image explosion_horizontal_1 = spriteImages[1][9];
    public static Image explosion_horizontal_2 = spriteImages[1][7];

    public static Image explosion_horizontal_left_last = spriteImages[0][8];
    public static Image explosion_horizontal_left_last_1 = spriteImages[0][9];
    public static Image explosion_horizontal_left_last_2 = spriteImages[0][7];

    public static Image explosion_horizontal_right_last = spriteImages[2][8];
    public static Image explosion_horizontal_right_last_1 = spriteImages[2][9];
    public static Image explosion_horizontal_right_last_2 = spriteImages[2][7];

    public static Image explosion_vertical = spriteImages[2][5];
    public static Image explosion_vertical_1 = spriteImages[3][5];
    public static Image explosion_vertical_2 = spriteImages[1][5];

    public static Image explosion_vertical_top_last = spriteImages[2][4];
    public static Image explosion_vertical_top_last_1 = spriteImages[3][4];
    public static Image explosion_vertical_top_last_2 = spriteImages[1][4];

    public static Image explosion_vertical_down_last = spriteImages[2][6];
    public static Image explosion_vertical_down_last_1 = spriteImages[3][6];
    public static Image explosion_vertical_down_last_2 = spriteImages[1][6];

    // Powerup items
    public static Image powerup_bombs = spriteImages[0][10];
    public static Image powerup_flames = spriteImages[1][10];
    public static Image powerup_speed = spriteImages[2][10];

    public static Image mob_dead_1 = spriteImages[15][0];
    public static Image mob_dead_2 = spriteImages[15][1];
    public static Image mob_dead_3 = spriteImages[15][2];

    public static Image playSpriteAnimation(Image image_0, Image image_1, Image image_2, int animate, int time) {
        int temp = animate % time;
        int delta = time / 3;

        if (temp < delta) {
            return image_0;
        } else if (temp < delta * 2) {
            return image_1;
        } else {
            return image_2;
        }
    }
}
