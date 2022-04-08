package com.sy.world.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "用户信息")
public class User{
    @ApiModelProperty(value = "用户信息")
    private String username;
    @ApiModelProperty(value = "用户信息")
    private Integer age;

}