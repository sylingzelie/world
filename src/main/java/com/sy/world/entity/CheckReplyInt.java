/**
 * CheckReplyInt.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sy.world.entity;

public class CheckReplyInt implements java.io.Serializable {
    private String TKFlag;

    private String grpContNo;

    private Double restMoney;

    public CheckReplyInt() {
    }

    public CheckReplyInt(
           String TKFlag,
           String grpContNo,
           Double restMoney) {
           this.TKFlag = TKFlag;
           this.grpContNo = grpContNo;
           this.restMoney = restMoney;
    }


    /**
     * Gets the TKFlag value for this CheckReplyInt.
     *
     * @return TKFlag
     */
    public String getTKFlag() {
        return TKFlag;
    }


    /**
     * Sets the TKFlag value for this CheckReplyInt.
     *
     * @param TKFlag
     */
    public void setTKFlag(String TKFlag) {
        this.TKFlag = TKFlag;
    }


    /**
     * Gets the grpContNo value for this CheckReplyInt.
     *
     * @return grpContNo
     */
    public String getGrpContNo() {
        return grpContNo;
    }


    /**
     * Sets the grpContNo value for this CheckReplyInt.
     *
     * @param grpContNo
     */
    public void setGrpContNo(String grpContNo) {
        this.grpContNo = grpContNo;
    }


    /**
     * Gets the restMoney value for this CheckReplyInt.
     *
     * @return restMoney
     */
    public Double getRestMoney() {
        return restMoney;
    }


    /**
     * Sets the restMoney value for this CheckReplyInt.
     *
     * @param restMoney
     */
    public void setRestMoney(Double restMoney) {
        this.restMoney = restMoney;
    }

}
