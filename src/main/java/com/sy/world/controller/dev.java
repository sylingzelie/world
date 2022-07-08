package com.sy.world.controller;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class dev {

    public static void main(String[] args) throws Exception {
//        File file = new File("D:\\1\\224400028001\\都是.png");
//        InputStream inputStream = new FileInputStream(file);
//        System.out.println(inputStream);
        String url1 = "http://localhost:8997/account/getYBQueryTrace?";
        URL url = new URL(url1);    // 把字符串转换为URL请求地址
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 打开连接
        connection.connect();// 连接会话
        // 获取输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {// 循环读取流
            sb.append(line);
        }
        br.close();// 关闭流
        connection.disconnect();// 断开连接
        System.out.println(sb.toString());
    }

}

