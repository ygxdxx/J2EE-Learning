package com.test.batch;

import com.test.util.JdbcUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by wangsongyan on 2017/6/13.
 * email: wangsongyan921@163.com
 */
public class TestBatch {

    @Test
    public void func1() throws SQLException, IOException, ClassNotFoundException {
        Connection connection = JdbcUtils.getConnection();
        String sql = "INSERT INTO stu VALUES (?,?,?,?)";
        PreparedStatement ps = connection.prepareCall(sql);

        for (int i = 0; i < 1000; i++) {
            ps.setInt(1, i + 1);
            ps.setString(2, "stu_" + i);
            ps.setInt(3, i + 20);
            ps.addBatch();
        }

        ps.executeBatch();
    }
}
