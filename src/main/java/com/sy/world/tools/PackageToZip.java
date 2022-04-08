package com.sy.world.tools;

import com.aliyun.oss.ServiceException;
import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Created by shenguohao on 2018/3/12.
 */
public class PackageToZip {

    private static Logger logger = LoggerFactory.getLogger(PackageToZip.class);

    /**
     * 功能:压缩多个文件成一个zip文件
     * @param srcfile：源文件列表
     * @param zipfile：压缩后的文件
     */
    public static void zipFiles(String[] srcfile,String zipfile){
        byte[] buf=new byte[1024];
        try {
            File file;
            FileOutputStream fileOutputStream = new FileOutputStream(new File(zipfile));
            //ZipOutputStream类：完成文件或文件夹的压缩
            ZipOutputStream out=new ZipOutputStream(fileOutputStream);
            for(int i=0;i<srcfile.length;i++){
                if(srcfile[i]==null || "".equals(srcfile[i])){
                    continue;
                }
                file = new File(srcfile[i]);
                FileInputStream in=new FileInputStream(srcfile[i]);
                out.putNextEntry(new ZipEntry(file.getName()));
                int len;
                while((len=in.read(buf))>0){
                    out.write(buf,0,len);
                }
                out.closeEntry();
                in.close();
            }
            out.close();
            fileOutputStream.close();
//            out.close();
            System.out.println("压缩完成.");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /**
     * 功能:解压缩
     * @param zipfile：需要解压缩的文件
     * @param descDir：解压后的目标目录
     */
//    public static void unZipFiles(File zipfile,String descDir){
//        try {
//
//            ZipFile zf=new ZipFile(zipfile);
//            for(Enumeration entries = zf.entries(); entries.hasMoreElements();){
//                ZipEntry entry=(ZipEntry) entries.nextElement();
//                String zipEntryName=entry.getName();
//                InputStream in=zf.getInputStream(entry);
//                OutputStream out=new FileOutputStream(descDir+zipEntryName);
//                byte[] buf1=new byte[1024];
//                int len;
//                while((len=in.read(buf1))>0){
//                    out.write(buf1,0,len);
//                }
//                in.close();
//                out.close();
//                System.out.println("解压缩完成.");
//            }
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }

    /**
     * 解压到指定目录
     * @param zipPath
     * @param descDir
     */
    public static void unZipFiles(String zipPath, String descDir) throws IOException {
        unZipFiles(new File(zipPath), descDir);
    }

//    /**
//     * 解压文件并对数据进行处理
//     *
//     *@param
//     *@return
//     */
//    public static Map<String, Object> unZipFileAndConvertXml(InputStream inputStream, Class clazz) {
//
//        Map<String, Object> map = new HashMap<>(8);
//
//        ZipInputStream zipIs = null;
//        ZipEntry zipEntry = null;
//        ByteArrayOutputStream byteArrayOutputStream = null;
//        ByteArrayInputStream byteArrayInputStream = null;
//        try {
//            zipIs = new ZipInputStream(inputStream, Charset.forName("GBK"));
//
//            while((zipEntry = zipIs.getNextEntry()) != null){
//                String filename = zipEntry.getName();
//                byteArrayOutputStream = new ByteArrayOutputStream();
//                byte[] byteTemp = new byte[1024];
//                int num = -1;
//                while((num = zipIs.read(byteTemp,0,byteTemp.length))>-1){
//                    byteArrayOutputStream.write(byteTemp,0,num);
//                }
//                byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
//
//                // XML文件转码
//                SAXReader reader=new SAXReader();
//                Document doc=reader.read(byteArrayInputStream);
//                OutputFormat format=new OutputFormat();
//                format.setEncoding("utf-8");
//                org.dom4j.io.XMLWriter writer = new XMLWriter(byteArrayOutputStream, format);
//                writer.write(doc);
//                writer.close();
//                Object o = XMLUtil.convertXmlInputStream2Object(clazz, byteArrayInputStream);
//
//                map.put(filename, o);
//            }
//
//        } catch (Exception e) {
//            logger.error("XML转json异常, 错误原因 --> {}", e.getMessage(), e);
//            Result.Exception("XML转json异常");
//        } finally {
//            if (byteArrayInputStream != null) {
//                try {
//                    byteArrayInputStream.close();
//                } catch (Exception e) {}
//            }
//            if (byteArrayOutputStream != null) {
//                try {
//                    byteArrayOutputStream.close();
//                } catch (Exception e) {}
//            }
//            if (zipIs != null) {
//                try {
//                    zipIs.close();
//                } catch (Exception e) {}
//            }
//        }
//
//        return map;
//    }



    /**
    * 解压文件并对数据进行处理
    *
    *@param
    *@return
    */
    public static Map<String, Object> unZipFileAndConvertXml(File zipFile, Class clazz) {

        Map<String, Object> map = new HashMap<>(8);

        // 解决中文文件夹乱码
        ZipFile zip = null;

        try {
            zip = new ZipFile(zipFile, Charset.forName("GBK"));

            InputStream in = null;

            ByteArrayOutputStream outputStream = null;
            try {
                for (Enumeration<? extends ZipEntry> entries = zip.entries(); entries.hasMoreElements(); ) {

                    ZipEntry entry = (ZipEntry) entries.nextElement();
                    String zipEntryName = entry.getName();
                    in = zip.getInputStream(entry);
                    outputStream = new ByteArrayOutputStream();
                    // XML文件转码
                    SAXReader reader=new SAXReader();
                    Document doc=reader.read(in);
                    OutputFormat format=new OutputFormat();
                    format.setEncoding("utf-8");
                    XMLWriter writer = new XMLWriter(outputStream, format);
                    writer.write(doc);
                    writer.close();
                    Object o = XMLUtil.convertXmlInputStream2Object(clazz, new ByteArrayInputStream(outputStream.toByteArray()));
                    map.put(zipEntryName, o);
                }
            } catch (Exception e) {
                logger.error("文件解压失败", e.getMessage(), e);
                throw new ServiceException("压缩文件解压失败");
            } finally {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e) {
                    }
                }
                if (in != null) {
                    try {
                        in.close();
                    } catch (Exception e) {
                    }
                }
            }
        } catch (Exception e) {
            logger.error("服务器解压文件失败", e.getMessage(), e);
            throw new ServiceException("服务器解压文件失败");
        } finally {
            if (zip != null) {
                try {
                    zip.close();
                } catch (Exception e) {
                }
            }
        }
        return map;
    }

    /**
     * 解压文件成InputStream
     *
     *@param
     *@return
     */
    public static Map<String, InputStream> unZipFileToInputStream(File zipFile) {

        Map<String, InputStream> map = new HashMap<>(8);

        // 解决中文文件夹乱码
        ZipFile zip = null;

        try {
            zip = new ZipFile(zipFile, Charset.forName("GBK"));
            //new ZipFile(new, Charset.forName("GBK"))
            try {
                for (Enumeration<? extends ZipEntry> entries = zip.entries(); entries.hasMoreElements(); ) {

                    ZipEntry entry = (ZipEntry) entries.nextElement();
                    String zipEntryName = entry.getName();
                    InputStream in = null;
                    try {
                        in = zip.getInputStream(entry);
                        map.put(zipEntryName, in);
                    } finally {
                        if (in != null) {
                            try {
                                in.close();
                            } catch (Exception e) {
                            }
                        }
                    }
                }
            } catch (Exception e) {
                logger.error("文件解压失败", e.getMessage(), e);
                throw new ServiceException("压缩文件解压失败");
            }
        } catch (Exception e) {
            logger.error("服务器解压文件失败", e.getMessage(), e);
            throw new ServiceException("服务器解压文件失败");
        } finally {
            if (zip != null) {
                try {
                    zip.close();
                } catch (Exception e) {
                }
            }
        }
        return map;
    }


    /**
     * InputStream读zip文件
     *
     *@param
     *@return
     */

    public static Map<String, InputStream> readZipByInputStream(InputStream inputStream) throws IOException {
        Map<String, InputStream> map = new HashMap<String, InputStream >();
        ZipInputStream zip;
        zip = new ZipInputStream(inputStream,Charset.forName("GBK"));
        ZipEntry zipEntry = null;
        while((zipEntry = zip.getNextEntry()) != null){
            String filename = zipEntry.getName();

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] byteTemp = new byte[1024];
            int num = -1;
            while((num = zip.read(byteTemp,0,byteTemp.length))>-1){
                byteArrayOutputStream.write(byteTemp,0,num);
            }
            byte[] bytes = byteArrayOutputStream.toByteArray();
             InputStream in = null;
            try {
                in = new ByteArrayInputStream(bytes);
                map.put(filename, in);
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (Exception e) {
                    }
                }
            }
        }
        return map;
    }



    /**
     * 解压文件到指定目录
     * 解压后的文件名，和之前一致
     * @param zipFile   待解压的zip文件
     * @param descDir   指定目录
     */
    @SuppressWarnings("rawtypes")
    public static void unZipFiles(File zipFile, String descDir) throws IOException {

        ZipFile zip = new ZipFile(zipFile, Charset.forName("GBK"));//解决中文文件夹乱码
        String name;
        if(descDir.contains("\\")){
            name = zip.getName().substring(zip.getName().lastIndexOf('\\')+1, zip.getName().lastIndexOf('.'));
        }else{
            name = zip.getName().substring(zip.getName().lastIndexOf('/')+1, zip.getName().lastIndexOf('.'));
        }
        logger.info("descDir：{}",descDir);
        logger.info("name：{}",name);
//        name = zip.getName().substring(zip.getName().lastIndexOf('\\')+1, zip.getName().lastIndexOf('.'));

        File pathFile = new File(descDir+name);
        if (!pathFile.exists()) {
            pathFile.mkdirs();
        }

        for (Enumeration<? extends ZipEntry> entries = zip.entries(); entries.hasMoreElements();) {
            ZipEntry entry = (ZipEntry) entries.nextElement();
            String zipEntryName = entry.getName();
            InputStream in = zip.getInputStream(entry);
            String outPath = "";
            if(descDir.contains("\\")){
                outPath = (descDir + name +"\\"+ zipEntryName).replaceAll("\\*", "\\");
            }else{
                outPath = (descDir + name +"/"+ zipEntryName).replaceAll("\\*", "/");
            }

            // 判断路径是否存在,不存在则创建文件路径
            File file;
            if(descDir.contains("\\")){
                file = new File(outPath.substring(0, outPath.lastIndexOf('\\')));
            }else{
                file = new File(outPath.substring(0, outPath.lastIndexOf('/')));
            }
//            file = new File(outPath.substring(0, outPath.lastIndexOf('/')));
            if (!file.exists()) {
                logger.info("创建文件：{}",file.getPath());
                file.mkdirs();
            }
            // 判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
            if (new File(outPath).isDirectory()) {
                continue;
            }
            // 输出文件路径信息
            logger.info("输出文件路径信息：{}",outPath);

            FileOutputStream out = new FileOutputStream(outPath);
            byte[] buf1 = new byte[1024];
            int len;
            while ((len = in.read(buf1)) > 0) {
                out.write(buf1, 0, len);
            }
            in.close();
            out.close();
        }
        System.out.println("******************解压完毕********************");
        return;
    }

    /**
     * 功能:压缩多个文件流成一个zip文件流
     * @param srcfile：源文件流列表
     * @param zipfile：压缩后的zip文件流
     */
    public static InputStream zipFilesToInputStream(InputStream srcfile,String zipfile){
        byte[] buf=new byte[1024];
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ZipOutputStream out=new ZipOutputStream(byteArrayOutputStream);
            InputStream in=srcfile;
            out.putNextEntry(new ZipEntry(zipfile));
            int len;
            while((len=in.read(buf))>0){
                out.write(buf,0,len);
            }
            out.closeEntry();
            in.close();
            out.close();
            return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 批量文件流压缩
     * @author momo
     * @since 2018-8-9
     * @param baisBytes  List<Map<被压缩压缩文件名, 被压缩的文件流>>
     * @return 压缩后字节数组输出流转为的字符串
     * @throws IOException
     */
    public static InputStream batchZipByteArrayOutputStream(List<Map<String, byte[]>> baisBytes) throws IOException {

        //1.创建字节数组输出流，用于返回压缩后的输出流字节数组
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        //2.创建压缩输出流
        ZipOutputStream zipOut = new ZipOutputStream(baos);

        //zipOut.setEncoding("GBK");//设置编码格式，否则中文文件名乱码

        //3.遍历要批量压缩的集合文件流
        ByteArrayInputStream bais =null;
        Map<String, byte[]> tempMap =null;
        String fileName=null;
        int temp = 0 ;
        for (int i = 0; i < baisBytes.size(); i++) {

            tempMap=baisBytes.get(i);

            fileName=tempMap.keySet().iterator().next();
            logger.info("正在打包",fileName);
            System.out.println("--------------------------------正在打包"+fileName);

            //3.1将需要压缩的字节输出流，转为字节数组输入流，
            bais = new ByteArrayInputStream(tempMap.get(fileName));

            //zipOut.setMethod(ZipOutputStream.DEFLATED);//进行压缩存储

            //zipOut.setLevel(Deflater.BEST_COMPRESSION);//压缩级别值为0-9共10个级别(值越大，表示压缩越利害)

            //3.2设置ZipEntry对象，并对需要压缩的文件命名
            zipOut.putNextEntry(new ZipEntry(fileName));


            //3.3读取要压缩的字节输出流，进行压缩
            temp = 0 ;
            while((temp=bais.read())!=-1){
                zipOut.write(temp) ;    // 压缩输出
            }

            // 3.4关闭流
            bais.close();
        }


        zipOut.close();

//        //字节数组输出流转为字符串并设置编码
//        String result =new String(baos.toByteArray(), "ISO-8859-1");
        InputStream result = new ByteArrayInputStream(baos.toByteArray());
        baos.close();// 关闭流
        logger.info("******************打包完毕********************");
        return result;
    }


}
