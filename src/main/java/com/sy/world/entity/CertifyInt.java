/**
 * CertifyInt.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sy.world.entity;

public class CertifyInt implements java.io.Serializable {
    private String cardPassword;

    private String medCardNo;

    public CertifyInt() {
    }

    public CertifyInt(
           String cardPassword,
           String medCardNo) {
           this.cardPassword = cardPassword;
           this.medCardNo = medCardNo;
    }


    /**
     * Gets the cardPassword value for this CertifyInt.
     *
     * @return cardPassword
     */
    public String getCardPassword() {
        return cardPassword;
    }


    /**
     * Sets the cardPassword value for this CertifyInt.
     *
     * @param cardPassword
     */
    public void setCardPassword(String cardPassword) {
        this.cardPassword = cardPassword;
    }


    /**
     * Gets the medCardNo value for this CertifyInt.
     *
     * @return medCardNo
     */
    public String getMedCardNo() {
        return medCardNo;
    }


    /**
     * Sets the medCardNo value for this CertifyInt.
     *
     * @param medCardNo
     */
    public void setMedCardNo(String medCardNo) {
        this.medCardNo = medCardNo;
    }

}
