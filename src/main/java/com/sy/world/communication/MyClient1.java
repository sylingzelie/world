package com.sy.world.communication;


import java.net.Socket;

public class MyClient1 {
    public static void main(String[] args) {
        new MyClient1().initClient("127.0.0.1", 10099);
    }

    public void initClient(String host, int port) {
        Socket socket;
        try {
            socket = new Socket(host, port);
            //启动客户端接收服务端的进程
            new Thread(new ReceiveThread(socket,this.toString())).start();
            //启动客户端向服务端发送消息的进程
            new Thread(new SendThread(socket)).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}