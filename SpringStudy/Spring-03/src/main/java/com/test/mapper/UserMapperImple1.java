package com.test.mapper;

import com.test.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

// 4。创建执行sql的对象及执行
public class UserMapperImple1 extends SqlSessionDaoSupport implements UserMapper {
    private User user;
    private int id = 4;

    public List<User> getUserList(){
        user = new User(id,"小明","123456");
        UserMapper mapper = getSqlSession().getMapper(UserMapper.class);
        mapper.addUser(user);
        mapper.deleteUser(2);
        return mapper.getUserList();

    }

    @Override
    public int addUser(User user) {
        UserMapper mapper = getSqlSession().getMapper(UserMapper.class);
        return mapper.addUser(user);
    }

    @Override
    public int deleteUser(int id) {
        UserMapper mapper = getSqlSession().getMapper(UserMapper.class);
        return mapper.deleteUser(id);
    }
}

