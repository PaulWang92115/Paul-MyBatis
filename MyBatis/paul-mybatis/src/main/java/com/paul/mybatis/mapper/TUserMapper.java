package com.paul.mybatis.mapper;

import com.paul.mybatis.entity.TUser;

import java.util.List;

public interface TUserMapper {

    TUser selectByPrimaryKey(Integer id);

    List<TUser> selectAll();
}
