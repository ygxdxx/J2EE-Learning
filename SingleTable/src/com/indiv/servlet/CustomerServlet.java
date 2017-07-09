package com.indiv.servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import com.indiv.entity.Customer;
import com.indiv.entity.PageBean;
import com.indiv.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

 /*   public String findAll(HttpServletRequest request, HttpServletResponse response) {
        //1.调用service得到所有客户
        //2.保存到request域
        //3.转发到list.jsp
        request.setAttribute("cstmList", customerService.findAll());
        return "f:/list.jsp";
    }*/

    public String findAll(HttpServletRequest request, HttpServletResponse response) {
        /**
         * 1.获取页面传递的pc
         * 2.给定ps的值
         * 3.使用pc和ps调用service方法，得到pageBean，保存到request域
         * 4.转发到list.jsp
         */
        /**
         * 1.pc不存在，则为1
         * 2.pc存在，转换为int
         */
        int pc = getPageCurrent(request);//获取pc
        int ps = 10; //给定ps的值
        PageBean<Customer> pageBean = customerService.findAll(pc, ps);//传递ps、pc给Service得到 PageBean
        //设置url
        pageBean.setUrl(getUrl(request));
        request.setAttribute("pageBean", pageBean);
        return "f:/list.jsp";
    }

    private int getPageCurrent(HttpServletRequest request) {
        String value = request.getParameter("pc");
        if (value == null || value.trim().isEmpty()) {
            return 1;
        }
        return Integer.parseInt(value);
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


//    public String query(HttpServletRequest request, HttpServletResponse response) {
//        Customer criteria = CommonUtils.toBean(request.getParameterMap(), Customer.class);
//        List<Customer> arrayList = customerService.query(criteria);
//        request.setAttribute("cstmList", arrayList);
//        return "f:/list.jsp";
//    }

    public String query(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        /**
         * 1.得到pc
         * 2.得到ps
         * 3.调用service得到pageBean
         * 4.将pageBean保存到request域中
         * 5.转发到list.jsp
         */
        //获取查询条件
        Customer criteria = CommonUtils.toBean(request.getParameterMap(), Customer.class);

        //处理GET编码问题
        criteria = encoding(criteria);

        int pc = getPageCurrent(request);
        int ps = 10;
        PageBean<Customer> pageBean = customerService.query(criteria, pc, ps);

        pageBean.setUrl(getUrl(request));

        request.setAttribute("pageBean", pageBean);
        return "f:/list.jsp";
    }

    //因为是GET请求，所以需要转码
    private Customer encoding(Customer criteria) throws UnsupportedEncodingException {
        String cname = criteria.getCname();
        String gender = criteria.getGender();
        String cellPhone = criteria.getCellphone();
        String email = criteria.getEmail();

        if (cname != null && cname.trim().isEmpty()) {
            cname = new String(cname.getBytes("ISO-8859-1"), "utf-8");
            criteria.setCname(cname);
        }

        if (gender != null && gender.trim().isEmpty()) {
            gender = new String(gender.getBytes("ISO-8859-1"), "utf-8");
            criteria.setGender(gender);
        }

        if (cellPhone != null && cellPhone.trim().isEmpty()) {
            cellPhone = new String(cellPhone.getBytes("ISO-8859-1"), "utf-8");
            criteria.setCellphone(cellPhone);
        }

        if (email != null && email.trim().isEmpty()) {
            email = new String(email.getBytes("ISO-8859-1"), "utf-8");
            criteria.setEmail(email);
        }

        return criteria;
    }

//    public String delete(HttpServletRequest request, HttpServletResponse response) {
//        String cid = request.getParameter("cid");
//        customerService.delete(cid);
//        request.setAttribute("msg", "删除成功");
//        return "f:/msg.jsp";
//    }

    /**
     * 截取url
     *
     * @param request
     * @return
     */
    private String getUrl(HttpServletRequest request) {
        String contextPath = request.getContextPath(); //项目名
        String servletPath = request.getServletPath(); //Servlet路径 即/CustomerServlet
        String queryString = request.getQueryString(); //查询参数 ?之后的部分

        //判断是否包含pc这个参数，如果包含则截取下去
        if (queryString.contains("&pc=")) {
            int index = queryString.lastIndexOf("&pc=");
            queryString = queryString.substring(0, index);
        }
        //不包含问号
        return contextPath + servletPath + "?" + queryString;
    }
}
