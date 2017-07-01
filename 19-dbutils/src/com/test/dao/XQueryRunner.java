package com.test.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by wangsongyan on 2017/7/1.
 * email: wangsongyan921@163.com
 * <p>
 * 不需要外界处理连接
 * 在内部通过JdbcUtils获取
 */
public class XQueryRunner extends QueryRunner {

    @Override
    public int[] batch(String sql, Object[][] params) throws SQLException {
        /**
         * 1.等到连接
         * 2.执行父类方法，传递连接对象
         * 3.释放连接
         * 4.返回值
         */
        Connection connection = JdbcUtils.getConnection();
        int[] result = super.batch(connection, sql, params);
        JdbcUtils.releaseConnection(connection);
        return result;
    }


    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        T result = super.query(connection, sql, rsh, params);
        JdbcUtils.releaseConnection(connection);
        return result;
    }

    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        T result = super.query(connection, sql, rsh);
        JdbcUtils.releaseConnection(connection);
        return result;
    }


    @Override
    public int update(String sql) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        int result = super.update(connection, sql);
        JdbcUtils.releaseConnection(connection);
        return result;
    }

    @Override
    public int update(String sql, Object param) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        int result = super.update(connection, sql, param);
        JdbcUtils.releaseConnection(connection);
        return result;
    }

    @Override
    public int update(String sql, Object... params) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        int result = super.update(connection, sql, params);
        JdbcUtils.releaseConnection(connection);
        return result;
    }

    @Override
    public <T> T insert(String sql, ResultSetHandler<T> rsh) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        T result = super.insert(connection, sql, rsh);
        JdbcUtils.releaseConnection(connection);
        return result;
    }

    @Override
    public <T> T insert(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        T result = super.insert(connection, sql, rsh, params);
        JdbcUtils.releaseConnection(connection);
        return result;
    }

    /*@Override
    public <T> T insertBatch(String sql, ResultSetHandler<T> rsh, Object[][] params) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        T result = super.insert(connection, sql, rsh, params);
        JdbcUtils.releaseConnection(connection);
        return result;
    }*/

}
