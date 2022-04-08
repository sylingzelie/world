package com.sy.world.entity.claim;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author liuhong
 * @date 2021/09/07
 * @description 理赔申请信息
 */
@Data
@XmlRootElement(name = "REQUEST")
@XmlAccessorType(XmlAccessType.FIELD)
public class ClaimAppRequest {

    @XmlElement(required = true, name = "HEAD")
    private ClaimAppHeadReq claimAppHeadReq;

    @XmlElement(required = true, name = "BODY")
    private ClaimAppBodyReq claimAppBodyReq;

}
