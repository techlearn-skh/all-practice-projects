package com.skh;

public class Worker {
    String workerName;
    Integer workerId;
    Boolean isPermenentWorker;
    Boolean gender;

    WorkerAddress workerAddress;
    WorkerFamilyDetails workerFamilyDetails;

    public WorkerFamilyDetails getWorkerFamilyDetails() {
        return workerFamilyDetails;
    }

    public void setWorkerFamilyDetails(WorkerFamilyDetails workerFamilyDetails) {
        this.workerFamilyDetails = workerFamilyDetails;
    }

    public WorkerAddress getWorkerAddress() {
        return workerAddress;
    }

    public void setWorkerAddress(WorkerAddress workerAddress) {
        this.workerAddress = workerAddress;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Boolean getPermenentWorker() {
        return isPermenentWorker;
    }

    public void setPermenentWorker(Boolean permenentWorker) {
        isPermenentWorker = permenentWorker;
    }

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "workerName='" + workerName + '\'' +
                ", workerId=" + workerId +
                ", isPermenentWorker=" + isPermenentWorker +
                ", gender=" + gender +
                ", workerAddress=" + workerAddress +
                ", workerFamilyDetails=" + workerFamilyDetails +
                '}';
    }
}
