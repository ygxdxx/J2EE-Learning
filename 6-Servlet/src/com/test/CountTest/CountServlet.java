package com.test.CountTest;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by wangsongyan on 2017/5/29.
 * email: wangsongyan921@163.com
 */
public class CountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext application = getServletContext();
        Integer count = (Integer) application.getAttribute("count");
        if (count == null) {
            application.setAttribute("count", 1);
        } else {
            application.setAttribute("count", count + 1);
        }

        //print to browser
        PrintWriter pw = resp.getWriter();
        pw.print("<h1>" + count + "</h1>");
    }
}
