package com.paul.mybatis;

import com.paul.mybatis.entity.User;
import com.paul.mybatis.factory.DefaultSqlSessionFactory;
import com.paul.mybatis.factory.SqlSessionFactory;
import com.paul.mybatis.mapper.UserMapper;
import com.paul.mybatis.sqlsession.SqlSession;

public class TestDemo {

    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.selectByPrimaryKey(11221312321L);

        System.out.println(user.toString());
    }
}
