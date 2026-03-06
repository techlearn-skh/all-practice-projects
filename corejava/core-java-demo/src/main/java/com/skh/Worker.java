package com.skh;

public class Worker implements Comparable<Worker>{

    private String wName;
    private Integer wId;
    private String wAddress;

    public Worker() {

    }

    public Worker(String wName, Integer wId, String wAddress) {
        this.wName = wName;
        this.wId = wId;
        this.wAddress = wAddress;
    }

    public String getwName() {
        return wName;
    }

    public void setwName(String wName) {
        this.wName = wName;
    }

    public Integer getwId() {
        return wId;
    }

    public void setwId(Integer wId) {
        this.wId = wId;
    }

    public String getwAddress() {
        return wAddress;
    }

    public void setwAddress(String wAddress) {
        this.wAddress = wAddress;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "wName='" + wName + '\'' +
                ", wId=" + wId +
                ", wAddress='" + wAddress + '\'' +
                '}';
    }

    @Override
    public int compareTo(Worker o) {
        return this.getwId() - o.getwId();
    }
}
