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
public class Change {

    @ExcelProperty(value = "changed_account_code")
    private String changedAccountCode;
    @ExcelProperty(value = "change_code")
    private String changeCode;
    @ExcelProperty(value = "change_bill_type")
    private String changeBillType;
    @ExcelProperty(value = "change_type")
    private String changeType;
    @ExcelProperty(value = "changed_amt_before")
    private String changedAmtBefore;
    @ExcelProperty(value = "changed_amt")
    private String changedAmt;
    @ExcelProperty(value = "changed_locked_amt_before")
    private String changedLockedAmtBefore;
    @ExcelProperty(value = "changed_locked_amt")
    private String changedLockedAmt;
    @ExcelProperty(value = "change_status")
    private String changeStatus;
    @ExcelProperty(value = "data_source")
    private String dataSource;
    @ExcelProperty(value = "changed_deleted")
    private String changedDeleted;
    @ExcelProperty(value = "is_deleted")
    private String isDeleted;
    @ExcelProperty(value = "create_by")
    private String createBy;
    @ExcelProperty(value = "create_time")
    private String createTime;
    @ExcelProperty(value = "update_by")
    private String updateBy;
    @ExcelProperty(value = "update_time")
    private String updateTime;
    @ExcelProperty(value = "remark")
    private String remark;


}
