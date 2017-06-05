package com.test.servlet;

import com.test.domain.User;
import com.test.service.UserService;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Created by wangsongyan on 2017/6/5.
 * email: wangsongyan921@163.com
 */
@WebServlet(name = "UserServlet",value = "/UserServlet")
public class UserServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        UserService userService = new UserService();
        User user = userService.find();

        request.setAttribute("user",user);
        request.getRequestDispatcher("/show.jsp").forward(request,response);
    }
}
