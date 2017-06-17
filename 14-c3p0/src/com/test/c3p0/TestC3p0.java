package com.test.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.jboss.C3P0PooledDataSource;
import org.junit.jupiter.api.Test;

import javax.naming.NamingException;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by wangsongyan on 2017/6/17.
 * email: wangsongyan921@163.com
 */
public class TestC3p0 {

    @Test
    public void func() throws PropertyVetoException, NamingException, SQLException {

        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/web_db?useSSL=false");
        dataSource.setUser("root");
        dataSource.setPassword("123");

        dataSource.setMaxPoolSize(20);
        dataSource.setMinPoolSize(3);
        dataSource.setAcquireIncrement(5);
        dataSource.setInitialPoolSize(10);

        Connection connection = dataSource.getConnection();
        System.out.println(connection.getClass().getName());

        connection.close();
    }
}
