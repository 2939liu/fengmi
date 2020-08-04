package com.qf.service;

import com.qf.entity.Order;

import java.util.List;

public interface OrderService {
    public List<Order> fuzzySelectOrder(int pageNo, int pageSize, String condition);
    public int orderFuzzyDateCount(String condition);
}
