package com.skh.models;

import java.util.Objects;

public class AddressVO {
    private String eCity;
    private String eState;
    private String eDisctrict;
    private String ePin;
    private String eStreetNo;

    public AddressVO() {

    }

    public AddressVO(String eCity, String eState, String eDisctrict, String ePin, String eStreetNo) {
        this.eCity = eCity;
        this.eState = eState;
        this.eDisctrict = eDisctrict;
        this.ePin = ePin;
        this.eStreetNo = eStreetNo;
    }

    public String geteDisctrict() {
        return eDisctrict;
    }

    public void seteDisctrict(String eDisctrict) {
        this.eDisctrict = eDisctrict;
    }

    public String geteCity() {
        return eCity;
    }

    public void seteCity(String eCity) {
        this.eCity = eCity;
    }

    public String geteState() {
        return eState;
    }

    public void seteState(String eState) {
        this.eState = eState;
    }

    public String getePin() {
        return ePin;
    }

    public void setePin(String ePin) {
        this.ePin = ePin;
    }

    public String geteStreetNo() {
        return eStreetNo;
    }

    public void seteStreetNo(String eStreetNo) {
        this.eStreetNo = eStreetNo;
    }

    @Override
    public String toString() {
        return "AddressVO{" +
                "eCity='" + eCity + '\'' +
                ", eState='" + eState + '\'' +
                ", eDisctrict='" + eDisctrict + '\'' +
                ", ePin='" + ePin + '\'' +
                ", eStreetNo='" + eStreetNo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AddressVO addressVO = (AddressVO) o;
        return Objects.equals(eCity, addressVO.eCity) && Objects.equals(eState, addressVO.eState) && Objects.equals(eDisctrict, addressVO.eDisctrict) && Objects.equals(ePin, addressVO.ePin) && Objects.equals(eStreetNo, addressVO.eStreetNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eCity, eState, eDisctrict, ePin, eStreetNo);
    }
}
