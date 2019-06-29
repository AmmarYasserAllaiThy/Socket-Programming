package TCP_MultiClient;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] Ammar) {
        try {
            ServerSocket server = new ServerSocket(1997);
            while (true) {
                Socket new_Client = server.accept();
                new MultiClient(new_Client).start();
            }
        } catch (IOException iox) {
            System.out.println(iox.getMessage());
        }
    }

    static class MultiClient extends Thread {

        static Socket client;
        static Scanner fromClient;
        static String clientMsg;
        static PrintWriter toClient;

        public MultiClient(Socket s) {
            client = s;
        }

        public void run() {
            try {
                fromClient = new Scanner(client.getInputStream());
                clientMsg = fromClient.nextLine();
                toClient = new PrintWriter(client.getOutputStream(), true);

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
}