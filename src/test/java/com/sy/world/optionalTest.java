package com.sy.world;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class optionalTest {
    public static void main(String[] args) {
        PreCalcReq req = createReq();
        String stringJSON = JSON.toJSONString(createReq());
        System.out.println(stringJSON);
    }

    private static PreCalcReq createReq() {
        PreCalcReq preCalcReq = new PreCalcReq();

        //需要替换对应分配的source
        preCalcReq.setSource("HAI11111");
        preCalcReq.setXrefNo(String.valueOf(System.currentTimeMillis()));
        List<String> tokens = new ArrayList<String>();
        tokens.add("82302532541255811571");
        tokens.add("25837762293537899863");
        preCalcReq.setTokens(tokens);
        preCalcReq.setAmount(1005L);// balance not enough
        preCalcReq.setStoreId(100012460306L);
        preCalcReq.setStoreName("不支持新模式的门店");
        OpenOrderDigest digest = buildDigest(preCalcReq.getAmount());
        preCalcReq.setDigest(digest);
        return preCalcReq;

    }

    public static OpenOrderDigest buildDigest(long payAmount) {
        OpenOrderDigest digest = new OpenOrderDigest();
        try {
            digest.setOrderDate(new Date());
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        digest.setOrderNo("orderNo");
        digest.setOutStoreId("outStoreId");
        digest.setTotal(payAmount);
        digest.setOwnPay(11L);
        digest.setClerkPhone("17601363452");
        digest.setUseCoupon(true);
        digest.setPrimeDay(true);
        OpenItemLine line1 = new OpenItemLine();
        line1.setName("spu-1");
        line1.setBarcode("barCode1");
        line1.setQty(1);
        line1.setPrice(100L);
        line1.setItemCode("123123");
        OpenItemLine line2 = new OpenItemLine();
        line2.setName("spu-2");
        line2.setBarcode("barCode2");
        line2.setQty(4);
        line2.setPrice(50L);
        line2.setItemCode("122");
        digest.setItems(Arrays.asList(line1, line2));
        return digest;
    }
}
