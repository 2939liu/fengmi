package com.qf.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter("/*")
public class Filter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest)  req).getSession(false);
        HttpServletResponse response = (HttpServletResponse)resp;
        String requestURI = ((HttpServletRequest)  req).getRequestURI();
        String contextPath = req.getServletContext().getContextPath();
        if(requestURI.endsWith("/login.jsp")||requestURI.endsWith("/LoginServlet") ||requestURI.endsWith("/register.html")
                || requestURI.endsWith("/RegisterService") || requestURI.endsWith(".css") || requestURI.endsWith(".js")){
            chain.doFilter( req, resp);
            //如果已经登陆过要去其他页面，也要经过过滤器，只有session在有效期内才能成功
        }else if(session!=null && session.getAttribute("username") !=null){
            chain.doFilter( req, resp);
        }else if(session == null || session.getAttribute("username") == null){
            response.sendRedirect(contextPath+"/after/login.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
