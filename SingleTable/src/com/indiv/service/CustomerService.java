package com.indiv.service;

import com.indiv.dao.CustomerDao;
import com.indiv.entity.Customer;

/**
 * Created by wangsongyan on 2017/7/1.
 * email: wangsongyan921@163.com
 */
public class CustomerService {
    private CustomerDao customerDao = new CustomerDao();

    public void add(Customer customer) {
        customerDao.add(customer);
    }
}
