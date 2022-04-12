package com.JDBC;

import com.JDBC.utils.JDBCUtils1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC2 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils1.getConnection();
            st = conn.createStatement();
            String sql = "insert into users(id, `NAME`,`PASSWORD`,`email`,`birthday`)\n" +
                    "values (4,'xrz','111','1452419750@qq.com','1997-11-28')";
            int i = st.executeUpdate(sql);
            if(i>0){
                System.out.println("插入成功！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils1.releaseR(conn,st,rs);
        }
    }
}
