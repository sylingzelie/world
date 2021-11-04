package com.sy.world.communication;

import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) {
        new MyServer().initServer(10099);
    }

    public void initServer(int port) {
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("succeed  ....");
            int count = 0;
            while (true) {
                count++;
                Socket socket = server.accept();
                System.out.println("connect" + (count) + "clien:" + socket.getRemoteSocketAddress());
                new Thread(new ReceiveThread(socket,this.toString())).start();
                new Thread(new SendThread(socket)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

