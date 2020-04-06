/**
 * Copyright (C) 2020 Intern Labs O!
 * <p>
 * Calculator program
 * This program uses MVC pattern
 *
 * @author Erkin Koshoev
 * @author Azamat Ibraimov
 */

public class Model {

    /**
     * Model directly manages the data, logic and rules of the application.
     * Model needs Viewer to send data to Viewer directly
     * String mainValue stores text from Viewer's main text field
     * String resultValue stores text from Viewer's resul text field
     */
    private Viewer viewer;
    private String mainExpression; 
    private String result;
    private ReversePolishNotation reversePolishNotation;

    /**
     * Model needs viewer in it's constructor as parameter
     * For all calculations we are using Reverse Polish Notation
     * That is why model creates new instance of RPN class
     */
    public Model(Viewer viewer) {
        this.viewer = viewer;
        reversePolishNotation = new ReversePolishNotation();
        mainExpression = "";
        result = "";
    }

    /**
     * Main logic of the program
     * When Controller sends some String command Model analyzes it and does action
     * Switch operator is used for efficent activity
     * When case is found - break operator works
     */
    public void doAction(String value) {
        switch (value) {

            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
                doOperation(value);
                break;

            case "=":
                getAnswer();
                break;

            case "+/-":
                changeSign();
                break;

            case "Clear":
                clear();
                break;

            case "Delete":
                deleteLastCharacter();
                break;

            default:
                continueExpression(value);
                break;
        }
    }

    /**
     * Continues expression when user inputs number
     *
     * @param value number
     */
    private void continueExpression(String value) {
        mainExpression += value;
        viewer.update(mainExpression);
    }

    /**
     * This method adds operations to expression
     * Also checks user not to input two operations in a row(like /% or *- etc.)
     */
    private void doOperation(String operation) {
        result += mainExpression + operation;

        if (result.length() >= 2) {
            if (result.substring(result.length() - 2, result.length() - 1).equals("+")
                    || result.substring(result.length() - 2, result.length() - 1).equals("-")
                    || result.substring(result.length() - 2, result.length() - 1).equals("*")
                    || result.substring(result.length() - 2, result.length() - 1).equals("/")
                    || result.substring(result.length() - 2, result.length() - 1).equals("%")) {
                result = result.substring(0, result.length() - 2);
                result = result + operation;
            }
        }
        viewer.updateResult(result);
        mainExpression = "";
        viewer.update(mainExpression);
    }

    /**
     * The main logic of program
     * Finds result of expression using Reverse Polish Notation
     */
    private void getAnswer() {
        try {
            double answer = reversePolishNotation.reversPolishNotation(result + mainExpression);
            mainExpression = roundAnswer(answer);
            viewer.updateResult(result + viewer.getTextField().getText() + " = ");
            viewer.update(mainExpression);
            result = "";
        } catch (Exception e) {
            System.out.println(e);
            viewer.update("Bad expression!");
        }
    }

    /**
     * This methods resolves problem with redundant zero in answer
     * If rounded number equals non-rounded -> deletes redundant zero and dot
     * If not returns original number
     *
     * @param number to check
     * @return number converted to String
     */
    private String roundAnswer(double number) {
        return Math.floor(number) == number ? String.valueOf((int) number) : String.valueOf(number);
    }

    /**
     * This method changes sign of main expression
     * If it was '+' -> makes it '-'
     * If it was '-' -> makes it '+'
     * If expression is too short catches exception
     */
    private void changeSign() {
        try {
            if ((mainExpression.substring(0, 1)).equals("-")) {
                mainExpression = mainExpression.substring(1);
            } else {
                mainExpression = "-" + mainExpression;
            }
            viewer.update(mainExpression);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Cannot change sign!");
        }
    }

    /**
     * Clear upper and lower text fields
     */
    private void clear() {
        mainExpression = "";
        result = "";
        viewer.updateResult(result);
        viewer.update(mainExpression);
    }


    /**
     * Method deleted last character from String str
     */
    private void deleteLastCharacter() {
        try {
            mainExpression = mainExpression.substring(0, mainExpression.length() - 1);
            viewer.update(mainExpression);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Error! No characters left");
        }
    }


}

