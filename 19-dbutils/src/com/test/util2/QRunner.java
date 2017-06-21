package com.test.util2;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by wangsongyan on 2017/6/21.
 * email: wangsongyan921@163.com
 */
public class QRunner {

    private DataSource dataSource = null;

    public QRunner(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void initParams(PreparedStatement ps, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i + 1, params[i]);
        }
    }

    public void update(String sql, Object... params) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = dataSource.getConnection();
            ps = connection.prepareStatement(sql);
            initParams(ps, params);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("更新数据异常");
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
            }
        }

    }

    public Student query(String sql, RsHandler<Student> handler, Object... params) {

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = dataSource.getConnection();
            ps = connection.prepareStatement(sql);
            initParams(ps, params);
            rs = ps.executeQuery();
            return handler.handle(rs);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}

interface RsHandler<T> {
    public T handle(ResultSet rs) throws SQLException;
}
