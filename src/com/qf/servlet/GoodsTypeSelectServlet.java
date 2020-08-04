package com.qf.servlet;

import com.qf.entity.GoodsType;
import com.qf.service.GoodsTypeService;
import com.qf.service.impl.GoodsTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/GoodsTypeSelectServlet")
public class GoodsTypeSelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.getParameter("");
        GoodsTypeService goodsTypeService = new GoodsTypeServiceImpl();
        List<GoodsType> list = goodsTypeService.seelectGoodsType(1);
        request.setAttribute("list",list);
        request.getRequestDispatcher("/after/goods_type_list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
