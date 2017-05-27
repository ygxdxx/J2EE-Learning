package com.test.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by wangsongyan on 2017/5/28.
 * email: wangsongyan921@163.com
 */
public class TestServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init...");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("ServletConfig...");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Service...");
    }

    @Override
    public String getServletInfo() {
        System.out.println("ServletInfo...");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("Destroy...");
        System.out.println();
    }
}
