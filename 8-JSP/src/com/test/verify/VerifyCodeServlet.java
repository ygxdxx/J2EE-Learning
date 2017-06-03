package com.test.verify;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by wangsongyan on 2017/6/3.
 * email: wangsongyan921@163.com
 */
@WebServlet(name = "VerifyCodeServlet", value = "/VerifyCodeServlet")
public class VerifyCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 1.生成图片
         * 2.把图片保存到 session 域中
         * 3.把图片响应给客户端
         */
        VerifyCode verifyCode = new VerifyCode();
        BufferedImage image = verifyCode.getImage();
        request.getSession().setAttribute("vcode", verifyCode.getText());

        VerifyCode.output(image, response.getOutputStream());
    }
}
