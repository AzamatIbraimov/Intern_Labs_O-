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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Controller accepts input and converts it to commands for the Moud vibor del or View.
 * Implements KeyListener interface to listen to key events from Viewer
 * Implements ActionListener interface to listen to Actions from Viewer
 */
public class Controller implements KeyListener, ActionListener {

    private Model model;

    /**
     * Controller initialization
     * Creates new Model instance with viewer reference
     */
    public Controller(Viewer viewer) {
        model = new Model(viewer);
    }

    /**
     * @return model instance with viewer reference
     */

    public Model getModel() {
        return model;
    }

    /**
     * keyPressed , keyTyped , keyReleased methods come from keylistener interface
     * In this program we use only keyPressed method, which listens to every key pressed event
     * Then, depending on keyCode controller sends commands to model
     *
     * @param keyEvent
     */
    @Override
    public void keyPressed(KeyEvent keyEvent) {

        int keyCode = keyEvent.getKeyCode();
        String direction;

        switch (keyCode) {
            case 39:
            case 68:
                direction = "Right";
                break;
            case 37:
            case 65:
                direction = "Left";
                break;
            case 38:
            case 87:
                direction = "Up";
                break;
            case 40:
            case 83:
                direction = "Down";
                break;
            default:
                return;
        }
        model.move(direction);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    /**
     * Listens to some actions and sends String commands to model
     */

    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        model.doAction(command);
    }
}
