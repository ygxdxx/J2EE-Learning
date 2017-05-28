package com.test.GenericServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by wangsongyan on 2017/5/28.
 * email: wangsongyan921@163.com
 */
public class TestMockGenericServlet extends MockGenericServlet {

    @Override
    public void init(){
        System.out.println("starting...");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        String value = super.getInitParameter("p1");
    }
}
