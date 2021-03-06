package com.paul.mybatis;

import com.paul.mybatis.entity.User;
import com.paul.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisDemo {

    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void testAutoMapping() throws IOException {
        //-------------第一阶段-------------------
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();

        //-------------第二阶段-------------------
        //获取 sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取对应 mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


        //-------------第三阶段-------------------
        //执行查询语句并返回单条数据
        User user = mapper.selectByPrimaryKey(121312312312L);
        System.out.println(user);

        //执行查询语句并返回多条数据
        List<User> users = mapper.selectAll();

    }
}
