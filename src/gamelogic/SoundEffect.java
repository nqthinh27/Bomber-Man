package gamelogic;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class SoundEffect {
    public static SoundEffect BACKGROUND = new SoundEffect("/sound/mainScene.wav");
    public static SoundEffect GAMEPLAY = new SoundEffect("/sound/roomScene.wav");
    public static SoundEffect GAME_START = new SoundEffect("/sound/gameStart.wav");
    public static SoundEffect REVIVAL = new SoundEffect("/sound/revival.wav");
    public static SoundEffect EAT_PROPS = new SoundEffect("/sound/eatProp.wav");
    public static SoundEffect PLACE_BOMB = new SoundEffect("/sound/bubbleSet.wav");
    public static SoundEffect EXPLOSION = new SoundEffect("/sound/bubbleBoom.wav");
    public static SoundEffect ENEMY_KILL = new SoundEffect("/sound/enemyKill.wav");
    public static SoundEffect DEFEAT = new SoundEffect("/sound/defeat.wav");
    public static SoundEffect WIN = new SoundEffect("/sound/win.wav");

    public enum Volume {
        MUTE, UNMUTE
    }

    public static Volume volume = Volume.UNMUTE;

    private Clip clip;

    public SoundEffect(String soundFileName) {
        try {
            URL url = SoundEffect.class.getResource(soundFileName);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void play(Boolean loop) {
        if (volume != Volume.MUTE) {
            if (clip.isRunning()) {
                clip.stop();
            }
            clip.setFramePosition(0);
            clip.start();
            if(loop) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
        }
        else {
            clip.stop();
        }
    }

    public static void mute() {
        volume = Volume.MUTE;
    }

    public static void unmute() {
        volume = Volume.UNMUTE;
    }

    public void stop() {
        clip.stop();
        clip.setFramePosition(0);
    }

    public boolean isPlaying() {
        return clip.isRunning();
    }
}
