package com.sy.world;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sy.world.entity.SDGWEntity;
import com.sy.world.tools.InsuranceDataListener;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SDGWQuota1 {
    public static void main(String[] args) {
        String url = "http://47.100.163.230:8866/dispatcher/post1.do";
        List<JSONObject> mzbzList = new ArrayList<>();
        JSONObject itemMap = new JSONObject();
        itemMap.put("JGBH", "03");
        itemMap.put("ND", "2023");
        itemMap.put("SFZH", "110108196910192232");
        mzbzList.add(itemMap);
        JSONObject params = new JSONObject();
        params.put("DATAS", mzbzList);
        // 将请求参数写入输出流
        try {
            // 创建URL对象
            URL obj = new URL(url);
            // 打开连接
            HttpURLConnection connection = null;
            connection = (HttpURLConnection) obj.openConnection();
            // 设置请求方法为POST
            connection.setRequestMethod("POST");
            // 启用输出流
            connection.setDoOutput(true);
            // 设置请求头部信息
            connection.setRequestProperty("serviceNo", "SDGW");
            connection.setRequestProperty("appno", "51000");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.connect();
            // 获取输出流
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(params.toString().getBytes());
            outputStream.flush();
            outputStream.close();
            String inputLine;
            StringBuilder response = new StringBuilder();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            // 打印响应结果
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}