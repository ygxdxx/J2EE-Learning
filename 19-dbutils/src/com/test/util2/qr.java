package com.test.util2;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by wangsongyan on 2017/6/21.
 * email: wangsongyan921@163.com
 */
public class qr {

    @Test
    public void func(String username) throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "SELECT * FROM stu WHERE username=?";
        Object[] params = {username};
        Student student = queryRunner.query(sql, new BeanHandler<Student>(Student.class), params);
        System.out.println(student);
    }

    @Test
    public void func2() throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "SELECT * FROM stu";
        List<Student> list = queryRunner.query(sql,new BeanListHandler<Student>(Student.class));
        System.out.println(list);
    }
}
