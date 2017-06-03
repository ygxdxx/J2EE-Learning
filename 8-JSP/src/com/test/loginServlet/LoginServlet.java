package com.test.loginServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by wangsongyan on 2017/6/2.
 * email: wangsongyan921@163.com
 */
@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.从 session 中获取正确的验证码
        //2.从表单中获取用户填写的验证码
        //3.比较两者是否相同
        //4.如果相同，向下比较用户名&密码；如果不同错误信息存放到request域，转发到login.jsp
        String sessionCode = (String) request.getSession().getAttribute("vcode");
        String loginCode = request.getParameter("verifyCode");
        if (!sessionCode.equals(loginCode)) {
            request.setAttribute("msg", "验证码错误");
            request.getRequestDispatcher("/test3/sessionVerifyCode/login.jsp").forward(request, response);
            return;
        }

        //1.设置请求编码
        //2.获取用户名 密码
        //3.验证用户名和密码
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals("admin")) {
            //登录成功
            //1.添加 Cookie
            //2.添加 Session
            //3.重定向
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60 * 60);
            response.addCookie(cookie);

            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            response.sendRedirect("/test8/testSession3/success.jsp");
        } else {
            //登录失败
            //1.request 域设置错误信息
            //2.forward
            request.setAttribute("msg", "用户名或密码错误");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/testSession3/login.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
