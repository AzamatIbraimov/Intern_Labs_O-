/**
 * Copyright (C) 2020 Intern Labs O!
 * <p>
 * Calculator program
 * This program uses MVC pattern
 *
 * @author Erkin Koshoev
 * @author Azamat Ibraimov
 */

import java.util.Stack;

/**
 * Reverse Polish Notation is mathematical notation in which every operator (eg. + – * %) follows all of its operands
 */

public class ReversePolishNotation {

    /**
     * Main method which calculates full expression
     * Takes full String expression as argument
     * Firstly converts our String expression to Reverse Polish Notation by dividing our expression on two stacks
     * <p>
     * After converting our expression -> calculates our answer by calculating expressions by operators one after another
     *
     * @param expression - full expression as String value
     * @return answer
     */
    public double reversPolishNotation(String expression) {
        Stack<Object> mainStack = new Stack<>();
        Stack<Object> operations = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char currentCharacter = expression.charAt(i);
            if (isOperator(currentCharacter) && i != 0) {
                while (!operations.isEmpty() && priority((char) operations.peek()) >= priority(currentCharacter)) {
                    calculateValue(mainStack, (char) operations.pop());
                }
                operations.addElement(currentCharacter);
            } else {
                StringBuilder operand = new StringBuilder(); // We use StringBuilder to make string concatination more efficent(standart String is immutable in JAVA)
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.' || (expression.charAt(i) == '-') && i == 0)) {
                    operand.append(expression.charAt(i++));
                }
                --i;
                mainStack.addElement(Double.parseDouble(operand.toString()));
            }
        }

        while (!operations.isEmpty())
            calculateValue(mainStack, (char) operations.pop());
        return (Double) mainStack.get(0);
    }

    /**
     * Calculates every expression by its operation
     *
     * @param stack     with numbers
     * @param operation to do
     */
    private void calculateValue(Stack<Object> stack, char operation) {
        double answer;
        double x = (double) stack.pop();
        if (operation == '%') {
            answer = x / 100.0;
            stack.addElement(answer);
        } else {
            double y = (double) stack.pop();
            switch (operation) {
                case '+':
                    answer = x + y;
                    stack.addElement(answer);
                    break;
                case '-':
                    answer = y - x;
                    stack.addElement(answer);
                    break;
                case '*':
                    answer = x * y;
                    stack.addElement(answer);
                    break;
                case '/':
                    if (x == 0)
                        throw new IllegalArgumentException("Argument 'divisor' is 0");
                    answer = y / x;
                    stack.addElement(answer);
                    break;
            }
        }
    }

    /**
     * We need to know the order of calculations
     *
     * @param operator + || - || * || / || %
     * @return priority of operator
     */
    private static int priority(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            default:
                return -1;
        }
    }


    /**
     * Checks if character is operator
     *
     * @return boolean true/false
     */
    private boolean isOperator(char character) {
        return character == '+' || character == '-' || character == '*' || character == '/' || character == '%';
    }

}

