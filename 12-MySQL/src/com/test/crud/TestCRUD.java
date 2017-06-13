package com.test.crud;

import com.test.util.JdbcUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.*;

/**
 * Created by wangsongyan on 2017/6/11.
 * email: wangsongyan921@163.com
 */
class TestCRUD {

    @Test
    void func1() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/web_db?useSSL=false";
        String username = "root";
        String password = "123";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        //String sqlInsert = "INSERT INTO stu VALUES(1,'xiaoming','beijing','male',18)";
        String sqlUpdate = "UPDATE stu SET name='xiaogang' WHERE id=1";
        String sqlDelete = "DELETE FROM stu";
        statement.execute(sqlDelete);
    }

    @Test
    public void func2() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/web_db?useSSL=false";
        String username = "root";
        String password = "123";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        String sqlQuery = "SELECT * FROM stu";
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        //default position is beforeFirst
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString("name");
            System.out.println("id:" + id + " name:" + name);
        }

        resultSet.close();
        statement.close();
        connection.close();
    }

    @Test
    public void func3() {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/web_db?useSSL=false";
        String username = "root";
        String password = "123";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName(driverClassName);
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            String sql = "SELECT * FROM stu";
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                System.out.println(id + " " + name);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void func4() {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test2?useSSL=false";
        String username = "root";
        String password = "123";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName(driverClassName);
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            String sql = "SELECT * FROM emp";
            resultSet = statement.executeQuery(sql);
            int count = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= count; i++) {
                    System.out.print(resultSet.getString(i));
                    if (i < count) {
                        System.out.print(",");
                    }
                }
                System.out.println();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public boolean func5(String name, String word) throws ClassNotFoundException, SQLException {
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test2?useSSL=false";
        String username = "root";
        String password = "123";
        String sql = "SELECT * FROM stu WHERE username=? AND password =?";

        Class.forName(driverClassName);
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, word);
        ResultSet rs = preparedStatement.executeQuery();

        return rs.next();
    }

    @Test
    public void func6() throws SQLException, ClassNotFoundException {
        String username = "";
        String password = "";
        func5(username, password);
    }

    @Test
    public void func7() throws SQLException, IOException, ClassNotFoundException {
        Connection connection = JdbcUtils.getConnection();
        System.out.println(connection);
    }
}
