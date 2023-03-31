package com.sy.world.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("测试")
public class Person {

    @ApiModelProperty(value = "序号")
    @ExcelProperty(value = "序号")
    private Integer xuhao;

    @ApiModelProperty(value = "回合")
    @ExcelProperty(value = "回合")
    private Integer hh;

    @ApiModelProperty(value = "批改标志*")
    @ExcelProperty(value = "批改标志*")
    private Integer ss;

}
