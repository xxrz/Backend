package com.JAVASE;

public class TestLoader {
    public static void main(String[] args) throws ClassNotFoundException {
        //获得系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获得系统类加载器的父类加载器--》扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        //获取扩展类加载器的父类加载器--》根加载器
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        //测试当前类是哪个加载器加载的
        ClassLoader classLoader = Class.forName("com.JAVASE.TestLoader").getClassLoader();
        System.out.println(classLoader);

        //测试jDK内置的类是谁加载的
        classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader);

        //如何获得系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));

        //双亲委派机制:存在原来的包会用原来的包
            //java.lang.String
    }
}
