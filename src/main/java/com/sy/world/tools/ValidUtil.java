package com.sy.world.tools;



import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class ValidUtil {

	/**
	 * 解密操作
	 *
	 * @param Ciphertext
	 * @return Map<String, Object>
	 */
	public static Map<String, Object> decrypt(String Ciphertext) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			System.out.println("---------密文---------" + Ciphertext + "---------");
			byte[] str = Base64.decode(Ciphertext);
			Ciphertext = new String(str, "utf-8");
			String plaintext = Des3.decode(Ciphertext);
			str = Base64.decode(plaintext);
			plaintext = new String(str, "utf-8");
			System.out.println("---------明文---------" + plaintext + "---------");
			map = JSONObject.fromObject(plaintext);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 加密操作
	 *
	 * @param plaintext
	 * @return String
	 */
	public static String encrypt(String plaintext) {
		String Ciphertext = "";
		try {
			System.out.println("---------明文---------" + plaintext + "---------");
			plaintext = Base64.encode(plaintext.getBytes("UTF-8"));
			Ciphertext = Des3.encode(plaintext);
			Ciphertext = plaintext = Base64.encode(Ciphertext.getBytes("UTF-8"));
			System.out.println("---------密文---------" + Ciphertext + "---------");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Ciphertext; }

}
