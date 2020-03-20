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

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Viewer represents all information. Viewer receives data from the Controller of the Model it and presents it to display.
 */

public class Viewer {

    /**
     * Canvas instance
     * Jframe is our main frame
     * Viewer creates instance of Controller inside its constructor
     */
    private Canvas canvas;
    private JFrame frame;
    private Controller controller;
    private JLabel label;

    /**
     * Viewer intialization:
     * Creating instance of controller with reference to this Viewer class(this keyword)
     * Than creates a Model instance from controller
     * Creates Canvas instance with reference to Model
     * Other part is user interface part.
     */
    public Viewer() {
        controller = new Controller(this);
        Model model = controller.getModel();
        canvas = new Canvas(model);

        frame = new JFrame("Sokoban Intern Labs");
        frame.setSize(650, 700);
        frame.setLocation(200, 0);
        frame.addKeyListener(controller);
        JMenuBar menuBar = getMenuBar();
        frame.add(BorderLayout.NORTH, menuBar);
        frame.setVisible(true);
        frame.add(canvas);

        URL url = this.getClass().getResource("images/win.gif");
        Icon icon = new ImageIcon(url);
        label = new JLabel(icon);
        model.goMusic();
    }


    /**
     * JOptionPane which congrats user when level is passed
     */
    public void showWin() {
        JOptionPane.showMessageDialog(frame, label);
    }


    /**
     * Update the screen appearance by calling canvas.repaint
     */
    public void update() {
        canvas.repaint();
    }


    /**
     * Menu bar
     * Contains Jmenubars
     * Jmenubars contain JmenuItems
     * JmenuItems have Name, ImageIcon and Hotkeys
     * When JmenuItems are choosen , they send ActionCommands to Model
     */

    private JMenuBar getMenuBar() {

        JMenuItem restart = new JMenuItem("Restart");
        restart.addActionListener(controller);
        restart.setActionCommand("Restart");

        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(controller);
        exit.setActionCommand("Exit");

        JMenu mainMenu = new JMenu("Main");
        mainMenu.add(restart);
        mainMenu.add(exit);

        JMenuItem firstLevel = new JMenuItem("Level 1");
        firstLevel.addActionListener(controller);
        firstLevel.setActionCommand("Level 1");

        JMenuItem secondLevel = new JMenuItem("Level 2");
        secondLevel.addActionListener(controller);
        secondLevel.setActionCommand("Level 2");

        JMenuItem thirdLevel = new JMenuItem("Level 3");
        thirdLevel.addActionListener(controller);
        thirdLevel.setActionCommand("Level 3");

        JMenuItem forthLevel = new JMenuItem("Level 4");
        forthLevel.addActionListener(controller);
        forthLevel.setActionCommand("Level 4");

        JMenuItem fifthLevel = new JMenuItem("Level 5");
        fifthLevel.addActionListener(controller);
        fifthLevel.setActionCommand("Level 5");

        JMenuItem sixthLevel = new JMenuItem("Level 6");
        sixthLevel.addActionListener(controller);
        sixthLevel.setActionCommand("Level 6");

        JMenuItem chooseLevel = new JMenuItem("Choose level");
        chooseLevel.addActionListener(controller);
        chooseLevel.setActionCommand("Choose level");


        JMenu levelMenu = new JMenu("Level");
        levelMenu.add(firstLevel);
        levelMenu.add(secondLevel);
        levelMenu.add(thirdLevel);
        levelMenu.add(forthLevel);
        levelMenu.add(fifthLevel);
        levelMenu.add(sixthLevel);
        levelMenu.add(chooseLevel);


        JMenuItem music = new JCheckBoxMenuItem("Music");
        music.setSelected(true);
        music.addActionListener(controller);
        music.setActionCommand("Music");

        JMenu musicMenu = new JMenu("Music");
        musicMenu.add(music);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(mainMenu);
        menuBar.add(levelMenu);
        menuBar.add(musicMenu);

        return menuBar;

    }

}
