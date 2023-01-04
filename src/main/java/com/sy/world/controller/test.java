package com.sy.world.controller;

import com.aliyun.oss.ServiceException;
import com.sy.world.entity.User;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import org.apache.poi.util.ArrayUtil;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class test extends Observable {

    private static class T {

        public long x = 0L;
    }

    public static T[] arr = new T[2];

    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) throws ParseException {

//        List<String> list = Arrays.asList("abc", " ", "bc", "efg", "abcd"," ", "jkl");
//        List<String> collect = list.stream().map(i -> i.substring(1)).collect(Collectors.toList());


//        List<Student> students = new ArrayList<>();
//        students.add(Student.builder().age(18).address("2").name("sy").build());
//        students.add(Student.builder().age(18).address("3").name("zs").build());
//        students.add(Student.builder().age(20).address("2").name("ls").build());
//        students.add(Student.builder().age(20).address("3").name("ww").build());
//        students.add(Student.builder().age(22).address("4").name("al").build());
//        students.add(Student.builder().age(22).address("").name("sq").build());
//        students.add(Student.builder().age(22).address("").name("ww").build());
//
//        List<Student> list = new ArrayList<>(
//                Arrays.asList(
//                        Student.builder().age(18).address("2").name("sy").build(),
//                        Student.builder().age(19).address("3").name("sy").build(),
//                        Student.builder().age(20).address("1").name("sy").build()
//                )
//        );
//        Map<Integer, List<Student>> map = students.stream().collect(Collectors.groupingBy(Student::getAge));
//
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
//
//        BigDecimal bigDecimal = new BigDecimal(0.01444);
//        bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_CEILING);
//        System.out.println(bigDecimal);


//        students.stream().filter(student -> "2".equals(student.getAddress())).collect(Collectors.toList()).forEach(r ->{
//            System.out.println(r.getName());
//        });

//        int sum = students.stream().filter(student -> "2".equals(student.getAddress())).mapToInt(Student::getAge).sum();

//        Map<String, List<Student>> collect1 = list.stream()
//                .filter(student -> !student.getAddress().isEmpty())
//                .collect(Collectors.groupingBy(Student::getAddress));
//
//        Collector<Student, ?, Map<String, String>> studentMapCollector = Collectors.toMap(Student::getName, v -> v.getAddress(), (k, l) -> k);
//
//        Map<String, String> collect = list.stream().collect(studentMapCollector);
//
//        List<Student> collect2 = Optional
//                .ofNullable(students)
//                .orElse(Collections.emptyList())
//                .stream()
//                .map(s -> {
//                    if(s.getName().equals("ww")){
//                        s.setAddress("1");
//                    }
//                    return s;
//                })
//                .distinct()
//                .collect(Collectors.toList());
//
//        System.out.println();

//        CountDownLatch latch = new CountDownLatch(2);
//        long COUNT = 1000000000L;
//        Thread t1 = new Thread(() -> {
//            for (long i = 0; i < COUNT; i++) {
//                arr[0].x = i;
//            }
//        });
        String str = "{\"DATAS\":[{\"XH\":\"03202211181\",\"ND\":\"2022\",\"JGBH\":\"03\",\"LSH\":\"Z0368765912282\",\"XM\":\"吕峰\",\"RYZT\":\"1\",\"SFZH\":\"370611196507290012\",\"YDGYJE\":\"69.00\",\"YYMZJE\":\"0.00\",\"YYMC\":\"山东立健药店连锁有限公司\",\"YDGYBXJE\":\"62.10\",\"YYMZBXJE\":\"0.00\",\"BXJE\":\"62.10\",\"FPSJ\":\"2022-07-20\",\"JSSJ\":\"2022-07-20\",\"PJZS\":\"1\",\"FILEPATH\":\"http://172.18.37.202:17001/wbglWeb/rest/file/gwDownload/Z0368765912282/\",\"FILENAMES\":\"3706111965072900121110001.jpg\",\"ZFSJ\":\"2022-07-20 19:30:18\",\"ZFZT\":\"1\",\"JFJE\":\"0.00\",\"SDSJ\":\"2022-07-20\"}]}{\"DATAS\":[{\"XH\":\"03202211181\",\"ND\":\"2022\",\"JGBH\":\"03\",\"LSH\":\"Z0377765912282\",\"XM\":\"吕峰\",\"RYZT\":\"1\",\"SFZH\":\"370611196507290012\",\"YDGYJE\":\"69.00\",\"YYMZJE\":\"0.00\",\"YYMC\":\"山东立健药店连锁有限公司\",\"YDGYBXJE\":\"62.10\",\"YYMZBXJE\":\"0.00\",\"BXJE\":\"62.10\",\"FPSJ\":\"2022-07-20\",\"JSSJ\":\"2022-07-20\",\"PJZS\":\"1\",\"FILEPATH\":\"http://172.18.37.202:17001/wbglWeb/rest/file/gwDownload/Z0368765912282/\",\"FILENAMES\":\"3706111965072900121110001.jpg\",\"ZFSJ\":\"2022-07-20 19:30:18\",\"ZFZT\":\"1\",\"JFJE\":\"0.00\",\"SDSJ\":\"2022-07-20\"}]}";

        String sqlFragment = "LSH1XMinsert Z0368765912282 into t_role(role_id,role_name,"
                + "role_level,org_id,role_type,role_status,add_user_id,"
                + "add_time,upd_user_id,upd_time) Z0360765912282 values(#{id},"
                + "${role_name},LSH2XM${role_level},${org_id},${role_type},"
                + "${role_status},"
                + "#E{accId},#{dateInt},#{accId},#E{dateInt})" +
                "120223197102211218" +
                "120223197102211218";
        String pattern = "Z03[0-9]*";
        System.out.println(pattern);
        boolean isMatch = Pattern.matches(pattern, sqlFragment);
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
        Pattern pattern1 = Pattern.compile("Z03[0-9]*", Pattern.MULTILINE);
        Matcher matcher = pattern1.matcher(str);
        //循环，字符串中有多少个符合的，就循环多少次
        while(matcher.find()){
            //字符串截取
//            String substring = str.substring(str.indexOf("LSH\":\""), str.indexOf("\",\"XM\":\"吕峰\"")).replace("LSH\":\"","");
            System.out.println(matcher.group());
        }

        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH");
        String s = "2022-08-09";
        Date a = sdf.parse(s);
//        int a = 5;
//        int b = 5;
//        a |= b;
        System.out.println(a);
    }


    static void b(){
        throw new ServiceException("11");
    }

    static void t(){
        b();
    }

    public static void main2(String[] aers) throws NoSuchAlgorithmException {
//        SecretKeySpec secretKey = getSecretKey("1");
//        System.out.println(secretKey);
//        String encrypt = encrypt("2", "2");
//        System.out.println(encrypt);
//        String decrypt = decrypt(encrypt, "2");
//        System.out.println(decrypt);
        try{
            t();
        }catch (Exception e){
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            e.printStackTrace(new PrintStream(baos));
            String exception = baos.toString();
//            System.out.println(e);
//            e.printStackTrace();
        }

    }


    public static SecretKeySpec getSecretKey(String myKey) throws NoSuchAlgorithmException {
        byte[] key = myKey.getBytes(StandardCharsets.UTF_8);
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        key = sha.digest(key);
        key = Arrays.copyOf(key, 16);
        return new SecretKeySpec(key, "AES");
    }

    public static String encrypt(String strToEncrypt, String secret) {
        try {
            SecretKeySpec secretKey = getSecretKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e);
        }
        return null;
    }


    public static String decrypt(String strToDecrypt, String secret) {
        try {
            SecretKeySpec secretKey = getSecretKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            throw new ServiceException("数据解密失败");
        }
    }
}
