package com.test.servelt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by wangsongyan on 2017/6/17.
 * email: wangsongyan921@163.com
 */
@WebServlet(name = "TestServlet", value = "/TestServlet")
public class TestServlet extends BaseServlet {

   public void addUser(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

   }

    public void editUser(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

    }

    public void deleteUser(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

    }

    public void loadUser(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

    }

}
