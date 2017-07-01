package com.test.dao;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

/**
 * Created by wangsongyan on 2017/6/25.
 * email: wangsongyan921@163.com
 */
public class ServiceDemo {

    private AccountDao accountDao = new AccountDao();

    @Test
    public void serviceMethod() {
        try {
            JdbcUtils.beginTransaction();
            accountDao.update("zhangsan", 99);
            accountDao.update("lisi", -99);
            JdbcUtils.commitTransaction();
        } catch (SQLException e) {
            try {
                JdbcUtils.rollbackTransaction();
            } catch (SQLException e1) {
                throw new RuntimeException("回滚了~~");
            }
        }
    }
}
