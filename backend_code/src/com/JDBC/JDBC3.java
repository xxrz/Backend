package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC3 {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        PreparedStatement preStatement = null;
        try {
            // 1. 加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 2. 输入用户信息和数据库url
            String url = "jdbc:mysql://localhost:3306/bank?useUnicode=true&characterEncoding=utf8&useSSl=true";
            String username = "root";
            String password = "111";

            // 3. 连接成功后，创建执行数据库的对象connection
            connection = DriverManager.getConnection(url, username, password);

            //写事务
            // 4. 关闭自动提交，自动开启事务
            connection.setAutoCommit(false);

            String sql1 = "update account set money = money-500 where `name`='A';";
            preStatement = connection.prepareStatement(sql1);  // 预编译sql
            preStatement.executeUpdate();

//            int i = 1/0;  // 验证回滚

            String sql2 = "update account set money = money + 500 where `name`='B';";
            preStatement = connection.prepareStatement(sql2);  // 预编译sql
            preStatement.executeUpdate();

            // 5. 业务完毕，提交事务
            connection.commit();
            System.out.println("成功！");

        } catch (Exception e) {
            // 或者出错，回滚
            connection.rollback();
            System.out.println("失败！");
        } finally {
            // 6. 释放所有已创建对象的连接
            preStatement.close();
            connection.close();
        }
    }
}
