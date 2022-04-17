package com.test.utils;



import java.util.UUID;

public class IDUtils {
    public static String genId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }


    public static void main(String[] args) {
        System.out.println(IDUtils.genId());
        System.out.println(IDUtils.genId());
        System.out.println(IDUtils.genId());
        System.out.println(IDUtils.genId());
        System.out.println(IDUtils.genId());
    }
}
