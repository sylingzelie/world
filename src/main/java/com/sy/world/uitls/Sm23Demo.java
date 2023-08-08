package com.sy.world.uitls;


/**
 * SM2+SM3 加密解密demo
 *
 * @author Administrator
 */
public class Sm23Demo {

    /*
     *
     * 	调用对方接口时使用对方的公钥进行数据加密
     * 	接收参数使用自己的私钥进行解密
     * 	timestamp 唯一（时间戳+随机数(8位) 或者 UUID）    ***接口字段传输****
     *
     *  私钥 ：C1259BF13DCA39946D3722E52BAC2079B59E29706A0EED1BACB90E7A1252FA36
     *  公钥 ：04233D7DEE1CE1586F98A9654F8C483498845108A07A3AF07407AEDBFD762C0C3ADDCD5FFCA48E9E170858BC89D60334C15F0C5DEFD56C9F77B9C4E00E676688D4
     */

    public static void main(String[] args) {
        //timestamp 时间戳+随机数(8位) 或者 UUID  ***放在入参中****
       // String timestamp = UUID.randomUUID().toString().replaceAll("-", "");
		//时间戳可以为空
		String timestamp ="";
        System.out.println(timestamp);
        //原始数据
        String plainText = "{\"name\":\"zhangsan\",\"age\":32}";
        System.out.println("#########数据加密#########");
        String encryptBySM2 = encryptBySM2(plainText, timestamp);
        System.out.println(encryptBySM2);
        System.out.println("#########数据解密#########");
        String decryptBySM2 = decryptBySM2(encryptBySM2, timestamp);
        System.out.println("原始数据：" + decryptBySM2);
    }


    /**
     * 数据加密
     *
     * @param plainText
     * @param timestamp 接口字段传输
     * @return
     */
    public static String encryptBySM2(String plainText, String timestamp) {
        String pubKey = "04233D7DEE1CE1586F98A9654F8C483498845108A07A3AF07407AEDBFD762C0C3ADDCD5FFCA48E9E170858BC89D60334C15F0C5DEFD56C9F77B9C4E00E676688D4";
        //数据加密
        String sm3Digest = SM3Util.SM3Digest(plainText + "&" + timestamp);
        System.out.println("SM3签名：" + sm3Digest);
        String encryptBySM2 = SM2Util.encryptBySM2(plainText + "&" + sm3Digest, pubKey);
        System.out.println("加密后数据：" + encryptBySM2);
        return encryptBySM2;
    }


    /**
     * 数据解密
     *
     * @param encryptBySM2
     * @param timestamp    接口字段传输
     */
    public static String decryptBySM2(String encryptBySM2, String timestamp) {
        String priKey = "C1259BF13DCA39946D3722E52BAC2079B59E29706A0EED1BACB90E7A1252FA36";
        //数据解密
        String decryptBySM2 = SM2Util.decryptBySM2(encryptBySM2, priKey);
        System.out.println("解密后数据：" + decryptBySM2);
        //解密后数据验签
        String[] data = decryptBySM2.split("&");
        String sm3Digest2 = SM3Util.SM3Digest(data[0] + "&" + timestamp);
        if (sm3Digest2.equals(data[1])) {
            System.out.println("sm3验签通过");
            return data[0];
        } else {
            System.out.println("sm3验签失败，数据被篡改");
            return "";
        }

    }
}
