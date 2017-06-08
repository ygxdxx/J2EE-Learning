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
@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        UserService userService = new UserService();

        User user = CommonUtils.getBean(request.getParameterMap(), User.class);
        try {
            User _user = userService.login(user);
            request.getSession().setAttribute("_user", _user);
            response.sendRedirect(request.getContextPath()+"/user/welcome.jsp");
        } catch (UserException e) {
            request.setAttribute("msg", e.getMessage());
            request.setAttribute("user", user);
            request.getRequestDispatcher("/user/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
