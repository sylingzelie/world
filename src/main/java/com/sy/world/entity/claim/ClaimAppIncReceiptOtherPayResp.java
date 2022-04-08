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
public class ClaimAppIncReceiptOtherPayResp {

    /**
     * 支付流水号
     */
    @XmlElement(required = true, name = "FEE_ID")
    private String feeId;
    /**
     * 第三方类型
     */
    @XmlElement(required = true, name = "TYPE")
    private String type;
    /**
     * 第三方名称
     */
    @XmlElement(required = true, name = "NAME")
    private String name;
    /**
     * 支付金额
     */
    @XmlElement(required = true, name = "FEE")
    private BigDecimal fee;
}
