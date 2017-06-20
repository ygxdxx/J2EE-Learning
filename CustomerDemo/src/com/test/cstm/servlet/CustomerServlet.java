package com.test.cstm.servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import com.test.cstm.entity.Customer;
import com.test.cstm.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wangsongyan on 2017/6/18.
 * email: wangsongyan921@163.com
 */
@WebServlet(name = "CustomerServlet", value = "/CustomerServlet")
public class CustomerServlet extends BaseServlet {

    private CustomerService customerService = new CustomerService();

    protected String add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 1.封装表单数据到Customer
         * 2.补全cid,使用UUID
         * 3.使用service方法完成添加操作
         * 4.向request域中保存成功信息
         * 5.转发到msg.jsp
         */
        Customer customer = CommonUtils.toBean(req.getParameterMap(), Customer.class);
        customer.setCid(CommonUtils.uuid());
        customerService.add(customer);
        req.setAttribute("msg","恭喜,添加客户成功!");
        return "f:msg.jsp";
    }
}
