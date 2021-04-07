package ui;


import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

public class GUI extends JFrame {

    // EFFECTS: Starts the main program
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        new AdminLogin();
        PlayMusic pm = new PlayMusic();
        pm.playMusic();

    }

}

