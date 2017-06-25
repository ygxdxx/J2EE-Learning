package com.indiv.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wangsongyan on 2017/6/25.
 * email: wangsongyan921@163.com
 */
@WebServlet(name = "BServlet", value = "/BServlet")
public class BServlet extends BaseServlet2 {

    public String func1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("func1...");
        return "/index.jsp";
    }

    public String func2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("func2...");
        return "r:/index.jsp";
    }

    public String func3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("func3...");
        return null;
    }
}
