package com.test.util;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by wangsongyan on 2017/6/20.
 * email: wangsongyan921@163.com
 */
public class Demo {

    @Test
    public void testAdd() {
        Student student = new Student();
        student.setUsername("xiaoming");
        student.setAge(88);

        //addStu(student);
        //updateStu(student);
        System.out.println(load("xiaoming"));
    }

    public void addStu(Student student) {
        QR qr = new QR(JdbcUtil.getDataSource());
        String sql = "INSERT INTO stu VALUES(?,?)";
        Object[] params = {student.getUsername(), student.getAge()};
        qr.update(sql, params);
    }

    public void updateStu(Student student) {
        QR qr = new QR(JdbcUtil.getDataSource());
        String sql = "UPDATE stu SET age=? WHERE username=?";
        Object[] params = {student.getAge(), student.getUsername()};
        qr.update(sql, params);
    }

    public Student load(String username) {
        QR qr = new QR(JdbcUtil.getDataSource());
        String sql = "SELECT * FROM stu WHERE username = ?";
        Object[] params = {username};
        return qr.query(sql, new RsHandler<Student>() {
            @Override
            public Student handle(ResultSet rs) throws SQLException {
                return null;
            }
        }, params);
    }

    @Test
    public void deleteStu(String username) {

        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = JdbcUtil.getConnection();
            String sql = "DELETE FROM stu WHERE username=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                connection.close();
            } catch (SQLException e) {
            }
        }
    }
}
