package com.test.user.dao;

import com.test.user.entity.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by wangsongyan on 2017/6/13.
 * email: wangsongyan921@163.com
 */
public class JdbcUserDaoImpl implements UserDao {

    @Override
    public User findUserByName(String username) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            InputStream is = new FileInputStream("dbconfig.properties");
            Properties properties = new Properties();
            properties.load(is);
            Class.forName(properties.getProperty("driverClassName"));
            connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
            String sql = "SELECT * FROM stu WHERE username=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            resultSet = ps.executeQuery();
            if (resultSet == null) {
                return null;
            }
            if (resultSet.next()) {
                User user = new User();
                user.setUsername(resultSet.getString("username"));
                return user;
            } else {
                return null;
            }
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return null;
    }

    @Override
    public void addUser(User user) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            InputStream is = new FileInputStream("dbconfig.properties");
            Properties properties = new Properties();
            properties.load(is);
            Class.forName(properties.getProperty("driverClassName"));
            connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
            String sql = "INSERT INTO stu VALUES(?,?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.executeUpdate();
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }
}
