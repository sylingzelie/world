package com.sy.world.entity.claim;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author liuhong
 * @date 2021/09/07
 * @description
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "CLAIM_LIST")
public class ClaimAppTypeReq {

    /**
     * 索赔事项
     */
    @XmlElement(required = true,name="CLAIM_TYPE")
    private String claimType;
}
