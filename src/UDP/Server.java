package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] Ammar) {
        try {
            DatagramSocket DS = new DatagramSocket(1997);
            // Q: Why port 1997 didn't work ? and throws Exception in Client.java -> Client Address already in use: Cannot bind
            // A: because both server and client on the same device.
            byte[] buffer;
            DatagramPacket inPack, outPack;
            String clientMsg;

            while (true) {
                buffer = new byte[256];
                inPack = new DatagramPacket(buffer, buffer.length);
                DS.receive(inPack);
                clientMsg = new String(inPack.getData(), 0, inPack.getLength()); //new String(inPack.getData());

                if (clientMsg.equalsIgnoreCase("close"))
                    clientMsg = "Bye-Bye";

                outPack = new DatagramPacket(clientMsg.getBytes(), clientMsg.length(), inPack.getAddress(), inPack.getPort());
                DS.send(outPack);
            }
        } catch (IOException iox) {
            System.out.println("Server " + iox.getMessage());
        }
    }
}