package com.sy.world.communication;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 服务端发送消息的线程
 *
 * @author wangjue
 *
 */

public class SendThread implements Runnable {
    private Socket socket;

    public SendThread(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            OutputStream ops = socket.getOutputStream();
            while (true) {
                Scanner sc = new Scanner(System.in);
                String s = sc.nextLine() + "\n";
                ops.write(s.getBytes());
                ops.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
