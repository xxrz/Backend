package com.JDBC.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    //用了配置文件
    private static String dirver = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;

    static {
        try{
//            InputStream in = JDBCUtils.class.getClassLoader().getResourceAsStream("/db.properties");
            InputStream in = JDBCUtils.class.getResourceAsStream("/db.properties");
            Properties properties = new Properties();
            properties.load(in);

            dirver = properties.getProperty("diver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");

            //1.驱动只加载一次
            Class.forName(dirver);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获取链接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

    //释放
    public static void releaseR(Connection conn, Statement st, ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(st!=null){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

