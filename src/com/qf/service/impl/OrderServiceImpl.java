package com.qf.service.impl;

import com.qf.dao.OrderDao;
import com.qf.dao.impl1.OrderDaoImpl;
import com.qf.entity.Order;
import com.qf.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    OrderDao orderDao = new OrderDaoImpl();
    @Override
    public List<Order> fuzzySelectOrder(int pageNo, int pageSize, String condition) {
        return orderDao.fuzzySelectOrder(pageNo, pageSize, condition);
    }

    @Override
    public int orderFuzzyDateCount(String condition) {
        return orderDao.orderFuzzyDateCount(condition);
    }
}
