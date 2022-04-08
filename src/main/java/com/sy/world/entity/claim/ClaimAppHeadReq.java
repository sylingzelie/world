package com.sy.world.entity.claim;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author liuhong
 * @date 2021/09/07
 * @description
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ClaimAppHeadReq {

    /**
     * 唯一编码
     */
    @XmlElement(required = true, name = "ID")
    private String reqId;

    /**
     * 校验编码
     */
    @XmlElement(required = true, name = "TRADE_CODE")
    private String tradeCode;

    /**
     * 校验码
     */
    @XmlElement(required = true, name = "CHECK_ID")
    private String checkId;

    /**
     * 发送方编码
     */
    @XmlElement(required = true, name = "SOURCE_ID")
    private String sourceId;

    /**
     * 发送时间
     */
    @XmlElement(required = true, name = "SEND_TIME")
    private String sendTime;

    /**
     * 处理结果
     */
    @XmlElement(required = true, name = "RESULT_CODE")
    private String resultCode;

    /**
     * 处理结果说明
     */
    @XmlElement(required = true, name = "RESULT_MSG")
    private String resultMsg;
}
