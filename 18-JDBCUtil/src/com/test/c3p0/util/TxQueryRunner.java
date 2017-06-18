package com.test.c3p0.util;

import com.test.c3p0.util.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.*;

/**
 * Created by wangsongyan on 2017/6/18.
 * email: wangsongyan921@163.com
 */
public class TxQueryRunner extends QueryRunner {

    @Override
    public int[] batch(String sql, Object[][] params) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        int[] result = super.batch(connection, sql, params);
        JdbcUtils.releaseConnection(connection);
        return result;
    }

    @Override
    public <T> T query(String sql, Object param, ResultSetHandler<T> rsh) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        T result = super.query(connection, sql, param, rsh);
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
    public <T> T insertBatch(String sql, ResultSetHandler<T> rsh, Object[][] params) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        T result = super.insertBatch(connection, sql, rsh, params);
        JdbcUtils.releaseConnection(connection);
        return result;
    }
}
