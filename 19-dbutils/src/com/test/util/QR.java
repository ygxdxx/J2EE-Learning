package com.test.util;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by wangsongyan on 2017/6/20.
 * email: wangsongyan921@163.com
 */
public class QR {

    private DataSource dataSource;

    public QR() {
    }

    public QR(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int update(String sql, Object... params) {

        Connection connection = null;
        PreparedStatement ps = null;

        try {
            //连接池得到连接
            connection = dataSource.getConnection();
            //使用sql创建ps
            ps = connection.prepareStatement(sql);
            //初始化参数
            initParams(ps, params);
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
        }
    }

    private void initParams(PreparedStatement ps, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i + 1, params[i]);
        }
    }

    public <T> T query(String sql, RsHandler<T> rsHandler, Object... params) {

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = dataSource.getConnection();
            ps = connection.prepareStatement(sql);
            initParams(ps, params);

            rs = ps.executeQuery();

            return rsHandler.handle(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

interface RsHandler<T> {
    T handle(ResultSet rs) throws SQLException;
}
