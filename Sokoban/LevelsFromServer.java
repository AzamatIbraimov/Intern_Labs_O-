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

import java.io.*;
import java.net.Socket;

/**
 * Client Server
 * connects to the IServer
 * gets the last version of server levels
 */
public class LevelsFromServer {
    /**
     * THIS METHOD IS STATIC, SO YOU DON'T NEED TO CREATE ISTANCE OF SERVERLEVELS CLASS
     * Synchronized to make it able to work in multithreading mode
     * Saves files from server in specific directory which path is stored in dowloadsDir
     * Gets the number of files in directory from server
     * Gets one file length
     * Creates file and transers the text from server file to local file
     * Repeats procedure for every file
     * When every file is transfered - closes stream
     * Catches exceptions
     */
    public synchronized static int[][] getLevelFromServer(int level) {
        try {
            Socket echoSocket = null;
            ObjectOutputStream outputStream = null;
            ObjectInputStream inputStream = null;

            echoSocket = new Socket("157.245.219.46", 4445);

            outputStream = new ObjectOutputStream(new BufferedOutputStream(echoSocket.getOutputStream()));
            outputStream.writeInt(level);

            outputStream.flush();

            inputStream = new ObjectInputStream(new BufferedInputStream(echoSocket.getInputStream()));
            int[][] myMessageArray = (int[][]) inputStream.readObject();

            inputStream.close();
            outputStream.close();
            echoSocket.close();
            return myMessageArray;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
