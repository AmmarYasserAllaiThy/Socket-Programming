package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] Ammar) {
        try {
            DatagramSocket DS = new DatagramSocket(1998);
            Scanner sc = new Scanner(System.in);
            String userMsg, response;
            DatagramPacket outPack, inPack;
            byte[] buffer;

            do {
                System.out.print("Plz Enter Message: ");
                userMsg = sc.nextLine();
                outPack = new DatagramPacket(userMsg.getBytes(), userMsg.length(), InetAddress.getLocalHost(), 1997);
                DS.send(outPack);

                buffer = new byte[256];
                inPack = new DatagramPacket(buffer, buffer.length);
                DS.receive(inPack);

                response = new String(inPack.getData(), 0, inPack.getLength()); //new String(inPack.getData());
                System.out.println("Server -> " + response);
            } while (!userMsg.equalsIgnoreCase("close"));

        } catch (IOException iox) {
            System.out.println("Client " + iox.getMessage());
        } finally {
            System.out.println("UDP Client, Thank U");
        }
    }
}