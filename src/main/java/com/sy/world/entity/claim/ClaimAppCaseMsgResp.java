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
public class ClaimAppCaseMsgResp {

    /**
     * 赔案号
     */
    @XmlElement(required = true, name = "CASE_NO")
    private String caseNo;
    /**
     * 责任属性
     */
    @XmlElement(required = true, name = "BENEFIT_TYPE")
    private String benefitType;
    /**
     * 团体保单编号
     */
    @XmlElement(required = true, name = "GRP_POLICY_NO")
    private String grpPolicyNo;
    /**
     * 立案日期
     */
    @XmlElement(required = true, name = "RGT_DATE")
    private String rgtDate;
    /**
     * 赔付结论
     */
    @XmlElement(required = false, name = "CASE_DECISION")
    private String caseDecision;
    /**
     * 总赔付金额
     */
    @XmlElement(required = false, name = "PAY_AMOUNT")
    private BigDecimal payAmount;
    /**
     * 审核意见
     */
    @XmlElement(required = false, name = "AUDIT_COMMMENT")
    private String auditComment;
    /**
     * 审核日期
     */
    @XmlElement(required = false, name = "AUDIT_DATE")
    private String auditDate;
    /**
     * 撤销原因
     */
    @XmlElement(required = false, name = "CANCEL_REASON")
    private String cancelReason;
    /**
     * 撤销原因描述
     */
    @XmlElement(required = false, name = "CANCEL_DESC")
    private String cancelDesc;
    /**
     * 撤销日期
     */
    @XmlElement(required = false, name = "CANCEL_DATE")
    private String cancelDate;
    /**
     * 赔案状态
     */
    @XmlElement(required = true, name = "CASE_STATE")
    private String caseState;
    /**
     * 事件责任集合
     */
    @XmlElement(required = true, name = "CASE_INC_BENEFIT_LIST")
    private ClaimCaseIncBenefitListResp  caseIncBenefitList;
}
