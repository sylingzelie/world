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
public class CajjOrder {

    @ExcelProperty(value = "cardCode")
    private String cardCode;

    @ExcelProperty(value = "merchantId")
    private String merchantId;

    @ExcelProperty(value = "shopId")
    private String shopId;

    @ExcelProperty(value = "transRrn")
    private String transRrn;

    @ExcelProperty(value = "transId")
    private String transId;

    @ExcelProperty(value = "transDatetime")
    private String transDatetime;

    @ExcelProperty(value = "transCatpchaCode")
    private String transCatpchaCode;

    @ExcelProperty(value = "transValidateType")
    private Integer transValidateType;

    @ExcelProperty(value = "transAmt")
    private String transAmt;

    @ExcelProperty(value = "merchantProductGroupId")
    private String merchantProductGroupId;

    @ExcelProperty(value = "cardBindMobile")
    private String cardBindMobile;

    @ExcelProperty(value = "personCertId")
    private String personCertId;
}
