package com.test.dao;

import java.sql.SQLException;

/**
 * Created by wangsongyan on 2017/6/25.
 * email: wangsongyan921@163.com
 */
public class AccountDao {

    public void update(String name, double money) throws SQLException {
        XQueryRunner queryRunner = new XQueryRunner();
        String sql = "UPDATE account SET balance = balance+? WHERE name = ?";
        Object[] params = {money, name};
        queryRunner.update(sql, params);
    }
}
