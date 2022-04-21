package com.test.mapper;

import com.test.pojo.User;

import java.util.List;

public interface UserMapper {

    List<User> getUserList();

    //添加一个用户
    int addUser(User user);

    //根据id删除用户
    int deleteUser(int id);
}
