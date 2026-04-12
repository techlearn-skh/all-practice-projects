package com.skh;

public class InvalidWithdrawlMoneyException extends RuntimeException {
    String errorMessage;
    public InvalidWithdrawlMoneyException(String inputErrorMessage) {
        this.errorMessage = inputErrorMessage;
    }
    @Override
    public String toString() {
        return "InvalidWithdrawlMoneyException{" +
                "errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
