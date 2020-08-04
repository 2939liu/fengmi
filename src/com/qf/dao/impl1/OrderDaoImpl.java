package com.qf.dao.impl1;

import com.qf.dao.OrderDao;
import com.qf.entity.Order;
import com.qf.utils.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public List<Order> fuzzySelectOrder(int pageNo, int pageSize, String condition) {
        String sql = "select * from (select t_order.id,t_order.orderCode,t_order.totalPrice,t_order.createDate,t_user.username,t_status.order_status FROM t_order INNER JOIN t_user ON t_order.uid = t_user.id INNER JOIN t_status ON t_order.status = t_status.id) as t1 where 1=1 "+condition+" limit ?,?";
        Object[] obj = {(pageNo-1)*pageSize,pageSize};
        List<Order> list = new ArrayList<>();
        try {
            ResultSet rs = this.select(sql, obj);
            while(rs.next()){
               Order order = new Order();
               order.setId(rs.getInt(1));
               order.setOrderCode(rs.getString(2));
               order.setTotalPrice(rs.getDouble(3));
               order.setCreatDate(rs.getDate(4));
               order.setUser(rs.getString(5));
               order.setStatus1(rs.getString(6));
                list.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int orderFuzzyDateCount(String condition) {
        String sql = "select count(1) from t_order where 1=1 "+condition;
        Object[] obj = {};
        int count = 0;
        try {
            ResultSet rs = this.select(sql,obj);
            while (rs.next()){
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}
