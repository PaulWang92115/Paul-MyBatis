package com.paul.mybatis;

import com.paul.mybatis.entity.TUser;
import com.paul.mybatis.factory.DefaultSqlSessionFactory;
import com.paul.mybatis.factory.SqlSessionFactory;
import com.paul.mybatis.mapper.TUserMapper;
import com.paul.mybatis.sqlsession.SqlSession;

public class TestDemo {

    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();

        TUserMapper mapper = sqlSession.getMapper(TUserMapper.class);

        TUser user = mapper.selectByPrimaryKey(1);

        System.out.println(user.toString());
    }
}
