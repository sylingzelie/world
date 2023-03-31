/**
 * DeleteBatchInt.java
 * <p>
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sy.world.entity;

import lombok.Data;

@Data
public class YBQueryTrace implements java.io.Serializable {

    private String CertifyCode;

    private String tGrpContNo;

    private String tContNo;

    private String tBeginDate;

    private String tEndDate;


    public YBQueryTrace() {
    }

    public YBQueryTrace(
            String CertifyCode,
            String tGrpContNo,
            String tContNo,
            String tBeginDate,
            String tEndDate) {
            this.CertifyCode = CertifyCode;
            this.tGrpContNo = tGrpContNo;
            this.tContNo = tContNo;
            this.tBeginDate = tBeginDate;
            this.tEndDate = tEndDate;
    }

}
