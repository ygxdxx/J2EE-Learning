package com.test.user.servlet;

import com.test.user.util.VerifyCodeUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by wangsongyan on 2017/6/7.
 * email: wangsongyan921@163.com
 */
@WebServlet(name = "VerifyCodeServlet", value = "/VerifyCodeServlet")
public class VerifyCodeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VerifyCodeUtil verifyCodeUtil = new VerifyCodeUtil();
        BufferedImage bufferedImage = verifyCodeUtil.getImage();
        String codeText = verifyCodeUtil.getText();
        request.getSession().setAttribute("verifyCode", codeText);
        VerifyCodeUtil.output(bufferedImage,response.getOutputStream());
    }
}
