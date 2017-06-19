package com.test.cstm.service;

import com.test.cstm.dao.CustomerDao;
import com.test.cstm.entity.Customer;

/**
 * Created by wangsongyan on 2017/6/18.
 * email: wangsongyan921@163.com
 */
public class CustomerService {

    private CustomerDao customerDao = new CustomerDao();

    public void add(Customer customer) {
        customerDao.add(customer);
    }
}
