package com.test.user.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by wangsongyan on 2017/6/13.
 * email: wangsongyan921@163.com
 */
public class DaoFactory {

    private static Properties properties = null;

    static {
        try {
            InputStream is = new FileInputStream("dao.properties");
            properties = new Properties();
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static UserDao getUserDao() {
        String daoClassName = properties.getProperty("com.test.user.dao.UserDao");
        try {
            Class clazz = Class.forName(daoClassName);
            return (UserDao) clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
