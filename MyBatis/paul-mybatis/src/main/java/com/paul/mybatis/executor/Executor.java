package com.paul.mybatis.executor;

import com.paul.mybatis.confiuration.MappedStatement;

import java.util.List;

/**
 *
 * mybatis 核心接口之一，定义了数据库操作的最基本的方法，JDBC，sqlSession的所有功能都是基于它来实现的
 *
 */
public interface Executor {

    /**
     *
     * 查询接口
     * @param ms 封装sql 语句的 mappedStatemnet 对象那个
     * @param parameter 传入sql 参数
     * @param <E> 将数据对象转换成指定对象结果集返回
     * @return
     */
    <E> List<E> query(MappedStatement ms, Object parameter);

}
