package com.test.affair;

import com.test.util.JdbcUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by wangsongyan on 2017/6/15.
 * email: wangsongyan921@163.com
 */
public class Demo {

    public void test(String from, String to, double money) {
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            //start affair
            connection.setAutoCommit(false);

            AccountDao accountDao = new AccountDao();
            accountDao.updateBalance(connection,from, -money);
            accountDao.updateBalance(connection,to, money);

            //commit
            connection.commit();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
            //rollback
            try {
                connection.rollback();
                connection.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Test
    public void func(){
        test("zhangsan","lisi",2000);
    }
}
