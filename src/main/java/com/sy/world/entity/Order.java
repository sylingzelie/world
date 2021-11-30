package com.sy.world.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "订单")
public class Order {
    @ApiModelProperty(value = "编号")
    private String number;
}