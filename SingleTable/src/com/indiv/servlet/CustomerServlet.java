package com.indiv.servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import com.indiv.entity.Customer;
import com.indiv.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangsongyan on 2017/7/1.
 * email: wangsongyan921@163.com
 */
@WebServlet(name = "CustomerServlet", value = "/CustomerServlet")
public class CustomerServlet extends BaseServlet {

    private CustomerService customerService = new CustomerService();

    public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //封装customer对象
        Customer customer = CommonUtils.toBean(request.getParameterMap(), Customer.class);
        customer.setCid(CommonUtils.uuid());
        //把封装好的customer交给service
        customerService.add(customer);
        request.setAttribute("msg", "恭喜，添加客户成功");
        return "f:/msg.jsp";
    }

    public String findAll(HttpServletRequest request, HttpServletResponse response) {
        //1.调用service得到所有客户
        //2.保存到request域
        //3.转发到list.jsp
        request.setAttribute("cstmList", customerService.findAll());
        return "f:/list.jsp";
    }

    public String preEdit(HttpServletRequest request, HttpServletResponse response) {
        //1.获取cid
        //2.通过cid获取对应的customer
        //3.将customer保存到request域中
        //4.转发到edit.jsp显示在表单中
        String cid = request.getParameter("cid");
        Customer customer = customerService.load(cid);
        request.setAttribute("cstm", customer);
        return "f:/edit.jsp";
    }

    public String edit(HttpServletRequest request, HttpServletResponse response) {
        Customer customer = CommonUtils.toBean(request.getParameterMap(), Customer.class);
        customerService.edit(customer);
        request.setAttribute("msg", "编辑成功");
        return "f:/msg.jsp";
    }


    public String query(HttpServletRequest request, HttpServletResponse response) {
        Customer criteria = CommonUtils.toBean(request.getParameterMap(), Customer.class);
        List<Customer> arrayList = customerService.query(criteria);
        request.setAttribute("cstmList", arrayList);
        return "f:/list.jsp";
    }

    public String delete(HttpServletRequest request, HttpServletResponse response) {
        String cid = request.getParameter("cid");
        customerService.delete(cid);
        request.setAttribute("msg", "删除成功");
        return "f:/msg.jsp";
    }
}
