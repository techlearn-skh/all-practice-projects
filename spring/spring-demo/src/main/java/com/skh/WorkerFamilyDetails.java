package com.skh;

public class WorkerFamilyDetails {

    String personalEmail;
    String officialEmail;
    Boolean ismarried;
    String spouseName;
    String fatherName;
    String motherName;
    Integer noOfChildren;

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public String getOfficialEmail() {
        return officialEmail;
    }

    public void setOfficialEmail(String officialEmail) {
        this.officialEmail = officialEmail;
    }

    public Boolean getIsmarried() {
        return ismarried;
    }

    public void setIsmarried(Boolean ismarried) {
        this.ismarried = ismarried;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public Integer getNoOfChildren() {
        return noOfChildren;
    }

    public void setNoOfChildren(Integer noOfChildren) {
        this.noOfChildren = noOfChildren;
    }

    @Override
    public String toString() {
        return "WorkerFamilyDetails{" +
                "personalEmail='" + personalEmail + '\'' +
                ", officialEmail='" + officialEmail + '\'' +
                ", ismarried=" + ismarried +
                ", spouseName='" + spouseName + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", noOfChildren=" + noOfChildren +
                '}';
    }

}
