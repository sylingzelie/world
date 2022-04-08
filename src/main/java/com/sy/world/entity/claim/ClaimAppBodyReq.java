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
public class ClaimAppBodyReq {

    /**
     * 批次号
     */
    @XmlElement(required = true,name="BATCH_NO")
    private String batchNo;

    /**
     * 处理流程
     */
    @XmlElement(required = true,name="CLM_PROCESS")
    private String clmProcess;

    /**
     * 压缩包名称
     */
    @XmlElement(required = true,name="ZIP_NAME")
    private String zipName;

    /**
     * 影像件信息
     */
    @XmlElement(required = true,name="IMG_LIST")
    private ClaimImageListReq imageList;

    /**
     * 个人理赔信息
     */
    @XmlElement(required = true,name="APP_LIST")
    private ClaimAppListReq appList;



}
