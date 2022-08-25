package com.sy.world.controller;

import com.aliyun.oss.ServiceException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.CountDownLatch;


public class test extends Observable {

    private static class T {

        public long x = 0L;
    }

    public static T[] arr = new T[2];

    static{
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main2(String[] args) {

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

        CountDownLatch latch = new CountDownLatch(2);
        long COUNT = 1000000000L;
        Thread t1 = new Thread(() ->{
            for (long i = 0; i < COUNT; i++){
                arr[0].x = i;
            }
        });

    }
    public static void main(String[] aers) throws NoSuchAlgorithmException {
//        SecretKeySpec secretKey = getSecretKey("1");
//        System.out.println(secretKey);
        String encrypt = encrypt("2", "2");
        System.out.println(encrypt);
        String decrypt = decrypt(encrypt, "2");
        System.out.println(decrypt);
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
