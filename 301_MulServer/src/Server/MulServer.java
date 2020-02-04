package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MulServer {
    public static void main(String[] args) {
        System.out.println("Server starting...");
        try (ServerSocket welcomeSocket = new ServerSocket(6666);){

            System.out.println("Waiting for connection...");

            //accept blockiert, bis Client verbunden ist!
            Socket clientSocket = welcomeSocket.accept();

            System.out.println("Client connected!");

            //Protocol goes here...
            new ClientHandler(clientSocket);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
