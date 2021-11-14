package src.util;

import java.net.InetSocketAddress;
import java.net.Socket;

public class AppSocket {
    Socket socket;
    String ip;
    int port;

    public AppSocket(Socket socket, String ip, int port) {
        this.socket = socket;
        this.ip = ip;
        this.port = port;
        SocketConnection();
    }
    private void SocketConnection() {
        try {
            socket.connect(new InetSocketAddress(ip, port));
        } catch (Exception e) {
            System.out.println("Socket Connection failled: " + e.getStackTrace());
        }
    }


}
