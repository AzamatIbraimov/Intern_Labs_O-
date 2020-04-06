/**
 * Copyright (C) 2020 Intern Labs O!
 * <p>
 * Calculator program
 * This program uses MVC pattern
 *
 * @author Erkin Koshoev
 * @author Azamat Ibraimov
 */

import javax.swing.*;
import java.awt.*;

/**
 * Viewer represents all information. Viewer receives data from the Controller of the Model it and presents it to display.
 */
public class Viewer {

    private JTextField textField;
    private JTextField textFieldSmall;

    /**
     * Viewer creates instance of Controller inside its constructor
     * Jpanel is main panel where all buttons placed
     */
    public Viewer() {

        Controller controller = new Controller(this);

        JPanel panel = getCenterJPanel(controller);
        panel.setBounds(0, 0, 350, 350);

        JFrame frame = new JFrame("InternLabs Calculator");
        frame.setSize(400, 420);
        frame.setLocation(100, 50);
        frame.setLayout(null);
        frame.add(panel);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    /**
     * Initiates textfields and main panel with all buttons
     * Controller listens for all actions from buttons
     */
    private JPanel getCenterJPanel(Controller controller) {

        textField = new JTextField();
        textField.setFont(new java.awt.Font("Alergia", java.awt.Font.BOLD, 19));
        textField.setForeground(java.awt.Color.black);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setBounds(50, 50, 230, 50);
        textField.setEditable(false);

        textFieldSmall = new JTextField();
        textFieldSmall.setFont(new java.awt.Font("Alergia", Font.PLAIN, 15));
        textFieldSmall.setForeground(java.awt.Color.black);
        textFieldSmall.setHorizontalAlignment(JTextField.RIGHT);
        textFieldSmall.setEditable(false);

        JButton deleteButton = new JButton("<");
        deleteButton.setBounds(290, 50, 50, 50);
        deleteButton.addActionListener(controller);
        deleteButton.setActionCommand("Delete");

        JButton clearButton = new JButton("C");
        clearButton.setBounds(290, 110, 50, 50);
        clearButton.addActionListener(controller);
        clearButton.setActionCommand("Clear");

        JButton nineButton = new JButton("9");
        nineButton.setBounds(170, 110, 50, 50);
        nineButton.setForeground(java.awt.Color.black);
        nineButton.addActionListener(controller);
        nineButton.setActionCommand("9");

        JButton eightButton = new JButton("8");
        eightButton.setBounds(110, 110, 50, 50);
        eightButton.setForeground(java.awt.Color.black);
        eightButton.addActionListener(controller);
        eightButton.setActionCommand("8");

        JButton sevenButton = new JButton("7");
        sevenButton.setBounds(50, 110, 50, 50);
        sevenButton.setForeground(java.awt.Color.black);
        sevenButton.addActionListener(controller);
        sevenButton.setActionCommand("7");

        JButton sixButton = new JButton("6");
        sixButton.setBounds(170, 170, 50, 50);
        sixButton.setForeground(java.awt.Color.black);
        sixButton.addActionListener(controller);
        sixButton.setActionCommand("6");

        JButton fiveButton = new JButton("5");
        fiveButton.setBounds(110, 170, 50, 50);
        fiveButton.setForeground(java.awt.Color.black);
        fiveButton.addActionListener(controller);
        fiveButton.setActionCommand("5");

        JButton fourButton = new JButton("4");
        fourButton.setBounds(50, 170, 50, 50);
        fourButton.setForeground(java.awt.Color.black);
        fourButton.addActionListener(controller);
        fourButton.setActionCommand("4");

        JButton threeButton = new JButton("3");
        threeButton.setBounds(170, 230, 50, 50);
        threeButton.setForeground(java.awt.Color.black);
        threeButton.addActionListener(controller);
        threeButton.setActionCommand("3");

        JButton twoButton = new JButton("2");
        twoButton.setBounds(110, 230, 50, 50);
        twoButton.setForeground(java.awt.Color.black);
        twoButton.addActionListener(controller);
        twoButton.setActionCommand("2");

        JButton oneButton = new JButton("1");
        oneButton.setBounds(50, 230, 50, 50);
        oneButton.setForeground(java.awt.Color.black);
        oneButton.addActionListener(controller);
        oneButton.setActionCommand("1");

        JButton zeroButton = new JButton("0");
        zeroButton.setBounds(50, 290, 110, 50);
        zeroButton.setForeground(java.awt.Color.black);
        zeroButton.addActionListener(controller);
        zeroButton.setActionCommand("0");

        JButton commaButton = new JButton(".");
        commaButton.setBounds(170, 290, 50, 50);
        commaButton.addActionListener(controller);
        commaButton.setActionCommand(".");

        JButton plusButton = new JButton("+");
        plusButton.setBounds(230, 290, 50, 50);
        plusButton.addActionListener(controller);
        plusButton.setActionCommand("+");

        JButton minusButton = new JButton("-");
        minusButton.setBounds(230, 230, 50, 50);
        minusButton.addActionListener(controller);
        minusButton.setActionCommand("-");

        JButton multiplyButton = new JButton("*");
        multiplyButton.setBounds(230, 170, 50, 50);
        multiplyButton.addActionListener(controller);
        multiplyButton.setActionCommand("*");

        JButton percentButton = new JButton("%");
        percentButton.setBounds(290, 170, 50, 50);
        percentButton.addActionListener(controller);
        percentButton.setActionCommand("%");

        JButton divideButton = new JButton("/");
        divideButton.setBounds(230, 110, 50, 50);
        divideButton.addActionListener(controller);
        divideButton.setActionCommand("/");

        JButton equalsButton = new JButton("=");
        equalsButton.setBounds(290, 290, 50, 50);
        equalsButton.addActionListener(controller);
        equalsButton.setActionCommand("=");

        JButton changeSignButton = new JButton("+-");
        changeSignButton.setBounds(290, 230, 50, 50);
        changeSignButton.addActionListener(controller);
        changeSignButton.setActionCommand("+/-");

        JScrollPane scrollBar = new JScrollPane(textFieldSmall);
        scrollBar.setBounds(50, 15, 230, 40);
        scrollBar.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        panel.add(textField);
        panel.add(scrollBar);

        panel.add(nineButton);
        panel.add(eightButton);
        panel.add(sevenButton);
        panel.add(sixButton);
        panel.add(fiveButton);
        panel.add(fourButton);
        panel.add(threeButton);
        panel.add(twoButton);
        panel.add(oneButton);
        panel.add(zeroButton);

        panel.add(commaButton);
        panel.add(plusButton);
        panel.add(minusButton);
        panel.add(multiplyButton);
        panel.add(divideButton);
        panel.add(percentButton);
        panel.add(deleteButton);
        panel.add(equalsButton);
        panel.add(clearButton);
        panel.add(changeSignButton);

        return panel;
    }

    /**
     * @return main textfield where user inputs expression
     */
    public JTextField getTextField() {
        return textField;
    }

    /**
     * update main textfield with argument value
     *
     * @param value which will be placed
     */
    public void update(String value) {
        textField.setText(value);
    }

    /**
     * update result textfield with argument value
     *
     * @param value which will be placed into result text field
     */
    public void updateResult(String value) {
        textFieldSmall.setText(value);
    }
}

