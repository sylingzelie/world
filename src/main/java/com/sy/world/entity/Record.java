package com.sy.world.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class Record {

    @ExcelProperty(value = "policy_no")
    private String policyNo;

    @ExcelProperty(value = "person_no")
    private String personNo;

    @ExcelProperty(value = "changed_amt_before")
    private String changedAmtBefore;

    @ExcelProperty(value = "changed_amt")
    private String changedAmt;

    @ExcelProperty(value = "changed_locked_amt_before")
    private String changed_locked_amt_before;
    @ExcelProperty(value = "changed_locked_amt")
    private String changed_locked_amt;
    @ExcelProperty(value = "change_bill_type")
    private String change_bill_type;
    @ExcelProperty(value = "change_type")
    private String change_type;

    @ExcelProperty(value = "create_time")
    private Date createTime;

    @ExcelProperty(value = "id")
    private String id;

    @ExcelProperty(value = "claim_referenceCode")
    private String claimReferenceCode;

    @ExcelProperty(value = "data_source")
    private String source;

    @ExcelProperty(value = "remark")
    private String remark;

}
