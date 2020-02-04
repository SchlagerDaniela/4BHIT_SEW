package Server;

import java.io.*;
import java.net.Socket;

public class ClientHandler {

    public ClientHandler(Socket clientSocket) {
        try {
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));
            DataInputStream dis = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));

            //Communication
            System.out.println("Retrieving data...");
            int number1 = dis.readInt();
            int number2 = dis.readInt();
            System.out.println("Received: " + number1 + ", " + number2);

            int result = number1 * number2;

            System.out.println("Sending: " + result);
            dos.writeInt(result);
            dos.flush();

            //Communication ends

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                clientSocket.close();
                System.out.println("Connection closed!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
