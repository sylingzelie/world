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
public class ClaimAppImagePageMsgResp {

    /**
     * 影像件路径
     */
    @XmlElement(required = true, name = "PAGE_PATH")
    private String pagePath;

    /**
     * 影像件序号
     */
    @XmlElement(required = true, name = "PAGE_NO")
    private Integer pageNo;

    /**
     * 影像件名称
     */
    @XmlElement(required = true, name = "PAGE_NAME")
    private String pageName;
}