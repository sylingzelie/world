package com.sy.world.entity.claim;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * @author liuhong
 * @date 2021/09/07
 * @description
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ClaimAppListReq {

    @XmlElement(required = true,name="APP_MSG")
    private List<ClaimAppMsgReq> appMsgList;

}
