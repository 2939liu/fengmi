package com.qf.servlet;

import com.qf.entity.Goods;
import com.qf.entity.Order;
import com.qf.service.GoodsService;
import com.qf.service.OrderService;
import com.qf.service.impl.GoodsServiceImpl;
import com.qf.service.impl.OrderServiceImpl;
import com.qf.utils.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/OrderFuzzySelectServlet")
public class OrderFuzzySelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        StringBuffer condition = new StringBuffer();
        if(username != null && !"".equals(username)){
            condition.append("and t1.username like '%" + username + "%'");
        }
        OrderService orderService = new OrderServiceImpl();
        int i = orderService.orderFuzzyDateCount(condition.toString());
        String pageNo = request.getParameter("pageNo");
        if(pageNo == null){
            pageNo = "1";
        }
        int pageNo1 = Integer.parseInt(pageNo);
        PageUtil pageUtil = new PageUtil();
        int pageSize = 3;
        pageUtil.setPageSize(pageSize);
        pageUtil.setPageNo(pageNo1);
        pageUtil.setDataCount(i);
        int pageCount = pageUtil.getPageCount();

        List<Order> list = orderService.fuzzySelectOrder(pageNo1, pageSize, condition.toString());
        request.setAttribute("list",list);
        request.setAttribute("pageNo",pageNo1);
        request.setAttribute("pageCount",pageCount);
        String contextPath = request.getServletContext().getContextPath();
        request.getRequestDispatcher("/after/order_processing_list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
