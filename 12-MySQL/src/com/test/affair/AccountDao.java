package com.test.affair;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by wangsongyan on 2017/6/15.
 * email: wangsongyan921@163.com
 */
public class AccountDao {

    public void updateBalance(Connection connection,String name, double balance) {
        try {
            String sql = "UPDATE account SET balance=balance+? WHERE name=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDouble(1, balance);
            ps.setString(2, name);
            ps.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
