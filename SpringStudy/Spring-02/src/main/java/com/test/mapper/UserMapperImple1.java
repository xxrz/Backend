package com.test.mapper;

import com.test.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserMapperImple1 extends SqlSessionDaoSupport implements UserMapper {
    public List<User> getUserList(){
        UserMapper mapper = getSqlSession().getMapper(UserMapper.class);
        return mapper.getUserList();
    }
}
