package com.test.c3p0.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by wangsongyan on 2017/6/17.
 * email: wangsongyan921@163.com
 */
public class JdbcUtils {

    //c3p0-config.xml is necessary
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (dataSource != null) {
            return connection;
        }
        return dataSource.getConnection();
    }

    public static void beginTransaction() throws SQLException {
        if (connection != null) {
            throw new RuntimeException("已经开启事务，不要反复开启");
        }
        connection = getConnection();
        connection.setAutoCommit(false);
    }

    public static void commitTransaction() throws SQLException {
        if (connection == null) {
            throw new RuntimeException("还没有开启事务,不能提交");
        }
        connection.commit();
        connection.close();
        connection = null;
    }

    public static void rollbackTransaction() throws SQLException {
        if (connection == null) {
            throw new RuntimeException("还没有开启事务，无法回滚");
        }
        connection.rollback();
        connection.close();
        connection = null;
    }

    public static void releaseConnection(Connection connection) throws SQLException {
        if (connection == null) {
            connection.close();
        } else {
            connection.close();
        }
    }
}
