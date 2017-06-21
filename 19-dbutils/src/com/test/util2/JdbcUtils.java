package com.test.util2;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by wangsongyan on 2017/6/21.
 * email: wangsongyan921@163.com
 */
public class JdbcUtils {

    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    public static ComboPooledDataSource getDataSource() {
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
