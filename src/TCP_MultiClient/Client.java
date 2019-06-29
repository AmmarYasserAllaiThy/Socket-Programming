package TCP_MultiClient;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] Ammar) {
        try {
            Socket client = new Socket("localhost", 1997);
            Scanner fromUser = new Scanner(System.in);
            String userMsg;
            PrintWriter toServer = new PrintWriter(client.getOutputStream(), true);
            Scanner fromServer = new Scanner(client.getInputStream());

            do {
                System.out.print("Plz Enter a Message: ");
                userMsg = fromUser.nextLine();
                toServer.println(userMsg);
                System.out.println("MC_Server: " + fromServer.nextLine());
            } while (!userMsg.equalsIgnoreCase("close"));

            client.close();

        } catch (IOException iox) {
            System.out.println(iox.getMessage());
        } finally {
            System.out.println("TCP MultiClient: Thank You for Trying");
        }
    }
}