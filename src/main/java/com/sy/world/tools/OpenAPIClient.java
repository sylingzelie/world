package com.sy.world.tools;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public class OpenAPIClient {
    private String partnerId;
    private String partnerKey;
    private QueryEnv env;
    private SecureRandom random = new SecureRandom();
    private static final Pattern pattern = Pattern.compile("[0-9a-fA-F]+");

    public OpenAPIClient(String partnerId, String partnerKey, QueryEnv env) {
        this.partnerId = partnerId;
        this.partnerKey = partnerKey;
        this.env = env;
    }

    public String request(String apiGroup, String apiName, String apiId, Object... orderedParams) throws UnsupportedEncodingException {
        Map<String, Object> params = null;
        if (orderedParams.length > 0) {
            params = new HashMap();

            for(int i = 0; i < orderedParams.length; ++i) {
                params.put("arg" + (i + 1), orderedParams[i]);
            }
        }

        return this.request(apiGroup, apiName, apiId, (Map)params);
    }

    public String request(String apiGroup, String apiName, String apiId, Map<String, Object> params) throws UnsupportedEncodingException {
        String salt = String.valueOf(this.random.nextFloat());
        String body = String.format("__o_s=%s&__o_v=0.1.0&__o_r=%s", apiId, salt);
        Entry kv;
        if (params != null) {
            for(Iterator var7 = params.entrySet().iterator(); var7.hasNext(); body = body + "&" + kv.getKey() + "=" + URLEncoder.encode(JSON.toJSONString(kv.getValue()), "utf-8")) {
                kv = (Entry)var7.next();
            }
        }

        System.out.println("body加密前：" + body + "\n密钥：" + this.partnerKey);
        body = TripleDESUtil.encrypt(body, this.partnerKey);
        System.out.println("body加密后：" + body + "\nsalt：" + salt);
        String sig = TripleDESUtil.hmac(body, this.partnerKey, salt);
        System.out.println("签名：" + sig);
        String postURL = String.format("%s%s/%s?p=%s&v=%s&s=%s&h=%s", this.env.getUrl(), apiGroup, apiName, this.partnerId, "0.1.0", salt, sig);
        System.out.println("最终的请求地址：" + postURL + "\n");
        return this.parseResponse(this.makeRequest(postURL, "q=" + body));
    }

    private String parseResponse(String text) {
        System.out.println("完整的响应报文：" + text + "\n");
        Map obj = (Map)JSONObject.parseObject(text, Map.class);
        String objectStr = obj.get("object").toString();
        System.out.println("响应报文中的object密文：" + objectStr + "\n");
        Integer code = (Integer)obj.get("code");
        if (code == 0) {
            return TripleDESUtil.decrypt(objectStr, this.partnerKey);
        } else {
            throw new RuntimeException("Fail to call request ticket due to: " + obj.get("tips"));
        }
    }

    private String makeRequest(String requestUrl, String request_body) {
        try {
            URL url = new URL(requestUrl);
            URLConnection urlConnection = url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestProperty("content-type", "application/x-www-form-urlencoded");
            OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream());
            out.write(request_body);
            out.flush();
            out.close();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];

            int len;
            while((len = urlConnection.getInputStream().read(buffer, 0, buffer.length)) != -1) {
                byteArrayOutputStream.write(buffer, 0, len);
            }

            return new String(byteArrayOutputStream.toByteArray());
        } catch (IOException var9) {
            throw new RuntimeException("Fail to call request ticket due to IOException");
        }
    }
}
