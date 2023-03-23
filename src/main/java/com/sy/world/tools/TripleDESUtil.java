package com.sy.world.tools;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class TripleDESUtil {
    private static final Pattern pattern = Pattern.compile("[0-9a-fA-F]+");

    public TripleDESUtil() {
    }

    public static String hmac(String dataStr, String keyStr, String saltStr) {
        try {
            byte[] data = (dataStr + saltStr).getBytes("UTF-8");
            byte[] key = keyStr.getBytes("UTF-8");
            SecretKeySpec keySpec = new SecretKeySpec(key, "HmacSHA1");
            Mac e = Mac.getInstance("HmacSHA1");
            e.init(keySpec);
            return toHexString(e.doFinal(data));
        } catch (Exception var7) {
            throw new RuntimeException("Signature calculation error");
        }
    }

    public static String encrypt(String message, String key) {
        try {
            SecretKeySpec var10 = new SecretKeySpec(toKeyBytes(key), "DESede");
            IvParameterSpec var11 = new IvParameterSpec(new byte[8]);
            Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
            cipher.init(1, var10, var11);
            byte[] plainTextBytes = message.getBytes("utf-8");
            return toHexString(cipher.doFinal(plainTextBytes));
        } catch (Exception var6) {
            throw new RuntimeException("Fail");
        }
    }

    public static String decrypt(String cypher, String key) {
        try {
            Map<String, String> map = toMap(cypher, false);
            String salt = (String)map.get("s");
            String expSig = (String)map.get("h");
            String dataStr = (String)map.get("d");
            String actSig = hmac(dataStr, key, salt);
            if (!actSig.equals(expSig)) {
                throw new RuntimeException("Fail to validate signatures, potentialdatacorruption");
            } else {
                Matcher match = pattern.matcher(dataStr);
                if (!match.matches()) {
                    throw new IllegalArgumentException("Invalid hex string: " + dataStr);
                } else if (dataStr.length() % 2 != 0) {
                    throw new IllegalArgumentException("Invalid hex string length:" + dataStr);
                } else {
                    int len = dataStr.length();
                    byte[] data = new byte[len / 2];

                    for(int i = 0; i < len; i += 2) {
                        data[i / 2] = (byte)((Character.digit(dataStr.charAt(i), 16) << 4) + Character.digit(dataStr.charAt(i + 1), 16));
                    }

                    SecretKeySpec keySpec = new SecretKeySpec(toKeyBytes(key), "DESede");
                    IvParameterSpec iv = new IvParameterSpec(new byte[8]);
                    Cipher decipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
                    decipher.init(2, keySpec, iv);
                    byte[] plainText = decipher.doFinal(data);
                    String token = (String)toMap(new String(plainText, "UTF-8"), true).get("__o_o");
                    if (token != null && token.length() >= 3) {
                        return token;
                    } else {
                        throw new RuntimeException("Get invalid ticket: " + (token == null ? "null" : token));
                    }
                }
            }
        } catch (Exception var15) {
            throw new RuntimeException("Fail  to decrypt");
        }
    }

    public static Map<String, String> toMap(String data, boolean doUrlDecode) {
        try {
            Map<String, String> paramMap = new HashMap();
            if (data != null && data.trim().length() != 0) {
                data = data.trim();
                String[] cipher = data.split("&");
                String[] var4 = cipher;
                int var5 = cipher.length;

                for(int var6 = 0; var6 < var5; ++var6) {
                    String aCipher = var4[var6];
                    String[] pairs = aCipher.split("=");
                    if (doUrlDecode) {
                        paramMap.put(pairs[0], URLDecoder.decode(pairs[1], "UTF-8"));
                    } else {
                        paramMap.put(pairs[0], pairs[1]);
                    }
                }
            }

            return paramMap;
        } catch (UnsupportedEncodingException var9) {
            throw new RuntimeException("Fail to url decode");
        }
    }

    public static String toHexString(byte[] data) {
        StringBuilder buffer = new StringBuilder();
        byte[] var2 = data;
        int var3 = data.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            byte aData = var2[var4];
            buffer.append(String.format("%02x", 255 & aData));
        }

        return buffer.toString();
    }

    public static byte[] toKeyBytes(String key) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("md5");
        byte[] digestOfPassword = md.digest(key.getBytes("utf-8"));
        byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
        System.arraycopy(keyBytes, 0, keyBytes, 16, 8);
        return keyBytes;
    }
}
