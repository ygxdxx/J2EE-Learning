package com.test.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by wangsongyan on 2017/5/30.
 * email: wangsongyan921@163.com
 */
@WebServlet(name = "ResponseServlet", value = "/ResponseServlet")
public class ResponseServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.sendError(404, "资源不存在了~！");
        //response.getOutputStream()
        //response.getWriter().print("hello response!");

        FileInputStream fis = new FileInputStream("/Users/Cortana/IdeaProjects/JavaWeb/7-Request-Response/20160330_142427-01.jpeg");
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1) {
            response.getOutputStream().write(bytes, 0, len);
        }
    }
}
