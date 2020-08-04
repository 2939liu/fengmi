package com.qf.servlet;

import com.qf.service.GoodsTypeService;
import com.qf.service.impl.GoodsTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GoodsTypeUpdateServlet")
public class GoodsTypeUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String typeName = request.getParameter("typename");
        System.out.println(typeName);
        String id = request.getParameter("id");
        int id1 = 0;
        if(!"".equals(id)){
            id1 = Integer.parseInt(id);
            System.out.println(id1);
        }
        String contextPath = request.getServletContext().getContextPath();
        GoodsTypeService goodsTypeService = new GoodsTypeServiceImpl();
        //如果传过来的数据没有id说明要添加
        if("".equals(id)){
            int i1 = goodsTypeService.selectTypeName(typeName);
            if(i1>0){//i1>0说明数据库中存在此类型，就不能再次插入了
                System.out.println("添加失败 ");
                response.sendRedirect(contextPath+"/after/add_goods_type.jsp");
            }else {
                int i2 = goodsTypeService.addGoodsType(typeName);
                if(i2>0){
                    System.out.println("商品类型插入成功");
                    response.sendRedirect(contextPath+"/GoodsTypeSelectServlet");
                }
            }
        }else {//如果有id说明要修改
            int i1 = goodsTypeService.selectTypeName(typeName);
            if(i1>0){//i1>0说明数据库中存在此类型，就不能再次插入了
                System.out.println("修改失败 ");
                response.sendRedirect(contextPath+"/GoodsTypeSelectServlet");
            }else {
                int row = goodsTypeService.updateGoodsType(typeName, id1);
                if(row > 0){
                    System.out.println("修改成功");
                    response.sendRedirect(contextPath+"/GoodsTypeSelectServlet");
                }
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
