package com.test.mapper;

import com.test.pojo.User;
import com.test.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
//    @Test
//    public void test(){
//        // 1.获取执行sql的对象sqlSession
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//
//        //方式一：gerMapper
////         2.获取并执行sql语句 方法：getMapper
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        List<User> userList = mapper.getUserList();
//
//
//        //方式二：
////        List<User> userList = sqlSession.selectList("com.test.mapper.UserMapper.getUserList");
//
//        // 输出结果
//        for (User user : userList) {
//            System.out.println(user);
//        }
//
//        // 3.关闭sqlSession连接
//        sqlSession.close();
//    }

    @Test
    public void testUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user= mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void addUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(4, "dao","23");
        mapper.addUser(user);
        // 增删改要用事务提交
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(4, "comeon","23");
        mapper.updateUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(4);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getUserById1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("id",1);
        User user = mapper.getUserById1(map);
        System.out.println(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getUserLike() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> user = mapper.getUserLike("wang");
        System.out.print(user);
        sqlSession.close();
    }

    @Test
    public void getUserLimit() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("startIndex", 0);
        map.put("page", 2);
        List<User> userLimit = mapper.getUserLimit(map);
        for (User user : userLimit) {
            System.out.println(user);
        }
        sqlSession.close();
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

    @Test
    public void getById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getById(1);
        System.out.print(user);
        sqlSession.close();
    }


}
