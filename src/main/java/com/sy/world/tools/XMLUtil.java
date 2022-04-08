package com.sy.world.tools;

import lombok.extern.slf4j.Slf4j;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * @Classname XMLUtil
 * @Date 2019/10/8 10:26
 * @Created by xy47
 */
@Slf4j
public class XMLUtil {
    /**
     * 将对象直接转换成String类型的 XML输出
     *
     * @param obj
     * @return
     */
    public static String convertToXml(Object obj) {
        // 创建输出流
        StringWriter sw = new StringWriter();
        try {
            // 利用jdk中自带的转换类实现
            JAXBContext context = JAXBContext.newInstance(obj.getClass());

            Marshaller marshaller = context.createMarshaller();
            // 格式化xml输出的格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);
            // 将对象转换成输出流形式的xml
            marshaller.marshal(obj, sw);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return sw.toString();
    }

    /**
     * 将对象转换成xml文件流
     *
     * @param obj
     * @param
     * @return
     */
    public static ByteArrayInputStream convertToXmlOutPutStream(Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            // 利用jdk中自带的转换类实现
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            // 格式化xml输出的格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);

            // 将对象转换成输出流形式的xml
            byteArrayOutputStream = new  ByteArrayOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(byteArrayOutputStream, "UTF-8");
            marshaller.marshal(obj, osw);
        } catch (Exception e) {
            log.info("将对象转换成xml文件流异常， 错误原因 --> {}", obj, e);
            return null;
        }
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    /**
     * 将对象根据路径转换成xml文件
     *
     * @param obj
     * @param path
     * @return
     */
    public static void convertToXml(Object obj, String path) {
        try {
            // 利用jdk中自带的转换类实现
            JAXBContext context = JAXBContext.newInstance(obj.getClass());

            Marshaller marshaller = context.createMarshaller();
            // 格式化xml输出的格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);
            // 将对象转换成输出流形式的xml
            // 创建输出流
            FileWriter fw = null;
            try {
                fw = new FileWriter(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            marshaller.marshal(obj, fw);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将String类型的xml转换成对象
     */
    public static Object convertXmlStrToObject(Class clazz, String xmlStr) {
        Object xmlObject = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            // 进行将Xml转成对象的核心接口
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader sr = new StringReader(xmlStr);
            xmlObject = unmarshaller.unmarshal(sr);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xmlObject;
    }

    /**
     * 将file类型的xml转换成对象
     */
    public static Object convertXmlFileToObject(Class clazz, String xmlPath) {
        Object xmlObject = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            FileReader fr = null;
            try {
                fr = new FileReader(xmlPath);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            xmlObject = unmarshaller.unmarshal(fr);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xmlObject;
    }

    /**
     * 对xml文件流进行读取
     *
     * @param
     * @return
     */
    public static Object convertXmlInputStream2Object(Class clazz, InputStream is) {
        Object xmlObject = null;
        InputStreamReader reader = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            reader = new InputStreamReader(is, "UTF-8");
            xmlObject = unmarshaller.unmarshal(reader);
        } catch (Exception e) {
            log.error("xml文件转Object发生错误, 错误原因 --> {}", e.getMessage(), e);
        }
        return xmlObject;
    }


    /**
     * 将file类型的xml转换成对象
     */
    public static Object convertXmlFileToObject(Class clazz, File xmlFile) {
        Object xmlObject = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            FileReader fr = null;
            try {
                fr = new FileReader(xmlFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            xmlObject = unmarshaller.unmarshal(fr);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xmlObject;
    }

    public static void main(String[] args) {
//        String resultStr = "C:\\Users\\Administrator\\Desktop\\20190903_000002109393088_BasicInfoChange.xml";
//        TranData tranData = (TranData) XMLUtil.convertXmlFileToObject(TranData.class, resultStr);
//        System.out.println(JsonUtils.toJson(tranData));

//        ReqMedTrade medTrade = new ReqMedTrade();
//        medTrade.setMedshoptype(1);
//        String reqString = XMLUtil.convertToXml(medTrade);
//        System.out.println(reqString);
//
//        String localFile = "C:\\Users\\Administrator\\Desktop\\BasicInfoChange.xml";
//        BasicInfoChange basicInfoChange = (BasicInfoChange) XMLUtil.convertXmlFileToObject(BasicInfoChange.class, localFile);
//        System.out.println(basicInfoChange);
        String path = "C:\\common1\\avatar\\20190906_000002878721088_NewPolicyOrInsured(1).xml";
//        TranData data = (TranData) convertXmlFileToObject(TranData.class, path);
//        System.out.println(JsonUtils.toJson(data));

        /*try {

            String ftpHost = "118.190.19.173";
            int ftpPort = 10222;
            String ftpUserName = "yibao_test";
            String ftpPassword = "password";
            String supplierCodePK = "009";
            String yyyyMMdd = "20191122";
            String saveTradeNoPath = "C:\\common1\\";

            String filepath = "/NewPolicyOrInsured/".concat(supplierCodePK).concat("/").concat("20191105").concat("/");
            SftpHelper sftp = new SftpHelper(ftpHost, ftpPort, ftpUserName, ftpPassword, filepath);
            List<String> fileNames = sftp.list();
            // 遍历，获取需要的文件名
            System.out.println(fileNames);
            System.out.println("======================================");
            for (int i = 0; i < fileNames.size(); i++) {
                String name = fileNames.get(i);
                if (name.endsWith("_NewPolicyOrInsured.xml")&&name.startsWith("20191105_")){
                    System.out.println(name);
                }
            }
            System.out.println("======================================");

            sftp.closeChannel();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
