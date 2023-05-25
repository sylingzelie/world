package com.sy.world;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.sy.world.entity.CajjOrder;
import com.sy.world.entity.Change;
import com.sy.world.tools.InsuranceDataListener;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootTest
public class CAJJ {

    @Test
    public void easyChangeExecl() {
        InsuranceDataListener<CajjOrder> pkInsuranceDataListener = new InsuranceDataListener();
        File change = new File("/Users/sunyang/Documents/2023/5/cajj.xlsx");
        EasyExcel.read(change.getPath(), CajjOrder.class, pkInsuranceDataListener).autoTrim(true).sheet("Sheet1").doRead();
        List<CajjOrder> cajjOrders = pkInsuranceDataListener.getList();
        List<List<String>> data = new ArrayList<>();
        ExcelWriter excelWriter = EasyExcel.write("/Users/sunyang/Documents/2023/5/cajjxxx.xlsx").build();
        StringBuilder sql = new StringBuilder("INSERT INTO busi_order (\n" +
                "\torder_code,\n" +
                "\torder_cardCode,\n" +
                "\torder_merchantId,\n" +
                "\torder_shopId,\n" +
                "\torder_rrn,\n" +
                "\torder_transId,\n" +
                "\torder_createtime,\n" +
                "\torder_updatetime,\n" +
                "\torder_status,\n" +
                "\torder_pay_prove,\n" +
                "\torder_pay_type,\n" +
                "\torder_actual_amt,\n" +
                "\torder_pro_group,\n" +
                "\torder_discount_type\n" +
                ")\n" +
                "VALUES ");
        StringBuilder sql1 = new StringBuilder("('%s',%s,%s,%s,%s,%s,'%s','%s','%s',%s,%s,'%s','%s','%s'),");
        List<List<String>> head = new ArrayList<>();
        head.add(Collections.singletonList("cajj"));
        cajjOrders.forEach(r -> {
            String prove;
            switch (r.getTransValidateType()) {
                case 0:
                    prove = r.getCardCode();
                    break;
                case 1:
                    prove = r.getCardBindMobile();
                    break;
                case 2:
                    prove = r.getTransCatpchaCode();
                    break;
                case 3:
                    prove = r.getPersonCertId();
                    break;
                default:
                    prove = "5";
            }

            data.add(Collections.singletonList(String.format(sql1.toString()
                    , r.getMerchantId() + r.getShopId() + System.currentTimeMillis()
                    , r.getCardCode()
                    , r.getMerchantId()
                    , r.getShopId()
                    , r.getTransRrn()
                    , r.getTransId()
                    , r.getTransDatetime()
                    , r.getTransDatetime()
                    , 2
                    , prove
                    , r.getTransValidateType() + 1
                    , r.getTransAmt()
                    , r.getMerchantProductGroupId()
                    , 0)));
        });
        String sheet = "Sheet".concat(String.valueOf(1));
        WriteSheet writeSheet = EasyExcel.writerSheet(1, sheet).head(head).build();
        excelWriter.write(data, writeSheet);
        excelWriter.finish();
    }
}
