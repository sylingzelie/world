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
public class ClaimImageMsgReq {

    /**
     * 任务号（或批次号
     */
    @XmlElement(required = true, name = "TASK_NO")
    private String taskNo;

    /**
     * 受理机构/扫描机构
     */
    @XmlElement(required = false, name = "SCAN_COM")
    private String scanCom;

    /**
     * 资料类型
     */
    @XmlElement(required = true, name = "IMG_TYPE")
    private String imageType;

    /**
     * 资料属性
     */
    @XmlElement(required = false, name = "MTRL_PROP")
    private String mtrlProp;

    /**
     * 扫描时间
     */
    @XmlElement(required = true, name = "SCAN_DATE")
    private String scanDate;

    /**
     * 影像件个数
     */
    @XmlElement(required = true, name = "PAGE_COUNT")
    private Integer pageCount;

    @XmlElement(required = true, name = "PAGE_LIST")
    private ClaimImagePageListReq imagePageList;
}
