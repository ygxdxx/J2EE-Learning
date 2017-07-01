package com.test.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import sun.dc.pr.PRError;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by wangsongyan on 2017/6/21.
 * email: wangsongyan921@163.com
 */
public class JdbcUtils {

    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();


    private static ThreadLocal<Connection> tl = new ThreadLocal<>();

    public static ComboPooledDataSource getDataSource() {
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = tl.get();
        if (connection != null) {
            return connection;
        }
        return dataSource.getConnection();
    }

    public static void beginTransaction() throws SQLException {
        Connection connection = tl.get();
        if (connection != null) {
            throw new RuntimeException("已经开启事务，不要重复开启");
        }
        connection = getConnection();
        connection.setAutoCommit(false);
        //保存当前线程连接
        tl.set(connection);
    }

    public static void commitTransaction() throws SQLException {
        Connection connection = tl.get();
        if (connection == null) {
            throw new RuntimeException("还没开启事务，不能提交");
        }
        connection.commit();
        connection.close();
        //从ThreadLocal中移除移除
        tl.remove();
    }

    public static void rollbackTransaction() throws SQLException {
        Connection connection = tl.get();
        if (connection == null) {
            throw new RuntimeException("还没开启事务，不能回滚");
        }
        connection.rollback();
        connection.close();
        tl.remove();
    }

    public static void releaseConnection(Connection conn) throws SQLException {
        Connection connection = tl.get();
        /**
         * 判断是否为事务专用
         * 如果是，则不关闭
         * 如果不是，则关闭
         */
        //如果connection == null 则当前一定没有事务，那么conn一定不是事务专用
        if (connection == null) {
            conn.close();
        }

        //如果 connection != null 则需判断当前连接与参数连接是否相等，如果不相等 则不是专用连接 close
        if (connection != conn) {
            conn.close();
        }
    }
}
