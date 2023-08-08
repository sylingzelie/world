package com.sy.world.tools;

import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;


public class Des3 {
	// 密钥
	private final static String secretKey;
	// 向量
	private final static String iv = "12345678";
	// 加解密统一使用的编码方式
	private final static String encoding = "UTF-8";
	static{
		secretKey ="c9f41b31fd5531f514535ba731cbd014";
	}
	public static void main(String[] args) throws Exception {
		// 实现3DES加密算法，工作模式CBC，填充模式PKCS5
		String encstr = "k2qnwMKNDeqxILzB7w9Q6WMkGtd%2Bx4tuqIAVy8Qc1eOVztbT/8H7GFleLN5y/2B2EuUMpySE2ZqQQ0icpxUIDEuPuyRPoFJbpPLFGAPgxpmJLn7yNGrxl2HEcTQGRZHprsBrYNEs56TekQpxLJiulLKVKvtyq3CVYnq1/AFduSGYvVqsc2x5/w==";
		System.out.println("加密后：" + encstr);
		System.out.println("解密后：" + decode("k2qnwMKNDeqxILzB7w9Q6WMkGtd%2Bx4tuqIAVy8Qc1eOVztbT/8H7GFleLN5y/2B2EuUMpySE2ZqQQ0icpxUIDEuPuyRPoFJbpPLFGAPgxpmJLn7yNGrxl2HEcTQGRZHprsBrYNEs56TekQpxLJiulLKVKvtyq3CVYnq1/AFduSGYvVqsc2x5/w=="));
	}

	/**
	 * 3DES加密
	 *
	 * @param plainText
	 *            普通文本
	 * @return
	 * @throws Exception
	 */
	public static String encode(String plainText) throws Exception {
		return encode(plainText, secretKey);
	}

	public static String encode(String plainText, String secretKey)
			throws Exception {
		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		deskey = keyfactory.generateSecret(spec);

		Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
		IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
		cipher.init(Cipher.ENCRYPT_MODE, deskey,ips);
		byte[] encryptData = cipher.doFinal(plainText.getBytes(encoding));
		return Base64.encode(encryptData);
	}

	/**
	 * 3DES解密
	 *
	 * @param plainText
	 *            加密文本
	 * @return
	 * @throws Exception
	 */
	public static String decode(String plainText) throws Exception {
		if (StringUtils.isBlank(plainText)) {
			return "";
		}
		return decode(plainText, secretKey);
	}

	public static String decode(String encryptText, String secretKey)
			throws Exception {
		if (StringUtils.isBlank(encryptText)||StringUtils.isBlank(secretKey)) {
			return "";
		}
		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		deskey = keyfactory.generateSecret(spec);
		Cipher cipher = Cipher.getInstance("desede/CBC/NoPadding");
		IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
		cipher.init(Cipher.DECRYPT_MODE, deskey,ips);

		byte[] decryptData = cipher.doFinal(Base64.decode(encryptText));

		return new String(decryptData, encoding).trim();
	}
}