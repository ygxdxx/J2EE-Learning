package com.test.util2;

import com.test.dao.JdbcUtils;
import com.test.util.JdbcUtil;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by wangsongyan on 2017/6/21.
 * email: wangsongyan921@163.com
 */
public class TestCRUD {

    @Test
    public void add(Student student) {
        QRunner qr = new QRunner(JdbcUtil.getDataSource());
        String sql = "INSERT INTO stu VALUES(?,?)";
        Object[] params = {student.getName(), student.getAge()};
        qr.update(sql, params);
    }

    @Test
    public void update(String username) {
        QRunner qr = new QRunner(JdbcUtils.getDataSource());
        String sql = "UPDATE stu SET username=?";
        Object param = username;
        qr.update(sql, param);
    }

    @Test
    public Student query(String username) {
        QRunner qr = new QRunner(JdbcUtil.getDataSource());
        String sql = "SELECT * FROM stu WHERE username=?";
        Object param = username;
        return qr.query(sql, new RsHandler<Student>() {
            @Override
            public Student handle(ResultSet rs) throws SQLException {
                Student student = new Student();
                student.setName(rs.getString("username"));
                student.setAge(rs.getInt("age"));
                return student;
            }
        }, param);
    }

}
