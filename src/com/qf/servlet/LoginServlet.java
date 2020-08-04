package com.qf.servlet;

import com.qf.entity.User;
import com.qf.service.AdminService;
import com.qf.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username,password);
        AdminService adminService = new AdminServiceImpl();
        boolean login = adminService.login(user);
        String contextPath = request.getServletContext().getContextPath();

        if(login == true){
            HttpSession session = request.getSession();
            Cookie cookie = new Cookie("JSESSIONID",session.getId());
            cookie.setMaxAge(300);
            response.addCookie(cookie);
            session.setAttribute("username",username);
            response.sendRedirect(contextPath+"/UserFuzzyServlet");
        }else {
            response.sendRedirect(contextPath+"/after/login.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
