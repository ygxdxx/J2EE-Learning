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

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static DataSource getDataSource(){
        return  dataSource;
    }
}
