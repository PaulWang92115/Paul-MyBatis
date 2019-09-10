package com.paul.mybatis.mapper;

import com.paul.mybatis.entity.User;

import java.util.List;

public interface UserMapper {

    User selectByPrimaryKey(long userId);

    List<User> selectAll();
}
