package com.JAVASE;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestObject {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //获得class对象
        Class c1 = Class.forName("com.JAVASE.User");

        //构造一个对象
        User user = (User)c1.newInstance(); //本质调用了类的无参构造器
        System.out.println(user);

        //通过构造器创建对象,有参数通过这种方式进行创建
        Constructor declaredConstructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User user2 = (User)declaredConstructor.newInstance("xrz",001,18);
        System.out.println(user2);

        //通过反射调用普通方法
        User user3 = (User)c1.newInstance();
        //通过反射获取方法
        Method setName = c1.getDeclaredMethod("setName", String.class);
        //激活(对象，方法的值)
        setName.invoke(user3,"xrz");
        System.out.println(user3.getName());

        //通过反射操作属性
        //这样方法获取不到，权限不够，因为name是private
//        User user4 = (User)c1.newInstance();
//        Field name = c1.getDeclaredField("name");
//        name.set(user4,"xrz2");
//        System.out.println(user4.getName());

        //取消安全检测就可以访问私有属性
        User user5 = (User)c1.newInstance();
        Field name5 = c1.getDeclaredField("name");
        name5.setAccessible(true);
        name5.set(user5,"xrz2");
        System.out.println(user5.getName());
    }
}
