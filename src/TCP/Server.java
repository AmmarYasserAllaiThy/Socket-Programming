package TCP;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1997);
            Socket client = server.accept();
            Scanner fromClient = new Scanner(client.getInputStream());
            String clientMsg = fromClient.nextLine();
            PrintWriter toClient = new PrintWriter(client.getOutputStream(), true);

            while (!clientMsg.equalsIgnoreCase("close")) {
                toClient.println(clientMsg + ", is received");
                clientMsg = fromClient.nextLine();
            }

            toClient.println("Bye-Bye");
            client.close();

        } catch (IOException iox) {
            System.out.println(iox.getMessage());
        }
    }
}