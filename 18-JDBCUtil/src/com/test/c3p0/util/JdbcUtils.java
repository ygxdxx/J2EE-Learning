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

    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    public static Connection getConnection() throws SQLException {
        //get connection of current thread
        Connection connection = tl.get();
        if (connection != null) {
            return connection;
        }
        return dataSource.getConnection();
    }

    public static void beginTransaction() throws SQLException {
        Connection connection = tl.get();
        if (connection != null) {
            throw new RuntimeException("已经开启事务，不要反复开启");
        }
        connection = getConnection();
        connection.setAutoCommit(false);
        //save connection of current thread
        tl.set(connection);
    }

    public static void commitTransaction() throws SQLException {
        Connection connection = tl.get();
        if (connection == null) {
            throw new RuntimeException("还没有开启事务,不能提交");
        }
        connection.commit();
        connection.close();
        //remove connection of current thread
        tl.remove();
    }

    public static void rollbackTransaction() throws SQLException {
        Connection connection = tl.get();
        if (connection == null) {
            throw new RuntimeException("还没有开启事务，无法回滚");
        }
        connection.rollback();
        connection.close();

        tl.remove();
    }

    public static void releaseConnection(Connection connection) throws SQLException {
        if (connection == null) {
            connection.close();
        } else {
            connection.close();
        }
    }
}
