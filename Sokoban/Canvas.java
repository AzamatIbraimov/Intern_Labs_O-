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

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Canvas object
 * this object added to main JFrame
 * All the game animations happen here
 */
public class Canvas extends JPanel {

    /**
     * Has model reference to level from it
     * Other images are images for animations
     */
    private Model model;
    private Image imageGamer;
    private Image imageWall;
    private Image imageTarget;
    private Image imageBox;

    /**
     * Canvas constructor with model reference
     * Gets images from file path
     *
     * @param model
     */

    public Canvas(Model model) {
        this.model = model;
        setBackground(Color.black);

        File fileNameGamer = new File("images/gamer.png");
        File fileNameWall = new File("images/wall.png");
        File fileNameTarget = new File("images/goal.png");
        File fileNameBox = new File("images/box.png");

        try {
            imageGamer = ImageIO.read(fileNameGamer);
            imageWall = ImageIO.read(fileNameWall);
            imageTarget = ImageIO.read(fileNameTarget);
            imageBox = ImageIO.read(fileNameBox);
        } catch (IOException e) {
            System.out.println("Error " + e);
        }
    }

    /**
     * Using the two dimensional array from model represents animations
     * Draws things using Graphics
     * 1 - Player
     * 2 - Wall
     * 3 - Box
     * 4 - Target
     *
     * @param graphics
     */
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.setColor(Color.white);
        int x = 50;
        int y = 50;
        int width = 50;
        int height = 50;
        int offset = 5;

        int[][] desktop = model.getDesktop();
        for (int i = 0; i < desktop.length; i++) {
            for (int j = 0; j < desktop[i].length; j++) {
                if (desktop[i][j] == 1) {
                    graphics.drawImage(imageGamer, x, y, null);
                } else if (desktop[i][j] == 2) {
                    graphics.drawImage(imageWall, x, y, null);
                } else if (desktop[i][j] == 3) {
                    graphics.drawImage(imageBox, x, y, null);
                } else if (desktop[i][j] == 4) {
                    graphics.drawImage(imageTarget, x, y, null);
                } else {
                    graphics.setColor(Color.white);
                    graphics.drawRect(x, y, width, height);
                }
                x = x + width + offset;
            }
            x = 50;
            y = y + height + offset;
        }
    }
}
