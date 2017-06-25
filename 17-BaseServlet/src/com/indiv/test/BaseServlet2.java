package com.indiv.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by wangsongyan on 2017/6/25.
 * email: wangsongyan921@163.com
 */
@WebServlet(name = "BaseServlet2")
public abstract class BaseServlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取到请求的方法名
        String methodName = req.getParameter("method");
        if (methodName == null || methodName.trim().isEmpty()) {
            throw new RuntimeException("你没有传递所需参数");
        }

        //得到当前类的Class
        Class c = this.getClass();
        Method method;
        try {
            //同时根据名称和参数列表确定
            method = c.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("你调用的方法：" + methodName + "不存在");
        }

        //调用
        try {
            //得到返回值
            String result = (String) method.invoke(this, req, resp);

            //判断到底是否为空
            if (result == null || result.trim().isEmpty()) {
                return;
            }

            //根据返回值决定转发或重定向
            if (result.contains(":")) {
                int index = result.indexOf(":");
                String prefix = result.substring(0, index);
                String path = result.substring(index + 1);
                if (prefix.equalsIgnoreCase("f")) {
                    req.getRequestDispatcher(path).forward(req, resp);
                } else if (prefix.equalsIgnoreCase("r")) {
                    resp.sendRedirect(req.getContextPath() + path);
                } else {
                    throw new RuntimeException("不支持这种操作");
                }

            } else {
                req.getRequestDispatcher(result).forward(req, resp);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
