/**
 * Copyright (C) 2020 Intern Labs O!
 * <p>
 * Sokoban game made with Java and Swing with MVC pattern
 * Sokoban is a puzzle video game in which the player pushes crates or boxes around in a warehouse,
 * trying to get them to storage locations.
 * In main menu user can restart level and exit game
 * In level menu user can choose level
 * In music menu user can turn on/turn off the game
 * Enjoy the game!
 *
 * @author Erkin Koshoev
 * @author Azamat Ibraimov
 */

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * This class is used to run music
 * To run music we need to create new thread
 * This class extends Thread class
 * This method is final so you cannot extend it!
 */
final public class Music extends Thread {

    /**
     * Clip class reads the wav file and makes it easy to run
     */

    private Clip clip;
    private boolean musicIsRunning;

    /**
     * @return Clip instance
     */
    public Clip getClip() {
        return clip;
    }

    /**
     * Music file
     */
    private File soundFile = new File("music/funk.wav");


    /**
     * When Thread is started this method executes
     * Creates a loop where audiofile is being played
     * Catches exceptions and prints it
     */

    @Override
    public void run() {

        musicIsRunning = true;

        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.setFramePosition(0);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            System.out.println(e);
        }
    }

    public void runMusic() {
        if (!musicIsRunning) {
            getClip().start();
            musicIsRunning = true;
        } else {
            getClip().stop();
            musicIsRunning = false;
        }
    }


}
