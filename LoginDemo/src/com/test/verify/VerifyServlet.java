package com.test.verify;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by wangsongyan on 2017/6/4.
 * email: wangsongyan921@163.com
 */
@WebServlet(name = "VerifyServlet", value = "/VerifyServlet")
public class VerifyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VerifyCode verifyCode = new VerifyCode();
        BufferedImage image = verifyCode.getImage();

        //将生成的验证码文本添加到 session 域中
        //因为请求验证码图片的请求与登录验证码并非一个请求
        //第一次访问login 页面的时候会自动发生 get 请求验证码图片
        request.getSession().setAttribute("verify_text", verifyCode.getText());

        //将图片返回到客户端
        VerifyCode.output(image, response.getOutputStream());
    }
}
