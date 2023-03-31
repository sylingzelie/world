package com.sy.world.controller;


//import com.alibaba.fastjson.JSONObject;
import com.sy.world.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("test")
public class TestController {


    @RequestMapping("t")
    public String t(@RequestParam("massge") String massge){
        System.out.println(massge);
        return "收到消息了：" + massge;
    }

//    public static void main(String[] args) {
//        //待加密内容
////        String str = "测试内容";
////        //密码，长度要是8的倍数
////        String password = "12345678";
////
////        byte[] result = TestController.encrypt(str.getBytes(),password);
////        BASE64Encoder enc=new BASE64Encoder();
////        String mes=enc.encodeBuffer(result);
////        System.out.println("加密后："+mes);
//        Map<String,Object> source=new HashMap<>();
//        source.put("username","张三");
//        source.put("age",1);
//        //map转为对象
//        User user =  JSONObject.parseObject(JSONObject.toJSONString(source),User.class);
//        System.out.println();
//    }

    public static Boolean test(){
        return null;
    }
    /**
     * 加密
     * @param datasource byte[]
     * @param password String
     * @return byte[]
     */
    public static  byte[] encrypt(byte[] datasource, String password) {
        try{
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(password.getBytes());
            //创建一个密匙工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            //Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");
            //用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
            //现在，获取数据并加密
            //正式执行加密操作
            return cipher.doFinal(datasource);
        }catch(Throwable e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("t1")
    public String t1(@RequestParam("massge") String massge){
        System.out.println(massge);
        return "收到消息了：" + massge;
    }


}
