package com.test.utils;

//sqlSessionFactiory
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            // 1.第3步中数据库配置文件的路径
            String resource = "Mybatis-config.xml";
            // 2.以数据流的形式获取到内容
            InputStream inputStream = Resources.getResourceAsStream(resource);
            // 3.从XML配置文件构建SqlSessionFactory实例用于执行sql语句
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 4. 获得处理sql语句的对象SqlSession
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
}

