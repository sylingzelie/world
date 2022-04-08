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
public class ClaimCaseAccResultResp {

    /**
     * 账户号
     */
    @XmlElement(required = true,name="ACC_NO")
    private String accNo;
    /**
     * 账户类型
     */
    @XmlElement(required = true,name="ACC_TYPE")
    private String accType;

    /**
     * 理算金额
     */
    @XmlElement(required = true,name="ACC_CAL_AMOUNT")
    private String accCalAmount;

    /**
     * 赔付金额
     */
    @XmlElement(required = true,name="ACC_PAY_AMOUNT")
    private String accPayAmount;
}
