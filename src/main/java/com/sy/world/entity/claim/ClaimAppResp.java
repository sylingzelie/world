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
public class ClaimAppResp {

    /**
     * 个人任务号
     */
    @XmlElement(required = true, name = "TASK_NO")
    private String taskNo;
    /**
     * 受理结论
     */
    @XmlElement(required = true, name = "APP_CONCLUSION")
    private String appConclusion;
    /**
     * 不予受理原因
     */
    @XmlElement(required = true, name = "REJECT_CAUSE")
    private String rejectCause;
    /**
     * 不予受理原因明细
     */
    @XmlElement(required = true, name = "REJECT_DESC")
    private String rejectDesc;
    /**
     * 事件数量
     */
    @XmlElement(required = true, name = "INC_NUMS")
    private String incNums;
    /**
     * 事件集合
     */
    @XmlElement(required = true, name = "INC_LIST")
    private ClaimAppIncListResp incList;
    /**
     * 赔案集合
     */
    @XmlElement(required = true, name = "CASE_LIST")
    private ClaimAppCaseListResp caseList;
}
