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
public class ClaimAppRespBody {

    /**
     * 批次号
     */
    @XmlElement(required = true, name = "BATCH_NO")
    private String batchNo;
    /**
     * 处理流程
     */
    @XmlElement(required = true, name = "CLM_PROCESS")
    private String clmProcess;
    /**
     * 个人理赔申请数量
     */
    @XmlElement(required = true, name = "APP_NUMS")
    private String appNums;
    /**
     * 文件包的名字
     */
    @XmlElement(required = true, name = "ZIP_NAME")
    private String zipName;
    /**
     * 任务数
     */
    @XmlElement(required = true, name = "TASK_NUMS")
    private String taskNums;
    /**
     * 影像件集合
     */
    @XmlElement(required = true, name = "IMG_LIST")
    private ClaimAppImgMsgListResp imgList;
    /**
     * 案件信息
     */
    @XmlElement(required = true, name = "APP_LIST")
    private ClaimAppListResp appList;
}
