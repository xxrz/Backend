package com.test.mapper;

import com.test.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

// 4. UserMapper的实现类:用sqlSessionTemplate执行sql语句
public class UserMapperImple implements UserMapper {
    private SqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public List<User> getUserList(){
        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
        return mapper.getUserList();
    }
}
