package com.test.mapper;

import com.test.pojo.User;
import com.test.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void test(){
        // 1.获取执行sql的对象sqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：gerMapper
//         2.获取并执行sql语句 方法：getMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();


        //方式二：
//        List<User> userList = sqlSession.selectList("com.test.mapper.UserMapper.getUserList");

        // 输出结果
        for (User user : userList) {
            System.out.println(user);
        }

        // 3.关闭sqlSession连接
        sqlSession.close();
    }
}
