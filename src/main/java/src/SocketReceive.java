package src;

import src.util.AppSocket;

import java.net.Socket;

public class SocketReceive {
    private static AppSocket app;
    protected static Socket socket = new Socket();
    private static final String IP = "192.168.15.2";
    public static void main(String[] args) {

        app = new AppSocket(socket, IP, 666);


    }

}
