package com.paul;

import static org.junit.Assert.assertTrue;

import com.paul.mybatis.entity.User;
import com.paul.mybatis.factory.DefaultSqlSessionFactory;
import com.paul.mybatis.factory.SqlSessionFactory;
import com.paul.mybatis.mapper.UserMapper;
import com.paul.mybatis.sqlsession.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void test(){
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //List<User> lists = mapper.selectAll();

        User user = mapper.selectByPrimaryKey(1L);

        System.out.println(user.getUserName());
    }
}
