package com.qf.servlet;

import com.qf.service.GoodsTypeService;
import com.qf.service.impl.GoodsTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TypeDeleteServlet")
public class TypeDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int id1 = Integer.parseInt(id);
        GoodsTypeService goodsTypeService = new GoodsTypeServiceImpl();
        int i = goodsTypeService.deleteGoodsType(id1);
        String contextPath = request.getServletContext().getContextPath();
        if(i > 0){
            System.out.println("删除成功");
            response.sendRedirect(contextPath+"/GoodsTypeSelectServlet");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
