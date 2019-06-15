package com.paul.mybatis.factory;

import com.paul.mybatis.sqlsession.SqlSession;

public interface SqlSessionFactory {

    SqlSession openSession();
}
