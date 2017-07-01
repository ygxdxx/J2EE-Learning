package com.indiv.dao;

import cn.itcast.jdbc.TxQueryRunner;
import com.indiv.entity.Customer;

import java.sql.SQLException;

/**
 * Created by wangsongyan on 2017/7/1.
 * email: wangsongyan921@163.com
 */
public class CustomerDao {
    private TxQueryRunner queryRunner = new TxQueryRunner();

    public void add(Customer customer) {
        String sql = "INSERT INTO t_customer VALUES(?,?,?,?,?,?,?)";
        Object[] params = {customer.getCid(), customer.getCname(), customer.getGender(), customer.getBirthday(), customer.getCellphone(), customer.getEmail(), customer.getDescription()};
        try {
            queryRunner.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
