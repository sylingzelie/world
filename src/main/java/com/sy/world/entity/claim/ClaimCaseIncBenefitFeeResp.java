package com.sy.world.entity.claim;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

/**
 * @author liuhong
 * @date 2021/09/22
 * @description
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ClaimCaseIncBenefitFeeResp {

    /**
     * 收据号
     */
    @XmlElement(required = true, name = "RECEIPT_NO")
    private String receiptNo;
    /**
     * 费用项编码
     */
    @XmlElement(required = true, name = "FEE_CODE")
    private String feeCode;
    /**
     * 出险日期
     */
    @XmlElement(required = true, name = "EVENT_DATE")
    private String eventDate;
    /**
     * 责任外金额
     */
    @XmlElement(required = false, name = "OUT_BENEFIT_FEE")
    private BigDecimal outBenefitFee;
    /**
     * 理算金额
     */
    @XmlElement(required = false, name = "AMOUNT")
    private BigDecimal amount;
    /**
     * 赔付金额
     */
    @XmlElement(required = false, name = "PAY_AMOUNT")
    private BigDecimal payAmount;
    /**
     * 赔付结论
     */
    @XmlElement(required = false, name = "PAY_DECISION")
    private String payDecision;
    /**
     * 赔付结论原因
     */
    @XmlElement(required = false, name = "PAY_DECISION_REASON")
    private String payDecisionReason;
    /**
     * 匹配责任类型
     */
    @XmlElement(required = true, name = "MATCH_TYPE")
    private String matchType;
    /**
     * 匹配结果
     */
    @XmlElement(required = true, name = "RESULT")
    private String result;
    /**
     * 匹配结果描述
     */
    @XmlElement(required = false, name = "RESULT_MSG")
    private String resultMsg;
}
