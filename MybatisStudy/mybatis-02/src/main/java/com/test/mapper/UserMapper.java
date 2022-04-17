package com.test.mapper;

import com.test.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.Alias;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询全部用户
//    List<User> getUserList();

    //根据ID查询用户
    User getUserById(int id);

    //添加用户
    void addUser(User user);

    //修改
    void updateUser(User user);

    //删除
    void deleteUser(int id);

    User getUserById1(Map<String,Object> map);

    List<User> getUserLike(String values);

    List<User> getUserLimit(Map<String, Integer> map);

    // 1.对不同操作注解不同关键词，在（）中写入sql语句。
    @Select("select * from mybatis.user")
    List<User> getUserList();

    // 2.若sql语句中需要传参，sql中传入的参数用#{}表示
    // 接口的参数用 【@Param("数据库中字段名") 传入的数据类型 参数名】表示
    @Select("select * from mybatis.user where id = #{id}")
    User getById(@Param("id") int id);
}
