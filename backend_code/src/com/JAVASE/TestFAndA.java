package com.JAVASE;

import java.lang.annotation.*;
import java.lang.reflect.Field;

//练习反射操作注解
public class TestFAndA {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("com.JAVASE.Student");

        //通过反射获得注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        
        //获得注解的value的值
        Table table = (Table)c1.getAnnotation(Table.class);
        String value = table.value();
        System.out.println(value);
        
        //获得类指定的注解
        Field f = c1.getDeclaredField("name");
        FieldTable annotation = f.getAnnotation(FieldTable.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());
    }
}

@Table("db_stu")
class Student{

    @FieldTable(columnName = "db_id",type="int",length=10)
    private int id;
    @FieldTable(columnName = "db_age",type="int",length=10)
    private int age;
    @FieldTable(columnName = "db_name",type="int",length=3)
    private String name;

    public Student() {
    }

    public Student(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Table{
    String value();
}

//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldTable{
    String columnName();
    String type();
    int length();

}
