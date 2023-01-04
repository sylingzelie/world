package com.sy.world.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.axis.utils.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SdgwPush {
    public static void main(String[] args) throws IOException {
        try {
            /*
             *简单判断后缀名，如需通过文件流判断文件类型，
             * 请调用getFileTypeByStream方法
             * Excel( xls) 文件头：504B03
             * Excel( xlsx) 文件头：D0CF11
             * */
            String filePath = "/Users/sunyang/Documents/8/山东国网6月案件（1）.xls";
            boolean xls = filePath.endsWith(".xls");
            boolean xlsx = filePath.endsWith(".xlsx");
            Workbook book;
            Sheet sheet = null;
            InputStream inputStream = new FileInputStream(filePath);
            if (xls) {
                // 解析excel
                POIFSFileSystem pSystem = new POIFSFileSystem(inputStream);
                // 获取整个excel
                book = new HSSFWorkbook(pSystem);
                //获取第一个表单sheet
                sheet = book.getSheetAt(4);
            }
            if (xlsx) {
                // 直接通过流获取整个excel
                book = new XSSFWorkbook(inputStream);
                // 获取第一个表单sheet
                sheet = book.getSheetAt(4);
            }
            if (sheet != null) {
                // 获取第一行
                int firstRow = sheet.getFirstRowNum();
                // 获取最后一行
                int lastRow = sheet.getLastRowNum();
                // 循环行数依次获取列数
                for (int i = firstRow + 1; i < lastRow + 1; i++) {
                    // 获取第 i 行
                    Row row = sheet.getRow(i);
                    if (StringUtils.isEmpty(row.getCell(1).toString().trim()) || StringUtils.isEmpty(row.getCell(2).toString().trim()))
                        continue;
                    String pici = row.getCell(1).toString().replaceAll("\\.0", "");
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("userCode", "test02");
                    jsonObject.put("password", "888888");
                    jsonObject.put("serialNum", row.getCell(2).getStringCellValue());
                    List<JSONObject> list = new ArrayList<>();
                    JSONObject json = null;
                    int index = 0;
                    json = new JSONObject();
                    json.put("imageUrl", "https://bucket-pktest.oss-cn-hangzhou.aliyuncs.com/sdgw/" + pici + ".jpg");
                    // 身份证号+报销类型+月份+序号
                    json.put("imageNewname", String.format("%s1%02d%04d.jpg", row.getCell(0).toString(), LocalDate.now().getMonthValue(), ++index));
                    list.add(json);
                    jsonObject.put("imageContentList", list);
                    JSONObject jsonObject1 = pushFilePost(jsonObject.toString());
                    try {
                        if (jsonObject1.get("errorCode").toString().equals("0")) {
                            System.out.println(row.getCell(3).toString());
                        } else {
                            throw new RuntimeException(jsonObject1.get("errorMessage").toString());
                        }
                    } catch (Exception e) {
                        System.out.println("错误：" + e.getMessage() + "---------" + row.getCell(3).toString());
                    }
                }
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static JSONObject pushFilePost(String params) throws IOException {
        URL url = new URL("http://106.15.233.48:8096/ShanDongImg/oss/uploadOSSImgs");
        // 打开和URL之间的连接
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
        connection.setRequestProperty("Connection", "Keep-Alive");
        connection.setUseCaches(false);
        connection.setDoOutput(true);
        connection.setDoInput(true);
        // 得到请求的输出流对象
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        out.write(params.getBytes(StandardCharsets.UTF_8));
        out.flush();
        out.close();
        // 建立实际的连接
        connection.connect();
        // 定义 BufferedReader输入流来读取URL的响应
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
        StringBuilder result = new StringBuilder();
        String getLine;
        while ((getLine = in.readLine()) != null) {
            result.append(getLine);
        }
        in.close();
        return JSONObject.parseObject(result.toString());
    }
}
