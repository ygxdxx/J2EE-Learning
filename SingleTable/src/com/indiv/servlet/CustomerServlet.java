package com.indiv.servlet;

import cn.itcast.servlet.BaseServlet;
import com.indiv.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wangsongyan on 2017/7/1.
 * email: wangsongyan921@163.com
 */
@WebServlet(name = "CustomerServlet", value = "/CustomerServlet")
public class CustomerServlet extends BaseServlet {

    private CustomerService customerService = new CustomerService();

}
