package com.sy.world;



import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.platform.commons.util.StringUtils;
import org.mockito.internal.util.StringUtil;

import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception {
        List<String> name = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        //创建workbook
//        Workbook workbook = Workbook.getWorkbook();
        InputStream inp = new FileInputStream(new File("D:\\2\\test1.xlsx"));
        Workbook wb = WorkbookFactory.create(inp);
        //获取第一个工作表sheet
        Sheet sheet = wb.getSheetAt(0);
        //获取数据
        int index;
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            String str = sheet.getRow(i).getCell(7).getStringCellValue();
            if (StringUtils.isNotBlank(str) && map.containsKey(str)) {
                List<Integer> l = map.get(str);
                l.add(i);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(str, l);
                name.add(str);
            }
        }
        index = name.stream().mapToInt(r -> map.get(r).size()).sum();
//        for (int j = 0; j < name.size(); j++) {
////            File file = new File("D:\\3\\" + name.get(j) + ".xlsx");
//            try {
////                file.createNewFile();
//                //创建工作薄
//                XSSFWorkbook work = new XSSFWorkbook();
//                //创建sheet
//                Sheet sheet1 = work.createSheet();
//                List<Integer> integers = map.get(name.get(j));
//                for (int i = 0; i < integers.size(); i++) {
//                    index++;
//                    Row row = sheet.getRow(integers.get(i));
//                    Row row1 = sheet1.createRow(i);
//                    for(int k = 0; k < 9; k++){
//                        row1.createCell(k).setCellValue(row.getCell(k).toString());
//                    }
//                }
//                FileOutputStream fileOut=new FileOutputStream("D:/3/" + name.get(j) + ".xlsx");
//                work.write(fileOut);
//                fileOut.close();
//                work.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        System.out.println(index);
        wb.close();
    }


}
