package com.JAVASE;

public class TestClassLoad {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);

        /*
        1. 加载到内存，会产生一个类对应Class对象
        2. 链接，链接结束后m = 0（默认值）
        3. 初始化
            <clinit>(){
                System.out.println("A类静态代码块初始化");
                m = 300;
                m = 100;
            }

             m = 100;
        */
    }
}

class A{
    //静态代码在类的初始化阶段被初始化
    //非静态代码在类的使用阶段被初始化
    //静态方法在内存中只有一份
    static{
        System.out.println("A类静态代码块初始化");
        m = 300;
    }
    static int m = 100;

    public A(){
        System.out.println("A类无参构造初始化");
    }
}
