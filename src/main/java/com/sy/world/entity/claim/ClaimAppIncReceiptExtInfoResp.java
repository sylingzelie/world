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
public class ClaimAppIncReceiptExtInfoResp {

    /**
     * 个人现金支付金额
     */
    @XmlElement(required = true, name = "PSN_CASH_AMNT")
    private BigDecimal psnCashAmnt;

    /**
     * 个人账户支付金额
     */
    @XmlElement(required = true, name = "PSN_ACC_AMNT")
    private BigDecimal psnAccAmnt;

    /**
     * 个人账户余额
     */
    @XmlElement(required = true, name = "PSN_ACC_VALUE")
    private BigDecimal psnAccValue;

    /**
     * 医疗保险范围内金额
     */
    @XmlElement(required = true, name = "MEDC_INS_AMNT")
    private BigDecimal medcInsAmnt;

    /**
     * 累计医保范围内金额
     */
    @XmlElement(required = true, name = "MEDICAL_INS_AMNT_TOTAL")
    private BigDecimal medicalInsAmntTotal;

    /**
     * 年度门诊大额累计支付
     */
    @XmlElement(required = true, name = "OUTPAT_TOTAL_YEAR_AMNT")
    private BigDecimal outpayTotalYearAmnt;

    /**
     * 本年度统筹基金累计支付
     */
    @XmlElement(required = true, name = "OVERALL_TOTAL_YEAR_FUND")
    private BigDecimal overallTotalYearFund;

    /**
     * 本年度大额互助资金（住院）累计支付
     */
    @XmlElement(required = true, name = "INPAT_AMNT_TOTAL_YEAR")
    private BigDecimal inpatAmntTotalYear;

    /**
     * 医保保险基金支付金额
     */
    @XmlElement(required = true, name = "MEDC_INS_FUND_AMNT")
    private BigDecimal medcInsFundAmnt;

    /**
     * 医保保险基金-门诊大额支付
     */
    @XmlElement(required = true, name = "MEDC_INS_FUND_OUTPAT_AMNT")
    private BigDecimal medcInsFundOutpatAmnt;

    /**
     * 医保保险基金-统筹基金支付
     */
    @XmlElement(required = true, name = "MEDC_INS_FUND_OVERALL_AMNT")
    private BigDecimal medcInsFundOverallAmnt;

    /**
     * 医保保险基金-大额互助资金（住院）支付
     */
    @XmlElement(required = true, name = "MEDC_INS_FUND_INPAT_AMNT")
    private BigDecimal medcInsFundInpatAmnt;

    /**
     * 医保保险基金-退休补充保险支付
     */
    @XmlElement(required = true, name = "MEDC_INS_FUND_RETIRE_AMNT")
    private BigDecimal medcInsFundRetireAmnt;

    /**
     * 医保保险基金-残疾军人补助支付
     */
    @XmlElement(required = true, name = "MEDC_INS_FUND_DEFO_AMNT")
    private BigDecimal medcInsFundDefoAmnt;

    /**
     * 医保保险基金-单位补充险（原公疗）支付
     */
    @XmlElement(required = true, name = "MEDC_INS_FUND_COM_AMNT")
    private BigDecimal medcInsFundComAmnt;

    /**
     * 个人支付、自费金额
     */
    @XmlElement(required = true, name = "PSN_OWN_AMNT")
    private BigDecimal psnOwnAmnt;

    /**
     * 个人支付-自付一
     */
    @XmlElement(required = true, name = "PSN_OWN_ONE_AMNT")
    private BigDecimal psnOwnOneAmnt;

    /**
     * 个人支付-自付一起付金额
     */
    @XmlElement(required = true, name = "PSN_OWN_ONE_START_AMNT")
    private BigDecimal psnOwnOneStartAmnt;

    /**
     * 个人支付-自付一超大额封顶基金
     */
    @XmlElement(required = true, name = "PSN_OWN_ONE_END_AMNT")
    private BigDecimal psnOwnOneEndAmnt;

    /**
     * 个人支付-自付一损伤外部原因代码
     */
    @XmlElement(required = true, name = "PSN_OWN_ONE_OUTSIDE_AMNT")
    private BigDecimal psnOwnOneOutsideAmnt;

    /**
     * 个人支付-自付二
     */
    @XmlElement(required = true, name = "PSN_OWN_SEC_AMNT")
    private BigDecimal psnOwnSecAmnt;

    /**
     * 个人支付-自费
     */
    @XmlElement(required = true, name = "PSN_OWN_PAY_AMNT")
    private BigDecimal psnOwnPayAmnt;

}
