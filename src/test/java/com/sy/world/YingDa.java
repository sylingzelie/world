package com.sy.world;

import com.sy.world.tools.HttpClientUtils;
import com.sy.world.tools.JsonUtils;
import com.sy.world.tools.ValidUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class YingDa {
    public static void main(String[] args) {
        //以下是请求英大的接口进行扣款操作
        Map params = new HashMap();
        params.put("thirdpartyid", "ZF004");
        params.put("consumeWay", "1");//1-微信、i国网
        params.put("paymentEntry", 1);//直付入口:1-英大人寿微信   2-i国网英大金融
        params.put("customerid", "0003721873");//测试数据客户ID
        params.put("functionType", "02");//功能类型:02-余额查询
        String jsonStr = JsonUtils.toJson(params);
        String ecryptStr = ValidUtil.encrypt(jsonStr);
        Map ecryptpParams = new HashMap();
        ecryptpParams.put("param", ecryptStr);
        long l1 = System.currentTimeMillis();
        String responseString1 = HttpClientUtils.doPost("http://39.106.0.192:10088/ydrscore/api/chinaNetwork".concat("/queryPersonAcctBalance.do"), ecryptpParams);
        Map<String, Object> responseStr = ValidUtil.decrypt(responseString1);
        System.out.println(responseStr);
    }

    public static void main1(String[] args) {
        //以下是请求英大的接口进行扣款操作
        Map params = new HashMap();
        params.put("consumetype", "1");
        params.put("consumemoney", "-72.00");//1-微信、i国网
        params.put("consumeshop", "合肥格宁大药房连锁有限公司润桉店");//直付入口:1-英大人寿微信   2-i国网英大金融
        params.put("consumeway", "1");//测试数据客户ID
        params.put("thirdpartyid", "ZF004");//功能类型:02-余额查询
        params.put("customerid", "0002063414");//功能类型:02-余额查询
        params.put("paymentEntry", "");//功能类型:02-余额查询
        params.put("consumetime", new Date());//功能类型:02-余额查询
        params.put("serialno", "2023101350011135");//功能类型:02-余额查询
        String jsonStr = JsonUtils.toJson(params);
        String ecryptStr = ValidUtil.encrypt(jsonStr);
        Map ecryptpParams = new HashMap();
        ecryptpParams.put("param", ecryptStr);
        long l1 = System.currentTimeMillis();
        String responseString1 = HttpClientUtils.doPost("http://39.106.0.192:10088/ydrscore/api/chinaNetwork".concat("/payMoney.do"), ecryptpParams);
        Map<String, Object> responseStr = ValidUtil.decrypt(responseString1);
        System.out.println(responseStr);
    }


}
