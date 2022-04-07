package com.JAVASE;

public class TestInit {
    static{
        System.out.println("main类被加载");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //1. new主动引用
//        Son son = new Son();

        //反射产生的主动引用
//        Class.forName("com.JAVASE.Son");

        //不会产生类的引用的方法(main father)
//        System.out.println(Son.b);
        //(main)
//        Son[] array = new Son[5];
        //(main)
        System.out.println(Son.M);
    }
}

class Father{
    static int b = 2;
    static{
        System.out.println("父类被加载");
    }
}

class Son extends Father{
    static {
        System.out.println("子类被加载");
        m = 300;
    }

    static int m = 100;
    static final int M = 1;
}
