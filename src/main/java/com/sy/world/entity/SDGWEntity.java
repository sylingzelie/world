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
public class SDGWEntity {

    @ExcelProperty(value = "身份证")
    private String certId;
    @ExcelProperty(value = "余额")
    private String quota;

}
