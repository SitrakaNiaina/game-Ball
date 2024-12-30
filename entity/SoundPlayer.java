package entity;

import javazoom.jl.player.Player;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class SoundPlayer {

    public static void playSoundFileWav(String filePath) {
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void playSoundMp3(String filePath) {
        try(FileInputStream file = new FileInputStream(filePath)) {
            Player player = new Player(file);
            player.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
