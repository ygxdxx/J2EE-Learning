package com.test.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by wangsongyan on 2017/6/11.
 * email: wangsongyan921@163.com
 */
public class Testjdbc {

    @Test
    public void func() throws ClassNotFoundException, SQLException {
        //Class.forName("com.mysql.jdbc.Driver"); // equals DriverManager.registerDriver(new Driver()); jdbc 4.0 later
        String url = "jdbc:mysql://localhost:3306/test2?useSSL=false";
        String ursername = "root";
        String password = "123";

        Connection conn = DriverManager.getConnection(url,ursername,password);
        System.out.println(conn);
    }
}
