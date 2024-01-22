package com.sy.world;

import com.alibaba.nacos.api.PropertyKeyConst;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class mq {
//    public static void main(String[] args) {
//        Properties properties = new Properties();
//        // 您在消息队列RocketMQ版控制台创建的Group ID。
//        properties.put(PropertyKeyConst.GROUP_ID,"XXX");
//        // AccessKey ID，阿里云身份验证标识。
//        properties.put(PropertyKeyConst.AccessKey,"xxx");
//        // AccessKey Secret，阿里云身份验证密钥。
//        properties.put(PropertyKeyConst.SecretKey,"xxx");
//        // 设置TCP接入域名，进入消息队列RocketMQ版控制台实例详情页面的接入点区域查看。
//        properties.put(PropertyKeyConst.NAMESRV_ADDR,"xxxx");
//        KafkaProperties.Producer producer = ONSFactory.createProducer(properties);
//        // 在发送消息前，必须调用start方法来启动Producer，只需调用一次即可。
//
//        Map<String, String> result = new HashMap<>();
//        result.put("orderRefcode","2145814432977409");
//        result.put("orderAmt","0.01");
//        result.put("cardAmt","0.01");
//        result.put("cardAbtmAmt","0.01");
//        result.put("orderDate","2023-12-21");
//        result.put("orderCardcode","1506132100000106");
//        result.put("orderMerchantcode","20231121");
//        result.put("orderMerchantname","企安网药");
//        result.put("orderMerchanturl","https://m.cq.test.laobai.com/payresult?orderNo=2145814432977409&isDrug=false, orderMerchantbackurl=https://cqyb-outapi.test.cqingyb.com/out/puKangPay/callback");
//        result.put("orderTranscontent","PGFwPgogICAgPGRydWdOdW0+MTwvZHJ1Z051bT4KICAgIDxkcnVnPgogICAgICAgIDx0ck5hbWU+5pel5pys5Y6f6KOF546J56u55Y2r5p2Q6YCA54Ot6LS077yM44CQ5Y2h5LyY5bmz44CR5aWl5Yip5Y+45LuW6IO25ZuK5o6S5rK5PC90ck5hbWU+CiAgICAgICAgPGxvY2FsQ29kZT4yMTI0OTA1PC9sb2NhbENvZGU+CiAgICAgICAgPHF0eT4xPC9xdHk+CiAgICAgICAgPHByaWNlPjAuMDEwMDwvcHJpY2U+CiAgICAgICAgPHN1YnRvdGFsPjAuMDE8L3N1YnRvdGFsPgogICAgPC9kcnVnPgo8L2FwPg==");
//        result.put("orderMemo","");
//        result.put("orderTranscode","2023122150000018");
//        result.put("orderUpdatetime","2023-12-21 13:56:45");
//        result.put("orderType","1");
//        result.put("orderThpayAmt","0.00");
//        result.put("errorCode","0");
//        result.put("errorMessage","交易成功");
//        result.put("signMD5","1575276A417E9A4091EF9F7616865B62");
//
//        Push2thirdMsgDTO dto = new Push2thirdMsgDTO();
//        Push2thirdMsgDTO.Req req = new Push2thirdMsgDTO.Req();
//        req.setUrl("https://cqyb-outapi.test.cqingyb.com/out/puKangPay/callback");
//        req.setMethod("POST");
//        req.setContentType("application/x-www-form-urlencoded");
//        req.setData(JSON.toJSONString(result));
//        dto.setReq(req);
//
//        Push2thirdMsgDTO.BackReq backReq = new Push2thirdMsgDTO.BackReq();
//        backReq.setUrl("http://127.0.0.1:8080/order/updateOrderStatus");
//        backReq.setMethod("POST");
//        Map<String, String> map = new HashMap<>();
//        map.put("orderRefCode", "2145814432977409");
//        map.put("status", "0");
//        backReq.setData(JSON.toJSONString(map));
//        dto.setBackReq(backReq);
//
//        producer.start();
//        Message msg = new Message(
//                // Message所属的Topic。
//                "pk-message-internal",
//                // Message Tag，可理解为Gmail中的标签，对消息进行再归类，方便Consumer指定过滤条件在消息队列RocketMQ版的服务器过滤。
//                "pkp2third",
//                // Message Body，可以是任何二进制形式的数据，消息队列RocketMQ版不做任何干预，需要Producer与Consumer协商好一致的序列化和反序列化方式。
//                JSON.toJSONString(dto).getBytes());
//        // 设置代表消息的业务关键属性，请尽可能全局唯一。
//        // 以方便您在无法正常收到消息情况下，可通过消息队列RocketMQ版控制台查询消息并补发。
//        // 注意：不设置也不会影响消息正常收发。
//        msg.setKey("2145814432977414");
//        try {
//            SendResult sendResult = producer.send(msg);
//            // 发送消息，只要不抛异常就是成功。
//            if (sendResult != null) {
//                System.out.println(new Date() + " Send mq message success. Topic is:" + msg.getTopic() + " msgId is: " + sendResult.getMessageId());
//            }
//        } catch (Exception e) {
//            // 消息发送失败，需要进行重试处理，可重新发送这条消息或持久化这条数据进行补偿处理。
//            System.out.println(new Date() + " Send mq message failed. Topic is:" + msg.getTopic());
//            e.printStackTrace();
//        }
//        // 在应用退出前，销毁Producer对象。
//        // 注意：销毁Producer对象可以节约系统内存，若您需要频繁发送消息，则无需销毁Producer对象。
//        producer.shutdown();
//    }

    public static void main(String[] args) {
        String s = "212313,1";
        String[] split = s.split(",");
        System.out.println(split.toString());
    }
}
