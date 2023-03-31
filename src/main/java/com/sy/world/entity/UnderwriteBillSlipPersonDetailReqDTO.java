package com.sy.world.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 承保人员详情表
 *
 * @author RichardTy
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@HeadRowHeight(value = 2)
public class UnderwriteBillSlipPersonDetailReqDTO implements Serializable {

    private static final long serialVersionUID = 1L;


    @ExcelProperty(value = "序号")
    private String personNo;

    @ExcelProperty(value = "zz")
    private String x;

    @ExcelProperty(value = "被保险人姓名*")
    private String personName;

    @ExcelProperty(value = "证件类型*")
    private String certificatesType;

    @ExcelProperty(value = "证件号码*")
    private String certificatesNo;

    @ExcelProperty(value = "出生日期*（YYYY-MM-dd）")
    private String birthdayString;

    @ExcelProperty(value = "被保险人性别*")
    private String sex;

    @ExcelProperty(value = "被保险人类别*")
    private String personType;

    @ExcelProperty(value = "与主被保险人关系\n" +
            "(附属被保险人必录)*")
    private String relation;

    @ExcelProperty(value = "对应主被保险人序号(附属被保险人必录)*")
    private String mainPersonNo;

    @ExcelProperty(value = "个人账户额度*")
    private String personQuota;


    private String rowIndex;




}
