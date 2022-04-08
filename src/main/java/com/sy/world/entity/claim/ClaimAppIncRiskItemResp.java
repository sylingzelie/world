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
public class ClaimAppIncRiskItemResp {
    /**
     * 风险项
     */
    @XmlElement(required = true, name = "RISK_ITEM_CODE")
    private String riskItemCode;
    /**
     * 风险标识内容
     */
    @XmlElement(required = false, name = "RISK_FLAG_CONTENT")
    private String riskFlagContent;
}
