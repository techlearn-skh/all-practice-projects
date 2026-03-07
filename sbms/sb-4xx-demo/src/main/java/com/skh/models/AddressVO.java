package com.skh.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;


@Data
@NoArgsConstructor
@ToString
public class AddressVO {
    private String eCity;
    private String eState;
    private String eDisctrict;
    private String ePin;
    private String eStreetNo;

    public AddressVO(String eCity, String eState, String eDisctrict, String ePin, String eStreetNo) {
        this.eCity = eCity;
        this.eState = eState;
        this.eDisctrict = eDisctrict;
        this.ePin = ePin;
        this.eStreetNo = eStreetNo;
    }
}
