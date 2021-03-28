package ui;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class PlayMusic {

    // REQUIRES: music  file path
    // EFFECTS: Plays music from the provided filepath
    //          throws IOException, UnsupportedAudioFileException and LineUnavailableException
    public void playMusic() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        File file = new File("./music/20scalmmusic.wav");
        AudioInputStream audiostream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audiostream);
        clip.start();
    }

}
