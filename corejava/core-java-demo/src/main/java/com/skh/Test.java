package com.skh;

public class Test {
    public static void main(String[] args) {
        try {
            //creating an exception
            NumberFormatException ex = new NumberFormatException("Exception");
            //setting a cause of the exception
            ex.initCause(new NullPointerException("user sents either string or alpha numeric value"));
            throw ex;
        } catch (NumberFormatException ex) {
            // System.out.println(ex);     //displaying the exception
            System.out.println(ex.getCause());    //getting the actual cause of the exception
        }
    }
}



