package com.qf.servlet;

import com.qf.service.UserService;
import com.qf.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserResetresetServlet")
public class UserResetresetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int uid = Integer.parseInt(id);
        UserService userService = new UserServiceImpl();
        String password = "123456";
        int i = userService.userResetresetPassword(password, uid);
        String contextPath = request.getServletContext().getContextPath();
        if(i>0){
            System.out.println("重置成功");
            response.sendRedirect(contextPath+"/UserFuzzyServlet");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
