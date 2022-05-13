package com.test.dao;

import com.test.pojo.Books;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

// 4. UserMapper的实现类:用sqlSessionTemplate执行sql语句
//public class UserMapperImple implements UserMapper {
//    private SqlSessionTemplate sqlSessionTemplate;
//
//    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
//        this.sqlSessionTemplate = sqlSessionTemplate;
//    }
//
//    public List<User> getUserList(){
//        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
//        return mapper.getUserList();
//    }
//}

public class BookMapperImpl extends SqlSessionDaoSupport implements BookMapper{


    @Override
    public int addBook(Books books) {
        return 0;
    }

    @Override
    public int deleteBookById(int id) {
        return 0;
    }

    @Override
    public int updateBook(Books books) {
        return 0;
    }

    @Override
    public Books queryBookById(int id) {
        return null;
    }

    @Override
    public List<Books> queryAllBook() {
        return null;
    }
}
