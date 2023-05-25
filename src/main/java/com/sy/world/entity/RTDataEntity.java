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
public class RTDataEntity {

    @ExcelProperty(value = "changeCode")
    private String changeCode;
    @ExcelProperty(value = "billCode")
    private String billCode;
    @ExcelProperty(value = "type")
    private String type;
    @ExcelProperty(value = "amtBefore")
    private Integer amtBefore;
    @ExcelProperty(value = "amt")
    private Integer amt;

}
