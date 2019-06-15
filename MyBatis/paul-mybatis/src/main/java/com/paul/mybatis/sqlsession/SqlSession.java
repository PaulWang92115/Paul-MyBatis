package com.paul.mybatis.sqlsession;

import java.util.List;

/**
 *
 * 封装了所有数据库的操作
 * 所有功能都是基于 Excutor 来实现的，Executor 封装了 JDBC 操作
 *
 *
 */
public interface SqlSession {

    /**
     * 根据传入的条件查询单一结果
     * @param statement  方法对应 sql 语句，namespace+id
     * @param parameter  要传入 sql 语句中的查询参数
     * @param <T> 返回指定的结果对象
     * @return
     */
    <T> T selectOne(String statement, Object parameter);

    <T> List<T> selectList(String statement, Object parameter);

    <T> T getMapper(Class<T> type);
}
