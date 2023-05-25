package com.sy.world;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.sy.world.entity.RTDataEntity;
import com.sy.world.tools.InsuranceDataListener;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
public class RTDataComparison {

    @Test
    public void test() {
        InsuranceDataListener<RTDataEntity> rtInsuranceDataListener = new InsuranceDataListener();
        File rtData = new File("/Users/sunyang/Documents/2023/4/瑞泰4-28.xlsx");
        EasyExcel.read(rtData.getPath(), RTDataEntity.class, rtInsuranceDataListener).autoTrim(true).sheet("Sheet1").doRead();
        List<RTDataEntity> rts = rtInsuranceDataListener.getList();
//        List<List<String>> data = new ArrayList<>();
//        ExcelWriter excelWriter = EasyExcel.write("/Users/sunyang/Documents/2023/4/对比结果.xlsx").build();
        Map<String, List<RTDataEntity>> stringListMap = rts.stream().collect(Collectors.groupingBy(RTDataEntity::getBillCode));

        stringListMap.forEach((k, y) -> {
            Map<Integer, List<RTDataEntity>> map = y.stream().collect(Collectors.groupingBy(RTDataEntity::getAmt));
            map.forEach((k1, y1) -> {
                if (y1.size() > 2) {
                    Map<Integer, List<RTDataEntity>> collect = y1.stream().collect(Collectors.groupingBy(RTDataEntity::getAmtBefore));
                    if (collect.size() > 1) {
                        int sum = y1.stream().mapToInt(RTDataEntity::getAmtBefore).sum();
                        int i = y1.size() / 2;
                        int num = 0;
                        for (int j = 0; j < i; j++) {
                            num += y1.get(j).getAmtBefore();
                        }
                        if (sum/2 != num) {
                            System.out.println(k);
                        }
                    }
                } else if(y1.size() == 2){
                    if (!y1.get(0).getAmtBefore().equals(y1.get(1).getAmtBefore())) {
                        System.out.println(k);
                    }
                }
            });
        });
//        String sheet = "Sheet".concat("1");
//        WriteSheet writeSheet = EasyExcel.writerSheet(sheet).build();
//        excelWriter.write(data, writeSheet);
//        data.clear();
//        excelWriter.finish();
    }
}
