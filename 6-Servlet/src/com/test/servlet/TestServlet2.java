package com.test.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by wangsongyan on 2017/5/28.
 * email: wangsongyan921@163.com
 */
public class TestServlet2 implements Servlet {

    private ServletConfig servletConfig;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
        init();
    }

    public void init(){

    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servicing...");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }

    //mock methods of GenericServlet
    public ServletContext getServletContext() {
        return servletConfig.getServletContext();
    }

    public String getServletName() {
        return servletConfig.getServletName();
    }

    public String getInitParameter(String name) {
        return servletConfig.getInitParameter(name);
    }
}
