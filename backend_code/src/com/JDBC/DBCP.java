package com.JDBC;
import com.JDBC.utils.DBCPUtils;

import java.sql.*;

public class DBCP {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        Connection connection = DBCPUtils.getConnection();
        Statement statement = connection.createStatement();

        String sql = "SELECT * FROM account";
        ResultSet resultSet = statement.executeQuery(sql);  // resultSet返回的查询结果（链表）

        while (resultSet.next()){
            System.out.println("name:" + resultSet.getObject("name"));
            System.out.println("money:" + resultSet.getObject("money"));
            System.out.println("-----------------------------------");
        }

        DBCPUtils.closeBS();
    }
}
