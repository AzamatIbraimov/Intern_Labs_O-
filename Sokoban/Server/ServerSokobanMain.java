import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class ServerSokobanMain {

    private ServerSocket serverSocket;

    public ServerSokobanMain(int port) {
        try {
            serverSocket = new ServerSocket(port);
        } catch(IOException ioe) {
            System.out.println(ioe);
        }
    }

    public void runServer() {
        while(true) {
            try {
                System.out.println("Waiting a client ... ");
                Socket clientSocket = serverSocket.accept();
                Client client = new Client(clientSocket);
                client.sendLevelToClient();
                System.out.println("---------------------");
            } catch(IOException ioe) {
                System.out.println(ioe);
            }
        }
    }

    public static void main(String[] args) {
        ServerSokobanMain serverSokobanMain = new ServerSokobanMain(4445);
        serverSokobanMain.runServer();
    }
}
