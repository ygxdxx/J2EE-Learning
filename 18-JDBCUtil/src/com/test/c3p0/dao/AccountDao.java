package com.test.c3p0.dao;

import com.test.c3p0.util.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * Created by wangsongyan on 2017/6/17.
 * email: wangsongyan921@163.com
 */
public class AccountDao {

    public void update(String name, double money) throws SQLException {

        QueryRunner queryRunner = new TxQueryRunner();
        String sql = "UPDATE account SET balance = balance+? WHERE name = money";
        Object[] params = {money, name};

        queryRunner.update(sql, params);
    }
}
