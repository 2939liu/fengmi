package com.qf.utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //1.获取请求中method参数的名字
        String methodName = req.getParameter("method");
        System.out.println("BaseServlet"+methodName);
        /*
         * 2.获取class的类对象，获取的是当前的servlet的类对象
         *
         *
         * 获取的是class类对象，并且是有泛型的约束的，要求必须是BaseServlet或者BaseServlet子类
         * */

        Class<? extends BaseServlet> aClass = this.getClass();
        System.out.println("BaseServlet"+aClass);
        /*
         * 3.根据methodName和类对象获取对应的方法,
         * add(HttpServletRequest request, HttpServletResponse response)
         * 业务逻辑代码都是需要HttpServletRequest， HttpServletResponse
         * */
        try {
            Method method = aClass.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            System.out.println("BaseServlet"+method);
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
