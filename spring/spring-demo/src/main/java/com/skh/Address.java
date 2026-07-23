package com.skh;


import org.springframework.stereotype.Component;

@Component
public class Address {

    private String state;
    private String country;

    public Address(){
        System.out.println("Constructor - "+ this.getClass().getName());
    }
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "state='" + state + '\'' +
                ", country=" + country +
                '}';
    }

    public void init(){
        System.out.println(this.getClass().getName()+" - "+"init()");
    }

    public void destroy(){
        System.out.println(this.getClass().getName()+" - "+"destroy()");
    }
}
