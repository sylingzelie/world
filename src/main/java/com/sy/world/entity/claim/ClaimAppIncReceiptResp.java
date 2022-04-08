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
public class ClaimAppIncReceiptResp {

    /**
     * 收据流水号
     */
    @XmlElement(required = true, name = "APP_RECEIPT_ID")
    private String appReceiptId;
    /**
     * 收据类型
     */
    @XmlElement(required = true, name = "RECEIPT_TYPE")
    private String receiptType;
    /**
     * 医保收据标志
     */
    @XmlElement(required = true, name = "MED_RECEIPT_FLAG")
    private String medReceiptFlag;
    /**
     * 医保类型
     */
    @XmlElement(required = false, name = "MED_RECEIPT_TYPE")
    private String medReceiptType;
    /**
     * 收据号
     */
    @XmlElement(required = true, name = "RECEIPT_NUM")
    private String receiptNum;
    /**
     * 收据币种
     */
    @XmlElement(required = true, name = "RECEIPT_CURRENCY")
    private String receiptCurrency;
    /**
     * 医疗收据姓名
     */
    @XmlElement(required = true, name = "RECEIPT_NAME")
    private String receiptName;
    /**
     * 就诊方式
     */
    @XmlElement(required = true, name = "VIS_MODE")
    private String visMode;
    /**
     * 就诊医院
     */
    @XmlElement(required = false, name = "MEDICAL_ORG_ID")
    private String medicalOrgId;
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
     * 实际住院天数
     */
    @XmlElement(required = false, name = "VIS_DAYS")
    private BigDecimal visDays;
    /**
     * 就诊总额
     */
    @XmlElement(required = false, name = "SUM_FEE")
    private BigDecimal sumFee;
    /**
     * 自费金额
     */
    @XmlElement(required = false, name = "OWN_FEE")
    private BigDecimal ownFee;
    /**
     * 分类自负金额
     */
    @XmlElement(required = false, name = "CONCEIT_FEE")
    private BigDecimal conceitFee;
    /**
     * 医保支付金额
     */
    @XmlElement(required = true, name = "INS_FEE")
    private String insFee;
    /**
     * 其他支付金额
     */
    @XmlElement(required = false, name = "OTHER_FEE")
    private BigDecimal otherFee;
    /**
     * 诊断结果
     */
    @XmlElement(required = true, name = "VIS_RESULT_CODE")
    private String visResultCode;
    /**
     * 备注
     */
    @XmlElement(required = false, name = "REMARK")
    private String remark;
    /**
     * 第三方直付类型
     */
    @XmlElement(required = true, name = "OTHER_PAY_LIST")
    private ClaimAppIncReceiptOtherPayListResp otherPayList;

    /**
     * 费用流水
     */
    @XmlElement(required = true, name = "FEE_ITEM_LIST")
    private ClaimAppIncReceiptFeeItemListResp feeItemList;

    /**
     * 北京地区发票必录
     */
    @XmlElement(required = true, name = "RECEIPT_EXT_INFO")
    private ClaimAppIncReceiptExtInfoResp receiptExtInfo;
}
