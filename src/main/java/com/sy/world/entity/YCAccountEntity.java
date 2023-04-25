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
public class YCAccountEntity {

    @ExcelProperty(value = "编号")
    private String code;
    @ExcelProperty(value = "金额")
    private String amt;

}
