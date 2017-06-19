package com.test.cstm.dao;

import cn.itcast.jdbc.TxQueryRunner;
import com.test.cstm.entity.Customer;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * Created by wangsongyan on 2017/6/18.
 * email: wangsongyan921@163.com
 */
public class CustomerDao {

    private QueryRunner queryRunner = new TxQueryRunner();

    public void add(Customer customer) {

        try {

            String sql = "INSERT INTO customer VALUES(?,?,?,?,?,?,?)";
            Object[] params = {customer.getCid(), customer.getCname(), customer.getGender(), customer.getCellphone(), customer.getEmail(), customer.getDescription()};
            queryRunner.update(sql, params);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
