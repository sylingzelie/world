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
public class ClaimCaseIncBenefitResp {

    /**
     * 事件号
     */
    @XmlElement(required = true, name = "INC_ID")
    private String incId;
    /**
     * 保单号
     */
    @XmlElement(required = true, name = "POLICY_NO")
    private String policyNo;
    /**
     * 产品计划责任ID
     */
    @XmlElement(required = true, name = "PLAN_BENEFIT_ID")
    private String planBenefitId;
    /**
     * 出险日期
     */
    @XmlElement(required = true, name = "EVENT_DATE")
    private String eventDate;
    /**
     * 理算金额
     */
    @XmlElement(required = false, name = "CAL_AMOUNT")
    private BigDecimal calAmount;
    /**
     * 赔付金额
     */
    @XmlElement(required = false, name = "PAY_AMOUNT")
    private BigDecimal payAmount;
    /**
     * 津贴天数
     */
    @XmlElement(required = false, name = "ALLOWANCE_DAYS")
    private BigDecimal allowanceDays;
    /**
     * 匹配责任类型
     */
    @XmlElement(required = true, name = "MATCH_TYPE")
    private String matchType;
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
     * 赔付结论原因明细
     */
    @XmlElement(required = false, name = "PAY_DECISION_REASON_DETAIL")
    private String payDecisionReasonDetail;
    /**
     * 匹配理算结果
     */
    @XmlElement(required = true, name = "RESULT")
    private String result;
    /**
     * 匹配理算结果描述
     */
    @XmlElement(required = false, name = "RESULT_MSG")
    private String resultMsg;
    /**
     * 责任金额
     */
    @XmlElement(required = true, name = "CASE_FEE_BENEFIT_LIST")
    private ClaimCaseIncBenefitFeeListResp caseFeeBenefitList;
    /**
     * 限额免赔额
     */
    @XmlElement(required = true, name = "CASE_LIMIT_DEDUCT")
    private ClaimCaseLimitDeductListResp caseLimitDeduct;
    /**
     * 案件事件结果集合
     */
    @XmlElement(required = true, name = "CASE_ACC_RESULT_LIST")
    private ClaimCaseAccResultListResp caseAccResultList;
}
