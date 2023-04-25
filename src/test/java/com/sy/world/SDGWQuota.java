package com.sy.world;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sy.world.entity.SDGWEntity;
import com.sy.world.enums.Bcylcbzt;
import com.sy.world.enums.Mzbzzt;
import com.sy.world.enums.Ryzt;
import com.sy.world.tools.InsuranceDataListener;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class SDGWQuota {
    static ThreadPoolExecutor threadPoolExecutor =
            new ThreadPoolExecutor(50, 100, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000));
    static ThreadPoolExecutor.DiscardOldestPolicy discardOldestPolicy = new ThreadPoolExecutor.DiscardOldestPolicy();

    public static void main(String[] args) {
        List<List<String>> data = new ArrayList<>();
        InsuranceDataListener<SDGWEntity> pkInsuranceDataListener = new InsuranceDataListener();
        File sdgw = new File("/Users/sunyang/Documents/2023/4/sdgw身份证.xlsx");
        EasyExcel.read(sdgw.getPath(), SDGWEntity.class, pkInsuranceDataListener).autoTrim(true).sheet("Sheet1").doRead();
        List<List<String>> head = new ArrayList<>();
        head.add(Collections.singletonList("cd"));
        List<SDGWEntity> sdgwEntities = pkInsuranceDataListener.getList();
        String url = "http://47.100.163.230:8866/dispatcher/post1.do";
        List<JSONObject> mzbzList = new ArrayList<>();
        JSONObject itemMap = new JSONObject();
        itemMap.put("JGBH", "03");
        itemMap.put("ND", "2023");

        for (SDGWEntity sdgwEntity : sdgwEntities) {
            Runnable runnable = () -> {
                BufferedReader in = null;
                itemMap.put("SFZH", sdgwEntity.getCertId());
                mzbzList.clear();
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
                    in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    // 打印响应结果
                    JSONObject jsonObject = JSONObject.parseObject(response.toString());
                    String datas = jsonObject.getString("DATAS");
                    JSONArray objects = JSONObject.parseArray(datas);
                    if (objects == null || objects.size() < 1 || objects.get(0) == null) {
                        data.add(Collections.singletonList(sdgwEntity.getCertId()));
                        data.add(Collections.singletonList(response.toString()));
                        log.info(response.toString());
                    } else {
                        List<String> list = new ArrayList<>();
                        JSONObject jsonObject1 = JSONObject.parseObject(objects.get(0).toString());
                        list.add(sdgwEntity.getCertId());
                        list.add(Bcylcbzt.getValue(jsonObject1.getString("BCYLCBZT")));
                        list.add(jsonObject1.getString("NDSYE"));
                        list.add(jsonObject1.getString("XM"));
                        list.add(Ryzt.getValue(jsonObject1.getString("RYZT")));
                        list.add(Mzbzzt.getValue(jsonObject1.getString("MZBZZT")));
                        list.add(jsonObject1.getString("DWCBZT"));
                        data.add(list);
                        log.info(response.toString());
                    }
                    if (Objects.isNull(in)) {
                        in.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            };
            discardOldestPolicy.rejectedExecution(runnable, threadPoolExecutor);
        }
        String sheet = "Sheet".concat(String.valueOf(1));
        WriteSheet writeSheet = EasyExcel.writerSheet(sheet).build();
        ExcelWriter excelWriter = EasyExcel.write("/Users/sunyang/Documents/2023/4/山东国网余额.xlsx").build();
        excelWriter.write(data, writeSheet);
        data.clear();
        excelWriter.finish();


    }
}