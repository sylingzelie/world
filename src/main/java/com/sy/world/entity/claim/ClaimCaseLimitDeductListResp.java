package com.sy.world.entity.claim;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * @author liuhong
 * @date 2021/09/22
 * @description
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ClaimCaseLimitDeductListResp {

    @XmlElement(required = true, name = "LIMIT_DEDUCT_USED")
    private List<ClaimCaseLimitDeductResp> caseLimitDeductList;
}
