package com.qf.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/LogOutServlet")
public class LogOutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession(false);
        String contextPath = request.getServletContext().getContextPath();
        if(httpSession != null){
            httpSession.invalidate();
        }
        Cookie cookie = new Cookie("JSESSIONID","");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        response.sendRedirect(contextPath+"/after/login.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
