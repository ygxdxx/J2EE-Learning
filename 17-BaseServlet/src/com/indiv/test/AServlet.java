package com.indiv.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by wangsongyan on 2017/6/24.
 * email: wangsongyan921@163.com
 */
@WebServlet(name = "AServlet", value = "/AServlet")
public class AServlet extends BaseServlet2 {

    public void addUser(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("addUser...");
    }

    public void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("deleteUser...");
    }

    protected void queryUser(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("queryUser...");
    }
}

