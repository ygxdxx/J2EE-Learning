package com.test.forward;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wangsongyan on 2017/5/31.
 * email: wangsongyan921@163.com
 */
@WebServlet(name = "ForwardOneServlet", value = "/ForwardOneServlet")
public class ForwardOneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-type", "text/html;charset=utf-8");
        response.setHeader("one", "ONE");
        response.getWriter().print("First Servlet");
        //equals invoke service of method of second Servlet
        request.getRequestDispatcher("/ForwardTwoServlet").forward(request, response);
    }
}
