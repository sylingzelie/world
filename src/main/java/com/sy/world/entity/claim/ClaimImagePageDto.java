package com.sy.world.entity.claim;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liuhong
 * @date 2021/09/07
 * @description
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ClaimImagePage对象", description="工银理赔影像件存储数据")
public class ClaimImagePageDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "影像件数据id,<FK>icbc_claim_image_msg.id")
    private Integer imageMsgId;

    @ApiModelProperty(value = "影像件路径(压缩包下的相对路径)")
    private String pagePath;

    @ApiModelProperty(value = "影像件序号")
    private String pageNo;

    @ApiModelProperty(value = "影像件名称")
    private String pageName;

    @ApiModelProperty(value = "oss对应的url")
    private String url;

    @ApiModelProperty(value = "状态|1:下载成功;2:下载失败;3:处理成功;4:处理失败")
    private Byte status;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "创建成功")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}
