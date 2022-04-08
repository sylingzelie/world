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
public class ClaimCaseLimitDeductResp {

    /**
     * 限额免赔额标记
     */
    @XmlElement(required = true, name = "LIMIT_DEDUCT_FLAG")
    private String limitDeductFlag;
    /**
     * 限额/免赔额类型
     */
    @XmlElement(required = true, name = "LIMIT_DEDUCT_USED_TYPE")
    private String limitDeductUsedType;
    /**
     * 限额/免赔额本次使用金额
     */
    @XmlElement(required = true, name = "LIMIT_DEDUCT_USED_VALUE")
    private BigDecimal limitDeductUsedValue;

}
