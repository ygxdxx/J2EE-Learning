package com.test.c3p0.service;

import com.test.c3p0.dao.AccountDao;
import com.test.c3p0.util.JdbcUtils;

import java.sql.SQLException;

/**
 * Created by wangsongyan on 2017/6/18.
 * email: wangsongyan921@163.com
 */
public class ServiceTest {

    private AccountDao accountDao = new AccountDao();

    public void serviceMethod(){
        try {
            JdbcUtils.beginTransaction();


        } catch (SQLException e) {
            try {
                JdbcUtils.rollbackTransaction();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally {
            try {
                JdbcUtils.commitTransaction();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
