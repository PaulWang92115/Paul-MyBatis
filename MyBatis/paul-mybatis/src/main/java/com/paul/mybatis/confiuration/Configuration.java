package com.paul.mybatis.confiuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 所有的配置信息
 *
 */
public class Configuration {

    private String jdbcDriver;

    private String jdbcUrl;

    private String jdbcPassword;

    private String jdbcUsername;

    private Map<String,MappedStatement> mappedStatement = new HashMap<>();

    public Map<String, MappedStatement> getMappedStatement() {
        return mappedStatement;
    }

    public void setMappedStatement(Map<String, MappedStatement> mappedStatement) {
        this.mappedStatement = mappedStatement;
    }

    public String getJdbcDriver() {
        return jdbcDriver;
    }

    public void setJdbcDriver(String jdbcDriver) {
        this.jdbcDriver = jdbcDriver;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getJdbcPassword() {
        return jdbcPassword;
    }

    public void setJdbcPassword(String jdbcPassword) {
        this.jdbcPassword = jdbcPassword;
    }

    public String getJdbcUsername() {
        return jdbcUsername;
    }

    public void setJdbcUsername(String jdbcUsername) {
        this.jdbcUsername = jdbcUsername;
    }
}
