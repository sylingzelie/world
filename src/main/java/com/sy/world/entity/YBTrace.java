/**
 * DeleteBatchInt.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sy.world.entity;


public class YBTrace implements java.io.Serializable {

    private String tGrpContNo;

    private String tContNo;

    private String tTraceType;

    private String tRestMoney;

    private String tMakeDate;

    private String tMakeTime;

    private String errorRemark;

    public YBTrace() {
    }

    public YBTrace(
            String tGrpContNo,
            String tContNo,
            String tTraceType,
            String tRestMoney,
            String tMakeDate,
            String tMakeTime,
            String errorRemark) {
        this.tGrpContNo = tGrpContNo;
        this.tContNo = tContNo;
        this.tTraceType = tTraceType;
        this.tRestMoney = tRestMoney;
        this.tMakeDate = tMakeDate;
        this.tMakeTime = tMakeTime;
        this.errorRemark = errorRemark;
    }

    public String gettGrpContNo() {
        return tGrpContNo;
    }

    public void settGrpContNo(String tGrpContNo) {
        this.tGrpContNo = tGrpContNo;
    }

    public String gettContNo() {
        return tContNo;
    }

    public void settContNo(String tContNo) {
        this.tContNo = tContNo;
    }

    public String gettTraceType() {
        return tTraceType;
    }

    public void settTraceType(String tTraceType) {
        this.tTraceType = tTraceType;
    }

    public String gettRestMoney() {
        return tRestMoney;
    }

    public void settRestMoney(String tRestMoney) {
        this.tRestMoney = tRestMoney;
    }

    public String gettMakeDate() {
        return tMakeDate;
    }

    public void settMakeDate(String tMakeDate) {
        this.tMakeDate = tMakeDate;
    }

    public String gettMakeTime() {
        return tMakeTime;
    }

    public void settMakeTime(String tMakeTime) {
        this.tMakeTime = tMakeTime;
    }

    public String getErrorRemark() {
        return errorRemark;
    }

    public void setErrorRemark(String errorRemark) {
        this.errorRemark = errorRemark;
    }
}
