package com.qf.servlet;

import com.qf.dao.UserDao;
import com.qf.entity.User;
import com.qf.service.UserService;
import com.qf.service.impl.UserServiceImpl;
import com.qf.utils.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/UserFuzzyServlet")
public class UserFuzzyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String sex = request.getParameter("sex");
        System.out.println(sex);
        StringBuffer condition = new StringBuffer();
        if(username!=null&& !"".equals(username)){
            condition.append("and username like '%"+username +"%'");
        }
        if(sex!=null&&!"".equals(sex)){
            condition.append("and sex like '%"+sex+"%'");
        }
        UserService userService = new UserServiceImpl();
        int i = userService.userFuzzyDateCount(condition.toString());

        String pageNo = request.getParameter("pageNo");
        if(pageNo == null){
            pageNo = "1";
        }
        int pageNo1 = Integer.parseInt(pageNo);
        int pageSize = 3;

        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageNo(pageNo1);
        pageUtil.setDataCount(i);
        pageUtil.setPageSize(pageSize);
        int pageCount = pageUtil.getPageCount();
        String contextPath = request.getServletContext().getContextPath();

        List<User> list = userService.fuzzySelectUser(pageNo1, pageSize, condition.toString());
        request.setAttribute("list",list);
        request.setAttribute("pageNo",pageNo1);
        request.setAttribute("pageSize",pageSize);
        request.setAttribute("pageCount",pageCount);
        request.setAttribute("sex",sex);
        request.getRequestDispatcher("/after/user.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
