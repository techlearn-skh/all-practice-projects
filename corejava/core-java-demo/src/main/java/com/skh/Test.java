package com.skh;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Test {





    String empName;

    public static void main(String[] args) {
//        String encode = URLEncoder.encode("|Kamal#shaik|", Charset.defaultCharset());
        String encode = URLEncoder.encode("|Kamal#shaik|", Charset.defaultCharset());
        System.out.println(encode);

        String decode = URLDecoder.decode(encode, Charset.defaultCharset());
        System.out.println(decode);
        for (int i = 0; i < 100; i++) {
            new Test();
        }





    }
    void printStudentName(ArrayList<String> studetNames){
        for (String name: studetNames){
            System.out.println(name);
        }
    }

    public static void m1(String name, Integer id){
        System.out.println("Name: " + name + ", ID: " + id);

    }

    public  void m2(String name, Integer Id){

    }


}


