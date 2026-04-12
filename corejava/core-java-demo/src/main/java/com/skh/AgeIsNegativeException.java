package com.skh;

public class AgeIsNegativeException extends Exception {
    String errorMessage;
    public AgeIsNegativeException(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    @Override
    public String toString() {
        return "AgeIsNegativeException{" +
                "errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
