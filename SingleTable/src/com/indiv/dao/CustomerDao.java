package com.indiv.dao;

import cn.itcast.jdbc.TxQueryRunner;
import com.indiv.entity.Customer;
import com.indiv.entity.PageBean;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

//    public List<Customer> findAll() {
//        try {
//            String sql = "SELECT * FROM t_customer ORDER BY cname";
//            return queryRunner.query(sql, new BeanListHandler<>(Customer.class));
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }


    public Customer load(String cid) {
        try {
            String sql = "SELECT * FROM t_customer WHERE cid=?";
            return queryRunner.query(sql, new BeanHandler<Customer>(Customer.class), cid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void edit(Customer customer) {
        try {
            String sql = "UPDATE t_customer SET cname=?,gender=?,birthday=?,cellphone=?,email=?,description=? where cid=?";
            Object[] params = {customer.getCname(), customer.getGender(), customer.getBirthday(), customer.getCellphone(), customer.getEmail(), customer.getDescription(), customer.getCid()};
            queryRunner.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    public void delete(String cid) {
//        String sql = "DELETE FROM t_customer WHERE cid=?";
//        queryRunner
//    }

//    public List<Customer> query(Customer criteria) {
//        StringBuilder sql = new StringBuilder("SELECT * FROM t_customer WHERE 1=1 ");
//
//        List<String> params = new ArrayList<>();
//        String cname = criteria.getCname();
//        if (cname != null && !cname.trim().isEmpty()) {
//            sql.append("and cname LIKE ?");
//            params.add("%" + cname + "%");
//        }
//
//        String gender = criteria.getGender();
//        if (gender != null && !gender.trim().isEmpty()) {
//            sql.append("and gender=?");
//            params.add(gender);
//        }
//
//        String cellphone = criteria.getCellphone();
//        if (cellphone != null && !cellphone.trim().isEmpty()) {
//            sql.append("and cellphone LIKE ?");
//            params.add("%" + cellphone + "%");
//        }
//
//        String email = criteria.getEmail();
//        if (email != null && !email.trim().isEmpty()) {
//            sql.append("and email LIKE ?");
//            params.add("%" + email + "%");
//        }
//
//        try {
//            return queryRunner.query(sql.toString(), new BeanListHandler<Customer>(Customer.class), params.toArray());
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

    public PageBean<Customer> findAll(int pc, int ps) {
        try {
            PageBean<Customer> pageBean = new PageBean<>();
            pageBean.setPc(pc);
            pageBean.setPs(ps);
            String sql = "SELECT count(*) FROM t_customer";
            Number number = queryRunner.query(sql, new ScalarHandler<>());
            int tr = number.intValue();
            pageBean.setTr(tr);

            sql = "SELECT * FROM t_customer ORDER BY cname LIMIT ?,?";
            List<Customer> beanList = queryRunner.query(sql, new BeanListHandler<>(Customer.class), (pc - 1) * ps, ps);
            pageBean.setBeanList(beanList);
            return pageBean;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public PageBean<Customer> query(Customer criteria, int pc, int ps) {
        PageBean<Customer> pageBean = new PageBean<>();
        pageBean.setPc(pc);
        pageBean.setPs(ps);

        //得到条目数量
        StringBuilder cntSql = new StringBuilder("SELECT count(*) FROM t_customer");
        StringBuilder whereSql = new StringBuilder(" WHERE 1=1");

        List<Object> params = new ArrayList<>();
        String cname = criteria.getCname();
        if (cname != null && !cname.trim().isEmpty()) {
            whereSql.append(" AND cname LIKE ?");
            params.add("%" + cname + "%");
        }

        String gender = criteria.getGender();
        if (gender != null && !gender.trim().isEmpty()) {
            whereSql.append(" AND gender=?");
            params.add(gender);
        }

        String cellphone = criteria.getCellphone();
        if (cellphone != null && !cellphone.trim().isEmpty()) {
            whereSql.append(" AND cellphone LIKE ?");
            params.add("%" + cellphone + "%");
        }

        String email = criteria.getEmail();
        if (email != null && !email.trim().isEmpty()) {
            whereSql.append(" AND email LIKE ?");
            params.add("%" + email + "%");
        }

        try {
            //得到数量
            Number number = (Number) queryRunner.query(cntSql.toString(), new ScalarHandler(), params.toArray());
            int tr = number.intValue();
            pageBean.setTr(tr);


            //查询list
            StringBuilder sql = new StringBuilder("SELECT * FROM t_customer");
            StringBuilder limitSql = new StringBuilder(" LIMIT ?,?");
            params.add((pc - 1) * ps);
            params.add(ps);

            //执行
            List<Customer> beanList = queryRunner.query(sql.append(whereSql).append(limitSql).toString(), new BeanListHandler<>(Customer.class), params.toArray());
            pageBean.setBeanList(beanList);

            return pageBean;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
