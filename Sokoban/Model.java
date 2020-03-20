import javax.swing.*;

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

public class Model {

    /**
     * Model directly manages the data, logic and rules of the application.
     * Model needs Viewer to send data to Viewer directly
     * Level instance help us to load and switch levels
     * Music allows us to turn on/off music
     * Painter is used to choose color and type of marking
     */

    private Viewer viewer;
    private int[][] desktop;
    private int indexX;
    private int indexY;
    private Levels levels;
    private int[][] arrayIndexies;
    private int level;
    private Music music;

    /**
     * Model initialization with Viewer intance
     * By default game starts from first level
     * When model is initialized it downloads all levels from server and saves it in levels diractory
     * We also need to know the position of a player and send it in indexX, indexY
     *
     * @param viewer
     */


    public Model(Viewer viewer) {
        level = 1;
        this.viewer = viewer;
        levels = new Levels();
        desktop = levels.startLevel(level);

        int[] playerIndexes = getPlayerIndexes(desktop);
        indexX = playerIndexes[0];
        indexY = playerIndexes[1];

        initialization();
    }

    public void initialization() {
        int counterFour = 0;
        for (int[] ints : desktop) {
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] == 4) {
                    counterFour = counterFour + 1;
                }
            }
        }

        arrayIndexies = new int[2][counterFour];

        int count = 0;
        for (int i = 0; i < desktop.length; i++) {
            for (int j = 0; j < desktop[i].length; j++) {
                if (desktop[i][j] == 4) {
                    arrayIndexies[0][count] = i;
                    arrayIndexies[1][count] = j;
                    count++;
                }
            }
        }
    }

    /**
     * @return 2d array, to paint map for the game
     */
    public int[][] getDesktop() {
        return desktop;
    }

    /**
     * This function listens the move directions from controller
     * Then updates viewer and checks if player won
     *
     * @param direction
     */
    public void move(String direction) {
        switch (direction) {
            case "Right":
                moveRight();
                break;
            case "Left":
                moveLeft();
                break;
            case "Up":
                moveUp();
                break;
            case "Down":
                moveDown();
                break;
            default:
        }
        viewer.update();
        check();
    }

    /**
     * Listens for Action events from menu
     * Then calls private methods
     *
     * @param command
     */

    public void doAction(String command) {
        switch (command) {
            case "Restart":
                getNewLevel(level);
                break;
            case "Exit":
                exit();
                break;
            case "Level 1":
                getNewLevel(1);
                level = 1;
                break;
            case "Level 2":
                getNewLevel(2);
                level = 2;
                break;
            case "Level 3":
                getNewLevel(3);
                level = 3;
                break;
            case "Level 4":
                getNewLevel(4);
                level = 4;
                break;
            case "Level 5":
                getNewLevel(5);
                level = 5;
                break;
            case "Level 6":
                getNewLevel(6);
                level = 6;
                break;
            case "Music":
                runMusic();
                break;
            case "Choose level":
                levelChooser();
                break;
            default:
        }
    }

    /**
     * Moves up
     */
    private void moveUp() {
        if (desktop[indexX - 1][indexY] == 3) {
            if (desktop[indexX - 2][indexY] == 0 || desktop[indexX - 2][indexY] == 4) {
                desktop[indexX - 1][indexY] = 0;
                desktop[indexX - 2][indexY] = 3;
            }
        }

        if (desktop[indexX - 1][indexY] == 0 || desktop[indexX - 1][indexY] == 4) {
            desktop[indexX][indexY] = 0;
            indexX -= 1;
            desktop[indexX][indexY] = 1;
        }
    }

    /**
     * Moves Down
     */
    private void moveDown() {
        if (desktop[indexX + 1][indexY] == 3) {
            if (desktop[indexX + 2][indexY] == 0 || desktop[indexX + 2][indexY] == 4) {
                desktop[indexX + 1][indexY] = 0;
                desktop[indexX + 2][indexY] = 3;
            }
        }

        if (desktop[indexX + 1][indexY] == 0 || desktop[indexX + 1][indexY] == 4) {
            desktop[indexX][indexY] = 0;
            indexX += 1;
            desktop[indexX][indexY] = 1;
        }
    }


    /**
     * Moves right
     */
    private void moveRight() {
        if (desktop[indexX][indexY + 1] == 3) {
            if (desktop[indexX][indexY + 2] == 0 || desktop[indexX][indexY + 2] == 4) {
                desktop[indexX][indexY + 1] = 0;
                desktop[indexX][indexY + 2] = 3;
            }
        }

        if (desktop[indexX][indexY + 1] == 0 || desktop[indexX][indexY + 1] == 4) {
            desktop[indexX][indexY] = 0;
            indexY += 1;
            desktop[indexX][indexY] = 1;
        }
    }

    /**
     * Moves left
     */
    private void moveLeft() {
        if (desktop[indexX][indexY - 1] == 3) {
            if (desktop[indexX][indexY - 2] == 0 || desktop[indexX][indexY - 2] == 4) {
                desktop[indexX][indexY - 1] = 0;
                desktop[indexX][indexY - 2] = 3;
            }
        }

        if (desktop[indexX][indexY - 1] == 0 || desktop[indexX][indexY - 1] == 4) {
            desktop[indexX][indexY] = 0;
            indexY -= 1;
            desktop[indexX][indexY] = 1;
        }
    }

    /**
     * Checks if player won
     * Flag is our answer
     * By default flag is true
     * If all boxes are not in goals makes it false
     *
     * @return
     */

    private boolean checkWin() {
        boolean flag = true;
        for (int z = 0; z < arrayIndexies[0].length; z++) {
            int i = arrayIndexies[0][z];
            int x = arrayIndexies[1][z];
            if (desktop[i][x] == 4 || desktop[i][x] == 1) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * Checks if player won
     * If won switches on next level
     */
    private void check() {
        int t = 0;
        for (int j = 0; j < arrayIndexies[0].length; j++) {
            int x = arrayIndexies[0][t];
            int y = arrayIndexies[1][t];
            if (desktop[x][y] == 0) {
                desktop[x][y] = 4;
                break;
            }
            t++;
        }
        if (checkWin()) {
            viewer.showWin();
            level = level + 1;
            getNewLevel(level);
        }
    }

    /**
     * Founds player starting position on map
     */
    private int[] getPlayerIndexes(int[][] map) {
        int[] result = new int[2];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    /**
     * Switches to new level by calling levels startLevel method
     *
     * @param numOfLevel
     */

    private void getNewLevel(int numOfLevel) {
        desktop = levels.startLevel(numOfLevel);
        int[] playerIndexes = getPlayerIndexes(desktop);
        indexX = playerIndexes[0];
        indexY = playerIndexes[1];
        initialization();
        viewer.update();
    }

    /**
     * Terminate game
     */

    private void exit() {
        System.exit(1);
    }

    /**
     * Run music method
     * Checks if music is running
     * If false:
     * Creates new music thread every time
     * If true:
     * Terminates music thread and changes flag
     */

    private void runMusic() {
        music.runMusic();
    }

    public void goMusic() {
        music = new Music();
        music.start();
    }

    private void levelChooser() {
        try {
            level = Integer.parseInt(JOptionPane.showInputDialog("Choose level"));
            if (level <= 0)
                throw new NumberFormatException();
            else
                getNewLevel(level);
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid level");
        }
    }

}

