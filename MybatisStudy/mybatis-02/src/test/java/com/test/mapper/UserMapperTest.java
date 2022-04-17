package com.test.mapper;

import com.test.pojo.User;
import com.test.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

public class UserMapperTest {

    static Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void testLog4j(){
        logger.info("info:进入了testLog4j");
        logger.debug("debug:进入了testLog4j");
        logger.error("error:进入了testLog4j");
    }

    @Test
    public void getUserList(){
        // 1.获取执行sal的对象sqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 2.获取并执行sql语句 方法：getMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        // 输出结果
        for (User user : userList) {
            System.out.println(user);
        }

        // 3.关闭sqlSession连接
        sqlSession.close();
    }





}
