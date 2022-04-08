package com.sy.world.entity.claim;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author liuhong
 * @date 2021/09/07
 * @description
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "APP_MSG")
public class ClaimAppMsgReq {

    /**
     * 个人任务号
     */
    @XmlElement(required = true, name = "TASK_NO")
    private String taskNo;

    /**
     * 申请途径
     */
    @XmlElement(required = true, name = "APP_SOURCE")
    private String appSource;

    /**
     * 自助申请来源
     */
    @XmlElement(required = true, name = "APP_CHANNEL")
    private String appChannel;

    /**
     * 申请机构
     */
    @XmlElement(required = true, name = "APP_COM")
    private String appCom;

    /**
     * 申请日期
     */
    @XmlElement(required = true, name = "CLM_APP_DATE")
    private String clmAppDAte;

    /**
     * 申请收件日期
     */
    @XmlElement(required = true, name = "APP_DATE")
    private String appDate;

    /**
     * 理赔申请受理决定
     */
    @XmlElement(required = true, name = "APP_CONCLUSION")
    private String appConclusion;

    /**
     * 不予受理原因
     */
    @XmlElement(required = true, name = "REJECT_CAUSE")
    private String rejectCause;

    /**
     * 其它原因说明
     */
    @XmlElement(required = false, name = "REJECT_DESC")
    private String rejectDesc;

    /**
     * 出险人客户号
     */
    @XmlElement(required = true, name = "PARTY_ID")
    private String partyId;

    /**
     * 出险人姓名
     */
    @XmlElement(required = true, name = "NAME")
    private String name;

    /**
     * 出险人性别
     */
    @XmlElement(required = true, name = "GENDER")
    private String gender;

    /**
     * 出险人出生日期
     */
    @XmlElement(required = true, name = "BIRTHDAY")
    private String birthday;

    /**
     * 出险人证件类型
     */
    @XmlElement(required = true, name = "ID_TYPE")
    private String idType;

    /**
     * 出险人证件号码
     */
    @XmlElement(required = true, name = "ID_NO")
    private String idNo;

    /**
     * 出险人证件有效期至
     */
    @XmlElement(required = false, name = "ID_EXPIRY_DATE")
    private String idExpiryDate;

    /**
     * 出险人证件有效期长期标示
     */
    @XmlElement(required = false, name = "ID_PERMANENT_FLAG")
    private String idPermanentFlag;

    /**
     * 绿色通道标示
     */
    @XmlElement(required = false, name = "GREEN_CHANNEL_FLAG")
    private String greenChannelFlag;

    /**
     * 是否退还发票标示
     */
    @XmlElement(required = false, name = "RETURN_RECEIPT_FLAG")
    private String returnReceiptFlag;

    /**
     * 索赔事项
     */
    @XmlElement(required = true, name = "CLAIM_LIST")
    private List<ClaimAppTypeReq> claimAppTypeReq;

    /**
     * 发票数据
     */
    @XmlElement(required = true, name = "INC_LIST")
    private List<ClaimAppIncListResp> claimAppIncListResps;
}
