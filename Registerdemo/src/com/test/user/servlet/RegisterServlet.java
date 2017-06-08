package com.test.user.servlet;

import com.test.user.entity.User;
import com.test.user.service.UserException;
import com.test.user.service.UserService;
import com.test.user.util.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by wangsongyan on 2017/6/7.
 * email: wangsongyan921@163.com
 */
@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserService userService = new UserService();
        //编码问题
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //获取用户验证码
        String codeText = (String) request.getSession().getAttribute("codeText");

        //对Javabean赋值
        User user = CommonUtils.getBean(request.getParameterMap(), User.class);

        //表单校验
        //map集合用于存放错误信息
        HashMap<String, String> errors = new HashMap<>();
        String username = user.getUsername();
        String password = user.getPassword();
        if (username == null || username.trim().isEmpty()) {
            errors.put("username", "用户名不能空");
        } else if (username.length() < 3 || username.length() > 15) {
            errors.put("username", "用户名长度必须在3-15之间");
        }

        if (password == null || password.trim().isEmpty()) {
            errors.put("password", "密码不能空");
        } else if (password.length() < 3 || password.length() > 15) {
            errors.put("password", "密码长度必须在3-15之间");
        }

        if (codeText == null || codeText.trim().isEmpty()) {
            errors.put("verifyCode", "验证码不能为空");
        } else if (codeText.length() != 4) {
            errors.put("verifyCode", "验证码长度错误");
        } else if (!codeText.equalsIgnoreCase(user.getVerifyCode())) {
            errors.put("verifyCode", "验证码错误");
        }

        //判断map是否为空
        if (errors.size() > 0) {
            //保存到request域
            request.setAttribute("errors",errors);
            //转发
            request.getRequestDispatcher("/user/register.jsp").forward(request,response);
            return;
        }


        //执行注册
        try {
            userService.register(user);
            //注册成功
            response.getWriter().print("<h1>注册成功</h1><a href='" + request.getContextPath() + "/user/login.jsp" + "'>点击这里登录</a>");
            //response.sendRedirect(request.getContextPath() + "/user/login.jsp");
        } catch (UserException e) {
            //注册失败
            request.setAttribute("errMsg", e.getMessage());
            //让窗口显示信息 不清空数据
            request.setAttribute("user", user);
            //请求转发会刷新页面？
            request.getRequestDispatcher("/user/register.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
