/**
 * Copyright (C) 2020 Intern Labs O!
 * <p>
 * Calculator program
 * This program uses MVC pattern
 *
 * @author Erkin Koshoev
 * @author Azamat Ibraimov
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller accepts input and converts it to commands for the Moud vibor del or View.
 * Implements ActionListener interface to listen to Actions from Viewer
 */
public class Controller implements ActionListener {

    private Model model;

    /**
     * Controller initialization
     * Creates new Model instance
     */
    public Controller(Viewer viewer) {
        this.model = new Model(viewer);
    }

    /**
     * Listens for actions and sends String commands to model
     */
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        model.doAction(command);
    }
}

