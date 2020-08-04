package com.qf.servlet;

import com.qf.service.GoodsService;
import com.qf.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/DeletGoodsServlet")
public class DeletGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] goodsIds = request.getParameterValues("goodsid");
        String[] split = goodsIds[0].split(",");
        List list = new ArrayList();

        for(int i = 0; i<split.length; i++){
         if(!split[i].equals("")){
             System.out.println(split[i]);
             list.add(split[i]);
         }
       }
        GoodsService goodsService = new GoodsServiceImpl();
        int i = goodsService.deleteGoods(list);
        String contextPath = request.getServletContext().getContextPath();
        if(i > 0){
            System.out.println("删除成功");
            response.sendRedirect(contextPath+"/FuzzySelectGoods");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
