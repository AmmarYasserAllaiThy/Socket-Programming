/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * Created by: Ammar Yasser AllaiThy
 */

package TCP;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SumServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(2018);
            Socket client = server.accept();
            Scanner from = new Scanner(client.getInputStream());

            String nums[] = (from.nextLine().split(" "));

            int sum = 0;
            for (String num : nums)
                sum += Integer.parseInt(num);
            new PrintWriter(client.getOutputStream(), true).println(sum);

            client.close();
        } catch (IOException iox) {
            System.out.println(iox.getMessage());
        }
    }
}