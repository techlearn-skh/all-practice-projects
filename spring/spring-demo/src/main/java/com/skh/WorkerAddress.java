package com.skh;

public class WorkerAddress {

    String workerCity;
    String workerState;
    String workerCountry;
    Integer pincode;
    String phoneNumber;

    public String getWorkerCity() {
        return workerCity;
    }

    public void setWorkerCity(String workerCity) {
        this.workerCity = workerCity;
    }

    public String getWorkerState() {
        return workerState;
    }

    public void setWorkerState(String workerState) {
        this.workerState = workerState;
    }

    public String getWorkerCountry() {
        return workerCountry;
    }

    public void setWorkerCountry(String workerCountry) {
        this.workerCountry = workerCountry;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "WorkerAddress{" +
                "workerCity='" + workerCity + '\'' +
                ", workerState='" + workerState + '\'' +
                ", workerCountry='" + workerCountry + '\'' +
                ", pincode=" + pincode +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

}
