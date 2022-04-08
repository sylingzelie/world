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
public class ClaimAppIncReceiptFeeItemResp {

    /**
     * 费用流水号
     */
    @XmlElement(required = true, name = "FEE_ID")
    private String feeId;
    /**
     * 费用类型
     */
    @XmlElement(required = true, name = "FEE_TYPE_CODE")
    private String feeTypeCode;
    /**
     * 费用金额
     */
    @XmlElement(required = true, name = "FEE")
    private BigDecimal fee;
    /**
     * 自费
     */
    @XmlElement(required = false, name = "OWN_FEE")
    private BigDecimal ownFee;
    /**
     * 分类自负
     */
    @XmlElement(required = false, name = "CONCEIT_FEE")
    private BigDecimal conceitFee;
    /**
     * 扣除备注
     */
    @XmlElement(required = false, name = "REDUCE_REMARK")
    private String reduceRemark;
    /**
     * 手术编码
     */
    @XmlElement(required = false, name = "OPERAT_CODE")
    private String operatCode;
}
