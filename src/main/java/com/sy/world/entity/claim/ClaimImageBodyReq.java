package com.sy.world.entity.claim;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author liuhong
 * @date 2021/09/07
 * @description
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ClaimImageBodyReq {

    /**
     * 文件包的名字
     */
    @XmlElement(required = true, name = "ZIP_NAME")
    private String zipName;

    /**
     * 个人影像件信息
     */
    @XmlElement(required = true, name = "IMG_LIST")
    private ClaimImageListReq imageList;
}
