package com.test.login;

import sun.swing.BeanInfoUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.io.IOException;

/**
 * Created by wangsongyan on 2017/6/4.
 * email: wangsongyan921@163.com
 */
@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //判断验证码是否错误
        //1.如果错误，则返回登录页面重新登录
        //2.如果正确，再对用户名和密码进行判断
        //验证码文本已经被添加到了 session 中
        String verifyText = (String) request.getSession().getAttribute("verify_text");
        String loginVerifyText = request.getParameter("verify_code").toLowerCase();
        if (!verifyText.toLowerCase().equals(loginVerifyText)) {
            //使用请求转发 forward 属于一次请求链，可以将数据通过 request 域带回
            request.setAttribute("msg", "验证码输入错误");
            request.getRequestDispatcher("/login/login.jsp").forward(request, response);
        } else {
            //判断用户名和验证码是否正确
            //1.如果正确，跳转到成功页面
            //2.如果错误，返回登录页面重新登录
            request.setCharacterEncoding("utf-8");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (!username.equals("admin")) {
                //用户名错误，登录失败
                //1.把错误信息添加到 request 中
                //2.请求转发到登录页面
                request.setAttribute("msg", "用户名错误");
                request.getRequestDispatcher("/login/login.jsp").forward(request, response);
            } else {
                //登录成功
                //1.将用户名保存到 session 和 cookie 中
                //  1.cookie 用户再次再登录框中保存用户名
                //  2.session 用户不关闭浏览器下访问直接登录成功页面
                //2.重定向到成功页面
                request.getSession().setAttribute("username", username);

                Cookie cookie = new Cookie("usr", username);
                cookie.setMaxAge(60 * 60);
                response.addCookie(cookie);
                response.sendRedirect("/loginDemo/login/success.jsp");
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
