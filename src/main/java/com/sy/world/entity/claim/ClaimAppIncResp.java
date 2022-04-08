package com.sy.world.entity.claim;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author liuhong
 * @date 2021/09/22
 * @description
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ClaimAppIncResp {
    /**
     * 事件流水号
     */
    @XmlElement(required = true, name = "INC_ID")
    private String incId;
    /**
     * 出险原因代码
     */
    @XmlElement(required = true, name = "CLM_REASON_CODE")
    private String clmReasonCode;
    /**
     * 出险类型代码
     */
    @XmlElement(required = true, name = "CLM_TYPE_CODE")
    private String clmTypeCode;
    /**
     * 就诊方式
     */
    @XmlElement(required = true, name = "VIS_MODE")
    private String visMode;
    /**
     * 就诊开始日期
     */
    @XmlElement(required = false, name = "START_DAY")
    private String startDay;
    /**
     * 就诊结束日期
     */
    @XmlElement(required = false, name = "END_DAY")
    private String endDay;
    /**
     * 意外日期
     */
    @XmlElement(required = false, name = "ACC_DAY")
    private String accDay;
    /**
     * 生育日期
     */
    @XmlElement(required = false, name = "BEAR_DAY")
    private String bearDay;
    /**
     * 身故日期
     */
    @XmlElement(required = false, name = "DEATH_DAY")
    private String deathDay;
    /**
     * 残疾日期
     */
    @XmlElement(required = false, name = "DEFORMITY_DAY")
    private String deformityDay;
    /**
     * 诊断日期
     */
    @XmlElement(required = false, name = "DIAGNOSIS_DAY")
    private String diagnosisDay;
    /**
     * 就诊医院
     */
    @XmlElement(required = false, name = "HOSPITAL")
    private String hospital;
    /**
     * 事故经过
     */
    @XmlElement(required = false, name = "ACCIDENT")
    private String accident;
    /**
     * 损伤外部原因代码
     */
    @XmlElement(required = false, name = "OUTSIDE_REASON_CODE")
    private String outsideReasonCode;
    /**
     * 重疾代码
     */
    @XmlElement(required = false, name = "SEROUS_ILLNESS_CODE")
    private String serousIllNessCode;
    /**
     * 诊断结果
     */
    @XmlElement(required = false, name = "VIS_RESULT_CODE")
    private String visResultCode;
    /**
     * 发票信息
     */
    @XmlElement(required = true, name = "RECEIPT_LIST")
    private ClaimAppIncReceiptListResp receiptList;
    /**
     * 风险信息
     */
    @XmlElement(required = true, name = "RISK_ITEM_LIST")
    private ClaimAppIncRiskListResp riskList;
}
