/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * Created by: Ammar Yasser AllaiThy
 */

package Quiz;

import java.io.IOException;
import java.net.*;

public class Q2Server {
    public static void main(String[] args) {
        try {
            ServerSocket TS = new ServerSocket(12345);
            Socket client = TS.accept();
            DatagramSocket UC = new DatagramSocket(12345);

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
