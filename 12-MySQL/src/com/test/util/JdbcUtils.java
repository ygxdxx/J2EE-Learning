package com.test.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by wangsongyan on 2017/6/12.
 * email: wangsongyan921@163.com
 */
public class JdbcUtils {

    private static Properties properties = null;

    static {
        try {
            InputStream is = new FileInputStream("/Users/Cortana/IdeaProjects/JavaWeb/12-MySQL/src/com/test/util/dbconfig.properties");
            properties = new Properties();
            properties.load(is);
            Class.forName(properties.getProperty("driverClassName"));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        return DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
    }
}
