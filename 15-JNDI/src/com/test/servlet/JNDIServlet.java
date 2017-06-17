package com.test.servlet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by wangsongyan on 2017/6/17.
 * email: wangsongyan921@163.com
 */
@WebServlet(name = "JNDIServlet", value = "/JNDIServlet")
public class JNDIServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Context context = new InitialContext();
            //Context envContext = (Context) context.lookup("java:comp/env"); //fix format
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/dataSource");
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
    }
}
