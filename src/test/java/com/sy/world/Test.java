package com.sy.world;



import com.sy.world.entity.CertifyInt;
import com.sy.world.entity.CheckReplyInt;
import com.sy.world.entity.YBQueryTrace;
import org.apache.axis.client.Call;
import org.apache.axis.encoding.XMLType;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.platform.commons.util.StringUtils;
import org.mockito.internal.util.StringUtil;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import java.io.*;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.*;

public class Test {
    public static void main1(String[] args) throws Exception {
        List<String> name = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        //创建workbook
//        Workbook workbook = Workbook.getWorkbook();
        InputStream inp = new FileInputStream(new File("D:\\3\\单独结算5月.xlsx"));
        Workbook wb = WorkbookFactory.create(inp);
        //获取第一个工作表sheet
        Sheet sheet = wb.getSheetAt(0);
        //获取数据
        int index = 0;
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            String str = sheet.getRow(i).getCell(6).getStringCellValue();
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
//        index = name.stream().mapToInt(r -> map.get(r).size()).sum();
        for (int j = 0; j < name.size(); j++) {
            File file = new File("D:\\4\\" + name.get(j) + ".xlsx");
            try {
                file.createNewFile();
                //创建工作薄
                XSSFWorkbook work = new XSSFWorkbook();
                //创建sheet
                Sheet sheet1 = work.createSheet();
                List<Integer> integers = map.get(name.get(j));
                for (int i = 0; i < integers.size(); i++) {
                    index++;
                    Row row = sheet.getRow(integers.get(i));
                    Row row1 = sheet1.createRow(i);
                    for(int k = 0; k < 9; k++){
                        row1.createCell(k).setCellValue(row.getCell(k).toString());
                    }
                }
                FileOutputStream fileOut=new FileOutputStream("D:/4/" + name.get(j) + ".xlsx");
                work.write(fileOut);
                fileOut.close();
                work.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(index);
        wb.close();
    }

    public static void main(String[] args) {
        String xinChengCertifyCodePK = "97798888381861904102";
        String jxmedUrl = "https://test2.citicpruagents.com.cn/xc_jxyd/services/JXMedInterface?wsdl";
        String username = "jxtest";
        String password = "jxtest";
        Call jxmedCall = null;
        try {
            jxmedCall = new Call(jxmedUrl);
        } catch (MalformedURLException mue) {
        }

        if (jxmedCall == null) {
        }

        jxmedCall.setUsername(username.trim());
        jxmedCall.setPassword(password.trim());

//                    jxmedCall.removeAllParameters();
        // 查询余额信息
        jxmedCall.setOperationName("YBCheckRemaining");

        QName qnameCertifyInt = new QName("CertifyInt:CertifyInt", "CertifyInt");
        // 给自定义的CertifyIntDemo类配置Serializer和Deserializer，用于序列化和反序列化
        jxmedCall.registerTypeMapping(CertifyInt.class, qnameCertifyInt,
                new BeanSerializerFactory(CertifyInt.class, qnameCertifyInt),
                new BeanDeserializerFactory(CertifyInt.class, qnameCertifyInt));

        jxmedCall.addParameter("in0", XMLType.XSD_STRING, ParameterMode.IN);
        jxmedCall.addParameter("in1", qnameCertifyInt, CertifyInt.class, ParameterMode.IN);

        QName qnameCheckReplyInt = new QName("CheckReplyInt:CheckReplyInt", "CheckReplyInt");
        jxmedCall.registerTypeMapping(CheckReplyInt.class, qnameCheckReplyInt,
                new BeanSerializerFactory(CheckReplyInt.class, qnameCheckReplyInt),
                new BeanDeserializerFactory(CheckReplyInt.class, qnameCheckReplyInt));
        jxmedCall.setReturnClass(CheckReplyInt[].class);
        jxmedCall.setTimeout(30 * 1000);


        long cribegin = System.currentTimeMillis();
        CheckReplyInt[] objects = null;
        CertifyInt certifyInt = new CertifyInt("000000", "2542136900000020");
        try {
            objects = (CheckReplyInt[]) jxmedCall.invoke(new Object[]{
                    xinChengCertifyCodePK, certifyInt});
        } catch (RemoteException re) {
            System.out.println(re.getMessage());
        }
        long criend = System.currentTimeMillis();

        Map<String, Object> logInfo = new HashMap<>(8);
        logInfo.put("costTime", criend - cribegin);
        logInfo.put("certifyInt", certifyInt);
        logInfo.put("xinChengCertifyCodePK", xinChengCertifyCodePK);
        logInfo.put("checkReplyInt", objects);
    }

}
