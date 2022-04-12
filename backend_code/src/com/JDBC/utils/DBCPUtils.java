package com.JDBC.utils;

import org.apache.commons.dbcp.BasicDataSource;
import java.sql.*;

public class DBCPUtils {
    private static BasicDataSource bs;
    /**
     * 建立连接
     * @return
     */
    public static Connection getConnection(){
        if (bs == null) {
            // 创建dbcp核心类
            bs = new BasicDataSource();
            // 设置基础连接属性
            // 设置连接驱动类
            bs.setDriverClassName("com.mysql.jdbc.Driver");
            // 设置连接url
            bs.setUrl("jdbc:mysql://localhost:3306/bank");
            // 设置用户名
            bs.setUsername("root");
            // 设置密码
            bs.setPassword("141592");

            //设置初始化连接总数

            bs.setInitialSize(50);

            //设置同时应用的连接总数

            bs.setMaxActive(-1);

            //设置在缓冲池的最大连接数

            bs.setMaxIdle(-1);

            //设置在缓冲池的最小连接数
            bs.setMinIdle(0);
            //设置最长的等待时间
            bs.setMaxWait(-1);

        }
        try {
            //返回连接对象
            return bs.getConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 关闭连接池
     */
    public static void closeBS() {
        if(bs != null) {
            try {
                bs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
