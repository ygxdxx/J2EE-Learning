package com.test.ServletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wangsongyan on 2017/5/29.
 * email: wangsongyan921@163.com
 */
public class GetInitContextValue extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext application = this.getServletContext();
        String value = application.getInitParameter("context-param");
        System.out.println(value);
    }
}
