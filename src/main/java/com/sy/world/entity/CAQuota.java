package com.sy.world.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class CAQuota {

    @ExcelProperty(value = "姓名")
    private String name;

    @ExcelProperty(value = "身份证")
    private String certId;

    @ExcelProperty(value = "保单")
    private String slipCode;

    @ExcelProperty(value = "初始额度")
    private String oo;

    @ExcelProperty(value = "普康初始额度")
    private String orgAmt;
}
