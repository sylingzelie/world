package com.sy.world;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.sy.world.entity.*;
import com.sy.world.tools.AESUtils;
import com.sy.world.tools.InsuranceDataListener;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
public class YCAccountDetail {

    static Integer index = 1;

    @Test
    public void easyExecl() {
        InsuranceDataListener<Quota> pkInsuranceDataListener = new InsuranceDataListener();
        InsuranceDataListener<Quota> ycInsuranceDataListener = new InsuranceDataListener();
        File pk = new File("/Users/sunyang/Documents/2024/1/111.xlsx");
        File yc = new File("/Users/sunyang/Documents/2024/1/116B71244202300000013.xlsx");
        EasyExcel.read(pk.getPath(), Quota.class, pkInsuranceDataListener).autoTrim(true).sheet("Sheet1").doRead();
        EasyExcel.read(yc.getPath(), Quota.class, ycInsuranceDataListener).autoTrim(true).sheet("Sheet1").doRead();
        List<Quota> pks = pkInsuranceDataListener.getList();
        List<Quota> ycs = ycInsuranceDataListener.getList();
        Map<String, Quota> pkMap = pks.stream().collect(Collectors.toMap(Quota::getAccountCode, Function.identity(), (k1, k2) -> k1));
        Set<String> strings = pkMap.keySet();
        List<List<String>> data = new ArrayList<>();
        ExcelWriter excelWriter = EasyExcel.write("/Users/sunyang/Documents/2023/3/sql1.xlsx").build();
        StringBuilder sql = new StringBuilder("update insu_slip_quota set controls_nowmon = %s where changed_account_code = '%s'");
        List<List<String>> head = new ArrayList<>();
        head.add(Collections.singletonList("cd"));
        ycs.stream().filter(r -> strings.contains(r.getAccountCode())).forEach(r -> {
            String pkAmt = pkMap.get(r.getAccountCode()).getAmt();
            if (!Objects.equals(r.getAmt(), pkAmt)) {
                System.out.println(r.getAccountCode() + "普康额度：".concat(pkAmt).concat("  永城额度：").concat(r.getAmt()));
                data.add(Collections.singletonList(String.format(sql.toString(), pkAmt, r.getAccountCode())));
            }
            if (Objects.equals(data.size(), 3000)) {
                String sheet = "Sheet".concat(String.valueOf(index));
                WriteSheet writeSheet = EasyExcel.writerSheet(index, sheet).head(head).build();
                excelWriter.write(data, writeSheet);
                index++;
                data.clear();
            }
        });
        String sheet = "Sheet".concat(String.valueOf(index));
        WriteSheet writeSheet = EasyExcel.writerSheet(sheet).build();
        excelWriter.write(data, writeSheet);
        index++;
        data.clear();
        excelWriter.finish();
    }

    @Test
    public void easyCardExecl() {
        InsuranceDataListener<CardId> pkInsuranceDataListener = new InsuranceDataListener();
        File cardId = new File("/Users/sunyang/Documents/2023/3/永城卡类型.xlsx");
        EasyExcel.read(cardId.getPath(), CardId.class, pkInsuranceDataListener).autoTrim(true).sheet("Sheet1").doRead();
        List<CardId> pks = pkInsuranceDataListener.getList();
        List<List<String>> data = new ArrayList<>();
        ExcelWriter excelWriter = EasyExcel.write("/Users/sunyang/Documents/2023/3/sqRollbackUpdateCard1.xlsx").build();
        StringBuilder sql = new StringBuilder("update insu_card set card_forwardType = 18 where card_id = %s;");
        List<List<String>> head = new ArrayList<>();
        head.add(Collections.singletonList("cd"));
//        pks.stream().forEach(r ->{
//            data.add(Collections.singletonList(String.format(sql.toString(), r.getCardId())));
//            if(Objects.equals(data.size(), 3000)){
//                String sheet = "Sheet".concat(String.valueOf(index));
//                WriteSheet writeSheet = EasyExcel.writerSheet(index, sheet).head(head).build();
//                excelWriter.write(data, writeSheet);
//                index++;
//                data.clear();
//            }
//        });
        pks.forEach(r -> {
            data.add(Collections.singletonList(String.format(sql.toString(), r.getCardId())));
//            if(Objects.equals(data.size(), 3000)){
//                String sheet = "Sheet".concat(String.valueOf(index));
//                WriteSheet writeSheet = EasyExcel.writerSheet(index, sheet).head(head).build();
//                excelWriter.write(data, writeSheet);
//                index++;
//                data.clear();
//            }
        });
        String sheet = "Sheet".concat(String.valueOf(index));
        WriteSheet writeSheet = EasyExcel.writerSheet(sheet).build();
        excelWriter.write(data, writeSheet);
        index++;
        data.clear();
        excelWriter.finish();
    }

    public static void main(String[] args) {
        System.out.println(new Date());
    }

    @Test
    public void easyChangeExecl() {
        InsuranceDataListener<Change> pkInsuranceDataListener = new InsuranceDataListener();
        File change = new File("/Users/sunyang/Documents/2023/6/612.xlsx");
        EasyExcel.read(change.getPath(), Change.class, pkInsuranceDataListener).autoTrim(true).sheet("Sheet1").doRead();
        List<Change> pks = pkInsuranceDataListener.getList();
        List<List<String>> data = new ArrayList<>();
        ExcelWriter excelWriter = EasyExcel.write("/Users/sunyang/Documents/2023/6/612xxx.xlsx").build();
        StringBuilder sql = new StringBuilder("INSERT INTO insu_slip_account_change (\n" +
                "\tchanged_account_code,\n" +
                "\tchange_code,\n" +
                "\tchange_bill_type,\n" +
                "\tchange_type,\n" +
                "\tchanged_amt_before,\n" +
                "\tchanged_amt,\n" +
                "\tchanged_locked_amt_before,\n" +
                "\tchanged_locked_amt,\n" +
                "\tchange_status,\n" +
                "\tdata_source,\n" +
                "\tchanged_deleted,\n" +
                "\tis_deleted,\n" +
                "\tcreate_by,\n" +
                "\tcreate_time,\n" +
                "\tupdate_by,\n" +
                "\tupdate_time,\n" +
                "\tremark \n" +
                ")\n" +
                "VALUES ");
        StringBuilder sql1 = new StringBuilder("('%s','%s',%s,%s,%s,%s,%s,%s,%s,'%s',%s,%s,'%s','%s','%s','%s','%s'),");
        List<List<String>> head = new ArrayList<>();
        head.add(Collections.singletonList("cd"));
//        pks.stream().forEach(r ->{
//            data.add(Collections.singletonList(String.format(sql.toString(), r.getCardId())));
//            if(Objects.equals(data.size(), 3000)){
//                String sheet = "Sheet".concat(String.valueOf(index));
//                WriteSheet writeSheet = EasyExcel.writerSheet(index, sheet).head(head).build();
//                excelWriter.write(data, writeSheet);
//                index++;
//                data.clear();
//            }
//        });
        pks.forEach(r -> {
            data.add(Collections.singletonList(String.format(sql1.toString()
                    , r.getChangedAccountCode()
                    , r.getChangeCode()
                    , r.getChangeBillType()
                    , r.getChangeType()
                    , r.getChangedAmtBefore(), r.getChangedAmt(), r.getChangedLockedAmtBefore(), r.getChangedLockedAmt(), r.getChangeStatus(), r.getDataSource()
                    , r.getChangedDeleted(), r.getIsDeleted()
                    , Objects.isNull(r.getCreateBy()) ? "普康同步" : r.getCreateBy()
                    , r.getCreateTime()
                    , Objects.isNull(r.getUpdateBy()) ? "普康同步" : r.getUpdateBy()
                    , r.getUpdateTime()
                    , Objects.isNull(r.getRemark()) ? "历史变更记录" : r.getRemark())));
            if (Objects.equals(data.size(), 500)) {
                String sheet = "Sheet".concat(String.valueOf(index));
                WriteSheet writeSheet = EasyExcel.writerSheet(index, sheet).head(head).build();
                excelWriter.write(data, writeSheet);
                index++;
                data.clear();
            }
        });
        String sheet = "Sheet".concat(String.valueOf(index));
        WriteSheet writeSheet = EasyExcel.writerSheet(sheet).build();
        excelWriter.write(data, writeSheet);
        index++;
        data.clear();
        excelWriter.finish();
    }

    public static void main1(String[] args) {
//        EasyExcel.write("C:\\Users\\dongbobo\\Desktop\\测试文件.xls")
//                .head(ExcelData.class)
//                .excelType(ExcelTypeEnum.XLS)
//                .sheet("测试文件")
//                .doWrite(list);
        String str = "fApicpj+m8geQFBq6HwPoYmbbgH6iX3Qpeyv0Bltnsd/45kBWGjcfXaQBd+lrs9injRHSBOtgOgQhAJQE0rnN2ZisvbkoXsit1IYGt2YvLX7/SLye6gKty5By2aSSiXHPIKuOK/sPC85StWvwVeyGLA9qhtTJM5CIVq5m4Ro+0KIXrNiQqPyJVRyXiwZlo5uwGFiEjqZTwD0UXiVrYPtMBJx4PzZ9Y3NNSMrH77e1jhy1CfQdcVjyNx3RNiR7oBTW/CUuKkJS4bHLmF0wfpGfq2G9/vQ8/gvlvjImj/y5z1B2huexFT4FEXtse8cki1JkG3QxAAod32cqIiMw+WsOjuVbSMM9k3zNKB6sPjohgxq6oBeDUqinpXVqnzA+HNbVmkIUY39fxmzMM6uHxl6p/mWJSEkhhit79i8svzuczPbiAgpz2mFkqRCLQoeZCuB2RIaydQ9rYd0p1beRZDenL30R6MLk5eC3SK+bPpep9y3pe9oiPXateA4wUbsJREgEtyjPmcw3ThNzAWKuqu21V0xa01RILtkcL28jgQu6yyZrLbkjWFXgNlPLW7Vdfjl8BziC9CjvQaboiWK55kc8HFtH1Yozis0mbvnnljIYkY1gYly+/W1RChp8+EkX3ww21X0233HFfy60sfZHe7BRCmKvPcZDOlRo+b+2EgomzPHqg7z8iXkJJ2akGe9gImvpu/32RLOmWxCqamvyOs7ZPFtnU0UBppPYUWLywlOG+3pXFY1LI/khgBlFb+jiFVCv10gDiNQlbMsRqX9VzO32OEAUFraIQqqCns1ijfWh2uYS2QzrZRAmMumYgm6og54ahQorCqEjUNUZl1vRdxkQGcDQnsGlUA1D/raIWWqHxEB2CQS7vcc5V0KV2M0eOd8G1NGqgVGUbOqpg8Bw87Xas6Q1/zEQpYmpMLZ6im8AGYYTZAx1k/ROxlmb3AXTj0HnaeNJ2VM1f6GS9Uaxk+bvHY3Rr5rmZL/XkAQ48gdly/mmCZQvTpkmq1CRopF/xaqsTclojbzgDDLD4swm6shzXlOxQoOqF86qGp/JZT5Wp6Ien7Rc5RUqJ4TR1ev6GX0lIFuEsXMYV8RIgbgcXNhY2xZGXrp0tLpi/WNyOBqlaQ=";
        AESUtils.decryptData(str);
    }

    /**
     * 比对永城和普康账户额度是否一致
     */
    @Test
    public void easyAccountExecl() {
        InsuranceDataListener<YCAccountEntity> pkInsuranceDataListener = new InsuranceDataListener();
        InsuranceDataListener<YCAccountEntity> ycInsuranceDataListener = new InsuranceDataListener();
        File pkAccount = new File("/Users/sunyang/Documents/2023/4/普康永城账户.xlsx");
        File ycAccount = new File("/Users/sunyang/Documents/2023/4/永城账户.xlsx");
        EasyExcel.read(pkAccount.getPath(), YCAccountEntity.class, pkInsuranceDataListener).autoTrim(true).sheet("Sheet1").doRead();
        EasyExcel.read(ycAccount.getPath(), YCAccountEntity.class, ycInsuranceDataListener).autoTrim(true).sheet("Sheet1").doRead();
        List<YCAccountEntity> pks = pkInsuranceDataListener.getList();
        List<YCAccountEntity> ycs = ycInsuranceDataListener.getList();
        List<List<String>> data = new ArrayList<>();
        ExcelWriter excelWriter = EasyExcel.write("/Users/sunyang/Documents/2023/4/对比结果.xlsx").build();
        Map<String, YCAccountEntity> ycAccountEntityMap = pks.stream().collect(Collectors.toMap(YCAccountEntity::getCode, Function.identity(), (k1, k2) -> k1));
        ycs.forEach(r -> {
            if (ycAccountEntityMap.containsKey(r.getCode())) {
                if (!ycAccountEntityMap.get(r.getCode()).getAmt().equals(r.getAmt())) {
                    data.add(Collections.singletonList(r.getCode()));
                }
            } else {
                data.add(Collections.singletonList(r.getCode()));
            }
        });
        String sheet = "Sheet".concat(String.valueOf(index));
        WriteSheet writeSheet = EasyExcel.writerSheet(sheet).build();
        excelWriter.write(data, writeSheet);
        index++;
        data.clear();
        excelWriter.finish();
    }

    @Test
    public void easyExeclYc() {
        InsuranceDataListener<Record> pkInsuranceDataListener = new InsuranceDataListener();
        InsuranceDataListener<Record> ycInsuranceDataListener = new InsuranceDataListener();
        File pk = new File("/Users/sunyang/Documents/2024/永诚数据整理/永诚数据.xlsx");
        File yc = new File("/Users/sunyang/Documents/2024/永诚数据整理/普康数据.xlsx");
        EasyExcel.read(pk.getPath(), Record.class, pkInsuranceDataListener).autoTrim(true).sheet("Sheet1").doRead();
        EasyExcel.read(yc.getPath(), Record.class, ycInsuranceDataListener).autoTrim(true).sheet("Sheet1").doRead();
        List<Record> pks = pkInsuranceDataListener.getList();
        List<Record> ycs = ycInsuranceDataListener.getList();
        pks = pks.stream().filter(r -> !r.getSource().equals("好管家")).collect(Collectors.toList());
        Map<String, List<Record>> collect1 = pks.stream().collect(Collectors.groupingBy(Record::getPersonNo));
        Map<String, List<Record>> collect2 = ycs.stream().collect(Collectors.groupingBy(Record::getPersonNo));

        collect1.forEach((key, value) -> {
            if (collect2.containsKey(key)) {
                if (value.size() != collect2.get(key).size()) {
                    System.out.println("保单号：" + value.get(0).getPolicyNo() + "，身份证： " + key);
                }
            } else {
                System.out.println(key);
            }
        });
//        List<List<String>> data = new ArrayList<>();
//        ExcelWriter excelWriter = EasyExcel.write("/Users/sunyang/Documents/2024/1/额度筛选.xlsx").build();

//        String sheet = "Sheet".concat(String.valueOf(index));
//        WriteSheet writeSheet = EasyExcel.writerSheet(sheet).build();
//        excelWriter.write(data, writeSheet);
//        index++;
//        data.clear();
//        excelWriter.finish();
    }

    @Test
    public void easyExeclYc1() {
        InsuranceDataListener<Record> pkInsuranceDataListener = new InsuranceDataListener();
        InsuranceDataListener<Record> ycInsuranceDataListener = new InsuranceDataListener();
        File pk = new File("/Users/sunyang/Documents/2024/永诚数据整理/永诚备注乱数据.xlsx");
        File yc = new File("/Users/sunyang/Documents/2024/永诚数据整理/普康备注乱数据.xlsx");
        EasyExcel.read(pk.getPath(), Record.class, pkInsuranceDataListener).autoTrim(true).sheet("Sheet1").doRead();
        EasyExcel.read(yc.getPath(), Record.class, ycInsuranceDataListener).autoTrim(true).sheet("Sheet1").doRead();
        List<Record> pks = pkInsuranceDataListener.getList();
        List<Record> ycs = ycInsuranceDataListener.getList();
        pks = pks.stream().filter(r -> !StringUtils.isEmpty(r.getPersonNo())).collect(Collectors.toList());
        ycs = ycs.stream().filter(r -> !StringUtils.isEmpty(r.getPersonNo())).collect(Collectors.toList());
        pks = pks.stream()
                .peek(record -> {
                    String personNo = record.getPersonNo();
                    if (personNo != null && personNo.length() > 0) {
                        char lastChar = personNo.charAt(personNo.length() - 1);
                        char upperCaseLastChar = Character.toUpperCase(lastChar);
                        String modifiedPersonNo = personNo.substring(0, personNo.length() - 1) + upperCaseLastChar;
                        record.setPersonNo(modifiedPersonNo);
                    }
                })
                .collect(Collectors.toList());
        ycs = ycs.stream()
                .peek(record -> {
                    String personNo = record.getPersonNo();
                    if (personNo != null && personNo.length() > 0) {
                        char lastChar = personNo.charAt(personNo.length() - 1);
                        char upperCaseLastChar = Character.toUpperCase(lastChar);
                        String modifiedPersonNo = personNo.substring(0, personNo.length() - 1) + upperCaseLastChar;
                        record.setPersonNo(modifiedPersonNo);
                    }
                })
                .collect(Collectors.toList());
        Map<String, List<Record>> collect1 = pks.stream().collect(Collectors.groupingBy(Record::getPersonNo));
        Map<String, List<Record>> collect2 = ycs.stream().collect(Collectors.groupingBy(Record::getPersonNo));

        List<Record> recordss = new ArrayList<>();
        collect1.forEach((key, value) -> {
            if (collect2.containsKey(key)) {
                List<Record> records = collect2.get(key);
                for (Record record1 : value) {
                    for (Record record : records) {
                        if (new BigDecimal(record1.getChangedAmtBefore()).compareTo(new BigDecimal(record.getChangedAmtBefore())) == 0
                        && new BigDecimal(record1.getChangedAmt()).compareTo(new BigDecimal(record.getChangedAmt()))== 0
                        && record1.getRemark().equals(record.getRemark())
                                && record.getPolicyNo().equals(record1.getPolicyNo())) {

                            record1.setClaimReferenceCode(record.getClaimReferenceCode());
                            recordss.add(record1);
                            break;
                        }
                    }
                }
            } else {
                System.out.println(key);
            }
        });
//        List<Record> recordsss = recordss.subList(0,5);
        List<List<String>> data = new ArrayList<>();
//        ExcelWriter excelWriter = EasyExcel.write("/Users/sunyang/Documents/2024/1/118.xlsx").build();

//        String sheet = "Sheet".concat(String.valueOf(index));
//        WriteSheet writeSheet = EasyExcel.writerSheet(sheet).build();
        EasyExcel.write("/Users/sunyang/Documents/2024/1/119.xlsx", Record.class).sheet("Sheet1").doWrite(recordss);
//        index++;
//        data.clear();
//        excelWriter.finish();
    }

}
