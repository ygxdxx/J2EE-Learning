package com.test.dbcp;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by wangsongyan on 2017/6/16.
 * email: wangsongyan921@163.com
 */
public class TestDBCP {

    @Test
    public void func1() throws SQLException {
        /**
         * 1.create pool of mysql
         * 2.configure parameters of jdbc
         * 3.configure pool
         * 4.get connection
         */
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/web_db?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("123");

        dataSource.setMaxTotal(20);
        dataSource.setMinIdle(3);
        dataSource.setMaxWaitMillis(1000);

        Connection connection = dataSource.getConnection();
        System.out.println(connection.getClass().getName());

        connection.close();
    }
}
