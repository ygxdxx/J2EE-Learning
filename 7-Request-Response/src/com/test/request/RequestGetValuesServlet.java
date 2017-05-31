package com.test.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

/**
 * Created by wangsongyan on 2017/5/31.
 * email: wangsongyan921@163.com
 */
@WebServlet(name = "RequestGetValuesServlet",value = "/RequestGetValuesServlet")
public class RequestGetValuesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("POST:" + request.getParameter("username"));
        System.out.println("POST:" + request.getParameter("password"));
        String[] hobby = request.getParameterValues("hobby");
        System.out.println("POST：" + Arrays.toString(hobby));

        Enumeration names= request.getParameterNames();
        while (names.hasMoreElements()){
            System.out.println(names.nextElement());
        }

        Map<String,String[]> map = request.getParameterMap();
        System.out.println(map);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("GET:" + request.getParameter("name"));
        System.out.println("GET:" + request.getParameter("pass"));
    }
}
