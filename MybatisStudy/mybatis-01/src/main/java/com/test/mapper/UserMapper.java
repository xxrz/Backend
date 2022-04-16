package com.test.mapper;

import com.test.pojo.User;

import java.util.List;

public interface UserMapper {
    //查询全部用户
    List<User> getUserList();

    //根据ID查询用户
    User getUserById(int id);

    //添加用户
    void addUser(User user);

    //修改
    void updateUser(User user);

    //删除
    void deleteUser(int id);
}
