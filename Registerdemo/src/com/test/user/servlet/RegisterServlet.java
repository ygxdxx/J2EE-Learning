package com.test.user.servlet;

import com.test.user.entity.User;
import com.test.user.service.UserException;
import com.test.user.service.UserService;
import com.test.user.util.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wangsongyan on 2017/6/7.
 * email: wangsongyan921@163.com
 */
@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserService userService = new UserService();

        //编码问题
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        //对Javabean赋值
        User user = CommonUtils.getBean(request.getParameterMap(), User.class);

        //获取用户验证码
        String text = (String) request.getSession().getAttribute("verifyCode");
        String userText = (String) request.getAttribute("");

        //执行注册
        try {
            userService.register(user);
            //注册成功
            response.getWriter().print("<h1>注册成功</h1><a href='" + request.getContextPath() + "/user/login.jsp" + "'>点击这里登录</a>");
            //response.sendRedirect(request.getContextPath() + "/user/login.jsp");
        } catch (UserException e) {
            //注册失败
            request.setAttribute("errMsg", e.getMessage());

            //让窗口显示信息 不清空数据
            request.setAttribute("user", user);

            //请求转发会刷新页面？
            request.getRequestDispatcher("/user/register.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
