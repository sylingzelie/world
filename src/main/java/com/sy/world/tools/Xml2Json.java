package com.sy.world.tools;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.ServiceException;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Created by chengsheng on 2015/8/19.
 */
public class Xml2Json {
    public static void main(String[] args) throws Exception {
//        String xmlStr= readFile("D:\\2\\clmappresp_BCLB202111080001_20211201_1638338835_1.xml");
//        Document doc= DocumentHelper.parseText(xmlStr);
//        JSONObject json=new JSONObject();
//        dom4j2Json(doc.getRootElement(),json);
//        System.out.println("xml2Json:"+json.toJSONString());
        Map<String, Object> map = xml2Json(new File("D:\\usr\\local\\20220217\\clmappresp_BCLB202111080001_20211201_1638338835_1.zip"));
        if (map != null) {

        }
    }

    public static String readFile(String path) throws Exception {
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        FileChannel fc = fis.getChannel();
        ByteBuffer bb = ByteBuffer.allocate(new Long(file.length()).intValue());
        //fc向buffer中读入数据
        fc.read(bb);
        bb.flip();
        String str = new String(bb.array(), "UTF8");
        fc.close();
        fis.close();
        return str;

    }

    /**
     * xml转json
     *
     * @param file
     * @return
     * @throws DocumentException
     */
    public static Map<String, Object> xml2Json(File file){
        ZipFile zip = null;
        try {
            zip = new ZipFile(file, Charset.forName("GBK"));
            for (Enumeration<? extends ZipEntry> entries = zip.entries(); entries.hasMoreElements(); ) {
                ZipEntry entry = entries.nextElement();
                InputStream inputStream = zip.getInputStream(entry);
//                String xmlStr = readFile(zipEntryName);
                // XML文件转码
                SAXReader reader=new SAXReader();
                Document doc=reader.read(inputStream);
//                Document doc = DocumentHelper.parseText(inputStream);
                JSONObject json = new JSONObject();
                dom4j2Json(doc.getRootElement(), json);
                inputStream.close();
                zip.close();
                return json;
            }
        } catch (Exception e) {
            throw new ServiceException("操作文件失败:"+e.getMessage());
        }finally {
        }
        return null;
    }

    /**
     * xml转json
     *
     * @param element
     * @param json
     */
    public static void dom4j2Json(Element element, JSONObject json) {
        //如果是属性
        for (Object o : element.attributes()) {
            Attribute attr = (Attribute) o;
            if (!isEmpty(attr.getValue())) {
                json.put("@" + attr.getName(), attr.getValue());
            }
        }
        List<Element> chdEl = element.elements();
        if (chdEl.isEmpty() && !isEmpty(element.getText())) {//如果没有子元素,只有一个值
            json.put(element.getName(), element.getText());
        }

        for (Element e : chdEl) {//有子元素
            if (!e.elements().isEmpty()) {//子元素也有子元素
                JSONObject chdjson = new JSONObject();
                dom4j2Json(e, chdjson);
                Object o = json.get(e.getName());
                if (o != null) {
                    JSONArray jsona = null;
                    if (o instanceof JSONObject) {//如果此元素已存在,则转为jsonArray
                        JSONObject jsono = (JSONObject) o;
                        json.remove(e.getName());
                        jsona = new JSONArray();
                        jsona.add(jsono);
                        jsona.add(chdjson);
                    }
                    if (o instanceof JSONArray) {
                        jsona = (JSONArray) o;
                        jsona.add(chdjson);
                    }
                    json.put(e.getName(), jsona);
                } else {
                    if (!chdjson.isEmpty()) {
                        json.put(e.getName(), chdjson);
                    }
                }


            } else {//子元素没有子元素
                for (Object o : element.attributes()) {
                    Attribute attr = (Attribute) o;
                    if (!isEmpty(attr.getValue())) {
                        json.put("@" + attr.getName(), attr.getValue());
                    }
                }
                if (!e.getText().isEmpty()) {
                    json.put(e.getName(), e.getText());
                }
            }
        }
    }

    public static boolean isEmpty(String str) {

        if (str == null || str.trim().isEmpty() || "null".equals(str)) {
            return true;
        }
        return false;
    }
}