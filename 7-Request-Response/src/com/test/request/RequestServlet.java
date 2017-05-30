package com.test.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wangsongyan on 2017/5/30.
 * email: wangsongyan921@163.com
 */
@WebServlet(name = "RequestServlet", value = "/RequestServlet")
public class RequestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String addr = request.getRemoteAddr();
        String method = request.getMethod();
        String userAgent = request.getHeader("User-Agent");
        System.out.println("用户IP地址：" + addr);
        System.out.println("请求方式：" + method);
        System.out.println("版本信息："+userAgent);
        if (userAgent.toLowerCase().contains("chrome")){
            System.out.println("google");
        }else if (userAgent.toLowerCase().contains("firefox")){
            System.out.println("firefox");
        }
    }
}
