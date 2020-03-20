import java.io.*;
import java.net.Socket;

public class Client implements Runnable {

    private Thread thread;
    private Socket clientSocket;

    public Client(Socket clientSocket) {
        this.clientSocket = clientSocket;
        thread = new Thread(this);
    }

    public void sendLevelToClient() {
        thread.start();
    }

    public void run() {
        try {

            ObjectInputStream inputStream = new ObjectInputStream(new BufferedInputStream(clientSocket.getInputStream()));
            int level = inputStream.readInt();
            System.out.println("Client is waiting level : " + level);

            ObjectOutputStream outputStream = new ObjectOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));
            if (level < 255) {
                switch (level) {
                    case 7:
                        outputStream.writeObject(Levels.getSeventhLevel());
                        break;
                    case 8:
                        outputStream.writeObject(Levels.getEightLevel());
                        break;
                    case 9:
                        outputStream.writeObject(Levels.getNinethLevel());
                        break;
                    default:
                        outputStream.writeObject(Levels.getDefaultLevel());
                }
            } else
                switch (level % 255) {
                    case 0:
                        outputStream.writeObject(Levels.getTwoHundredLevel());
                        break;
                    case 1:
                        outputStream.writeObject(Levels.getSeventhLevel());
                        break;
                    case 2:
                        outputStream.writeObject(Levels.getEightLevel());
                        break;
                    case 3:
                        outputStream.writeObject(Levels.getNinethLevel());
                        break;
                    default:
                        outputStream.writeObject(Levels.getDefaultLevel());
                }
            outputStream.close();
            inputStream.close();
            clientSocket.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}