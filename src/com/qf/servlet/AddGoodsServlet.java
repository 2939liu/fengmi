package com.qf.servlet;

import com.qf.entity.Goods;
import com.qf.service.GoodsService;
import com.qf.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/AddGoodsServlet")
public class AddGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goodsName = request.getParameter("goodsName");
        String price = request.getParameter("price");
        Double price1 = Double.parseDouble(price);
        String typeId = request.getParameter("typeId");
        String imgPath = request.getParameter("imgPath");
        String comment = request.getParameter("comment");

        int typeId1 = Integer.parseInt(typeId);
        Goods goods = new Goods();
        goods.setGoodsName(goodsName);
        goods.setPrice(price1);
        goods.setImgPath(imgPath);
        goods.setComment(comment);
        goods.setTypeId(typeId1);

        GoodsService goodsService = new GoodsServiceImpl();
        String contextPath = request.getServletContext().getContextPath();
        String id = request.getParameter("id");
        if(!"".equals(id)){
            int id1 = Integer.parseInt(id);
            int i = goodsService.updateGoods(goods,id1);
            if(i > 0){
                response.sendRedirect(contextPath+"/FuzzySelectGoods");
            }else {
                response.sendRedirect(contextPath+"/after/add_goods.jsp");
            }

        }else {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date1 = sdf.format(date);
            Date date2 = null;
            try {
                date2 = sdf.parse(date1);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            goods.setDeployDate(date2);
            int i = goodsService.addGoods(goods);
            if(i > 0){
                response.sendRedirect(contextPath+"/FuzzySelectGoods");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
