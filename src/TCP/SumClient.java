package TCP;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SumClient {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 2018);
            PrintWriter toServer = new PrintWriter(client.getOutputStream(), true);
            String result;

            System.out.println("Enter set of numbers: ");
            toServer.println(new Scanner(System.in).nextLine());
            result = new Scanner(client.getInputStream()).nextLine();
            System.out.println(result);

            client.close();
        } catch (IOException iox) {
            System.out.println(iox.getMessage());
        }
    }
}
