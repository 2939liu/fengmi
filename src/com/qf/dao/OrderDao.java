package com.qf.dao;

import com.qf.entity.Order;

import java.util.List;

public interface OrderDao {
    public List<Order> fuzzySelectOrder(int pageNo, int pageSize, String condition);
    public int orderFuzzyDateCount(String condition);
}
