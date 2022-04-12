package com.JDBC;

import java.sql.*;

// 第一个jdbc程序
public class JDBC1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. 加载数据库驱动
        //正常写法，但有点多余
//        DriverManager.registerDriver((new com.mysql.jdbc.Driver()));
        Class.forName("com.mysql.jdbc.Driver");

        // 2. 输入用户信息和数据库url
        // mysql -- 默认端口3306
        // 协议：jdbc:mysql//主机地址:端口号/数据库名?参数1&参数2&参数3

        // jdbcstudy:要操作的数据库名称。
        // ?：连接参数。
        // useUnicode=true：支持中文编码
        // characterEncoding=utf8：设置字符编码集
        // useSSl=true：设定SSL安全传输机制
        String url = "jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&useSSl=true";
        String username = "root";
        String password = "141592";


        // 3. 连接成功后，创建执行数据库的对象connection（可查看表的信息，设置事务提交等）
        //代表数据库
        Connection connection = DriverManager.getConnection(url, username, password);

        // 4. 创建执行SQL的对象statement
        //代表执行sql的对象
        Statement statement = connection.createStatement();
//        //可执行的操作
//        //查询操作 返回resultset
//        statement.executeQuery();
//        //执行任何sql
//        statement.execute();
//        //更新、插入、删除。返回一个受影响的行数
//        statement.executeUpdate();
//        //执行一组sql
//        statement.executeBatch();

        // 5. 编写SQL语句，让执行SQL的对象去执行该语句
        String sql = "SELECT * FROM users";
        ResultSet resultSet = statement.executeQuery(sql);  // resultSet返回的查询结果（链表）
//        int num = statement.executeUpdate(sql); // 增删改用该语句，返回表中改变的行数。
////        封装了所有的结果
//        resultSet.getObject(); //不知道列类型的情况下
//        resultSet.getString();
//        resultSet.getInt();
//        resultSet.getFloat();
//        resultSet.getDouble();

//        //遍历
//        resultSet.beforeFirst(); //移动到最前面
//        resultSet.afterLast(); //移动到最后面
//        resultSet.next();//移动到下一个数据
//        resultSet.previous();//移动到前一行
//        resultSet.absolute();//移动到指定行

        while (resultSet.next()){
            System.out.println("id:" + resultSet.getObject("id")); // 在不知道列类型的情况下获得使用object
            System.out.println("name:" + resultSet.getObject("NAME"));
            System.out.println("password:" + resultSet.getObject("PASSWORD"));
            System.out.println("email:" + resultSet.getObject("email"));
            System.out.println("birthday:" + resultSet.getObject("birthday"));
            System.out.println("-----------------------------------");
        }

        // 6. 释放所有已创建对象的连接.(先创建的对象后释放)
        resultSet.close();
        statement.close();
        connection.close();
    }
}

