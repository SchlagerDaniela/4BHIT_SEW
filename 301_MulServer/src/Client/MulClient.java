package Client;

import java.io.*;
import java.net.Socket;
import java.util.Random;

public class MulClient {
    public static void main(String[] args) {

        System.out.println("Client started, conncecting to server...");
        try (Socket serverSocket = new Socket("localhost", 6666);){
            System.out.println("Connection established!");

            //Communication starts
            Random r = new Random();
            int number1 = r.nextInt(100);
            int number2 = r.nextInt(100);

            System.out.println("Sending numbers...");
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(serverSocket.getOutputStream()));
            DataInputStream dis = new DataInputStream(new BufferedInputStream(serverSocket.getInputStream()));

            dos.writeInt(number1);
            dos.writeInt(number2);
            dos.flush();

            System.out.println("Receiving result...");
            int result = dis.readInt();

            System.out.println("Received result " + result);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
