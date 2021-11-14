package src.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class AppSocket {
    Socket socket;
    Socket client;
    String ip;
    ServerSocket server;
    int port;

    public AppSocket(Socket socket, String ip, int port) {
        this.socket = socket;
        this.ip = ip;
        this.port = port;
        SocketConnection();
    }
    private void SocketConnection() {
        try {
            server = new ServerSocket(port);
            socket = server.accept();
        } catch (Exception e) {
            System.out.println("Socket Connection failled: " + e);
        }
    }

    public void ListenSocket() {
        new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        BufferedReader r;
                        r = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter w = new PrintWriter(socket.getOutputStream(), true);
                        w.println("Welcome to appserver");
                        String line;
                        do {
                            line = r.readLine();

                            if (line != null)
                            {   w.println("Got: " + line);  }
                        }
                        while(!line.trim().equals("bye"));
                        socket.close();
                    }
                } catch (Exception e) {
                    System.out.println("Listen Socket: " + e);
                }
            }
        }.start();
    }
}
