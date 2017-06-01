package com.test.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wangsongyan on 2017/6/1.
 * email: wangsongyan921@163.com
 */
@WebServlet(name = "FormServlet",value = "/FormServlet")
public class FormServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s1 = request.getParameter("num1");
        String s2 = request.getParameter("num2");
        int num1 = Integer.parseInt(s1);
        int num2 = Integer.parseInt(s2);

        int sum = num1 + num2;

        request.setAttribute("result",sum);
        request.getRequestDispatcher("/addTest/result.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
