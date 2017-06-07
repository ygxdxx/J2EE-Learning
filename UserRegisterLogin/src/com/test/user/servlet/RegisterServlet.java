package com.test.user.servlet;

import com.test.user.entity.User;
import com.test.user.service.UserException;
import com.test.user.service.UserService;
import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by wangsongyan on 2017/6/6.
 * email: wangsongyan921@163.com
 */
@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        UserService userService = new UserService();
        //将表单的数据封装为一个用户对象
        User user = new User();
        user.setName(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        try {
            userService.register(user);
            response.getWriter().print("<h1>注册成功</h1><a href='" + request.getContextPath() + "/user/login.jsp/" + "'>点击这里登录</a>");
        } catch (UserException e) {
            request.setAttribute("errMsg", e.getMessage());
            request.getRequestDispatcher("/user/register.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private static <T> T toBean(Map map, Class<T> tClass) {
        try {
            T bean = tClass.newInstance();
            BeanUtils.populate(bean, map);
            return bean;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
