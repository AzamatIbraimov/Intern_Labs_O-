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
public class Levels {

    public static int[][] getSeventhLevel() {
        return seventhLevel;
    }

    public static int[][] getEightLevel() {
        return eightLevel;
    }

    public static int[][] getNinethLevel() {
        return ninethLevel;
    }

    public static int[][] getTwoHundredLevel() {
        return twoHundredLevel;
    }

    public static int[][] getDefaultLevel() {
        return defaultLevel;
    }

    private static int[][] seventhLevel = new int[][]{
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 0, 0, 0, 0, 0, 1, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 3, 4, 0, 0, 2},
            {2, 0, 0, 0, 3, 4, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 3, 4, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 3, 4, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}};
    private static int[][] eightLevel = new int[][]{
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 0, 0, 0, 0, 2, 0, 1, 0, 2},
            {2, 0, 0, 0, 0, 2, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 2, 0, 4, 0, 2},
            {2, 0, 0, 0, 3, 0, 0, 0, 2, 2},
            {2, 0, 0, 0, 3, 0, 0, 0, 4, 2},
            {2, 0, 0, 0, 0, 2, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 2, 3, 4, 0, 2},
            {2, 0, 0, 0, 0, 2, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}};
    private static int[][] ninethLevel = new int[][]{
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 1, 2},
            {2, 0, 3, 4, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 3, 4, 2, 2, 0, 2},
            {2, 0, 3, 4, 3, 4, 0, 0, 0, 2},
            {2, 0, 0, 0, 3, 4, 0, 0, 0, 2},
            {2, 0, 0, 0, 3, 0, 4, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}};
    private static int[][] twoHundredLevel = new int[][]{
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 3, 4, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 3, 4, 2, 2, 0, 2},
            {2, 0, 3, 4, 3, 4, 0, 0, 0, 2},
            {2, 0, 0, 0, 3, 4, 0, 0, 0, 2},
            {2, 0, 0, 0, 3, 0, 4, 0, 0, 2},
            {2, 0, 0, 1, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}};
    private static int[][] defaultLevel = new int[][]{
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
            {2, 1, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 3, 4, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}};
}
