package com.indiv.service;

import com.indiv.dao.CustomerDao;
import com.indiv.entity.Customer;
import com.indiv.entity.PageBean;

import java.util.List;

/**
 * Created by wangsongyan on 2017/7/1.
 * email: wangsongyan921@163.com
 */
public class CustomerService {
    private CustomerDao customerDao = new CustomerDao();

    public void add(Customer customer) {

        customerDao.add(customer);
    }

//    public List<Customer> findAll() {
//        return customerDao.findAll();
//    }

    public Customer load(String cid) {
        return customerDao.load(cid);
    }

    public void edit(Customer customer) {
        customerDao.edit(customer);
    }

//    public void delete(String cid) {
//        customerDao.delete(cid);
//    }

//    public List<Customer> query(Customer criteria) {
//        return customerDao.query(criteria);
//    }

    public PageBean<Customer> query(Customer criteria, int pc, int ps) {
        return customerDao.query(criteria, pc, ps);
    }

    public PageBean<Customer> findAll(int pc, int ps) {
        return customerDao.findAll(pc, ps);
    }
}
