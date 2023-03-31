package com.sy.world.tools;


import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Slf4j
public class AESUtils {
    /**
     * 密钥算法
     */
    private static final String ALGORITHM = "AES";

    /**
     * 加解密算法/工作模式/填充方式
     */
    private static final String ALGORITHM_MODE_PADDING = "AES/ECB/PKCS7Padding";

    /**
     * 生成key
     */
    private static SecretKeySpec KEY;

    static {
        try {
            // Constants.API_KEY(微信支付秘钥)
            KEY = new SecretKeySpec(MD5Utils.MD5Encode("0793814dce7df0845a3fe4aad10efb11", "UTF-8").toLowerCase().getBytes(), ALGORITHM);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * AES加密
     *
     * @param data d
     * @return str
     * @throws Exception e
     */
    public static String encryptData(String data) throws Exception {
        // 创建密码器
//        Security.addProvider(new BouncyCastleProvider());
        Cipher cipher = Cipher.getInstance(ALGORITHM_MODE_PADDING, "BC");
        // 初始化
        cipher.init(Cipher.ENCRYPT_MODE, KEY);
        return base64Encode8859(new String(cipher.doFinal(data.getBytes()), "ISO-8859-1"));

    }

    /**
     * 解密方式
     * 解密步骤如下：
     * （1）对加密串A做base64解码，得到加密串B
     * （2）对商户key做md5，得到32位小写key* ( key设置路径：微信商户平台(pay.weixin.qq.com)-->账户设置-->API安全-->密钥设置 )
     * （3）用key*对加密串B做AES-256-ECB解密（PKCS7Padding）
     */
    public static String decryptData(String base64Data) {
        String result = "";
        try {
            log.info("解密开始");
//            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance(ALGORITHM_MODE_PADDING, "BC");
            cipher.init(Cipher.DECRYPT_MODE, KEY);
            result = new String(cipher.doFinal(base64Decode8859(base64Data).getBytes("ISO-8859-1")), "utf-8");
            log.info("解密结束result= {}", result);
        } catch (Exception e) {
           log.info("e = ", e);
        }
        return  result;
    }

    /**
     * Base64解码
     *
     * @param source base64 str
     * @return str
     */
    public static String base64Decode8859(final String source) {
        String result = "";
        final Base64.Decoder decoder = Base64.getDecoder();
        try {
            // 此处的字符集是ISO-8859-1
            result = new String(decoder.decode(source), "ISO-8859-1");
        } catch (final UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Base64加密
     *
     * @param source str
     * @return base64 str
     */
    public static String base64Encode8859(final String source) {
        String result = "";
        final Base64.Encoder encoder = Base64.getEncoder();
        byte[] textByte = null;
        try {
            //注意此处的编码是ISO-8859-1
            textByte = source.getBytes("ISO-8859-1");
            result = encoder.encodeToString(textByte);
        } catch (final UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

}
