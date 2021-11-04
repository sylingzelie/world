package com.sy.world.communication;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.Socket;

/**
 * 服务端接收客户端的消息的线程
 *
 * @author wangjue
 *
 */

public class ReceiveThread implements Runnable {
    private String name;
    private Socket socket;

    public ReceiveThread(Socket socket,String name) {
        this.socket = socket;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            InputStream ips = socket.getInputStream();
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            while (true) {
                int t = ips.read();
                while (t != '\n') {
                    bao.write(t);
                    t = ips.read();
                }
                byte[] b = bao.toByteArray();
                String msg = new String(b);
                System.out.println(socket.getPort()+ ": " + msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}