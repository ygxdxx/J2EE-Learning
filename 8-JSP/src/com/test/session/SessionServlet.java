package com.test.session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by wangsongyan on 2017/6/1.
 * email: wangsongyan921@163.com
 */
@WebServlet(name = "SessionServlet", value = "/SessionServlet")
public class SessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.post处理中文乱码
        //2.获取用户名密码
        //3.验证用户
        //4.把用户名保存到cookie，发送给浏览器
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //判断用户名
        if (!"admin".equalsIgnoreCase(username)) {
            //0.设置cookie
            //1.写入session
            //2.返回结果重定向
            Cookie cookie = new Cookie("name", username);
            cookie.setMaxAge(60 * 60);

            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.addCookie(cookie);
            response.sendRedirect("/test8/testSession2/succ1.jsp");
        } else {
            //1.错误信息保存到request域
            //2.转发 到login.jsp
            request.setAttribute("msg", "用户名错误");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/testSession2/login.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
