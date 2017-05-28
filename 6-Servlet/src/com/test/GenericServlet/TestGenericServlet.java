package com.test.GenericServlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by wangsongyan on 2017/5/28.
 * email: wangsongyan921@163.com
 */
public class TestGenericServlet extends GenericServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("init...");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service...");
    }

    @Override
    public void destroy() {
        System.out.println("destroy...");
    }
}
