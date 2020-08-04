package com.qf.service;

import com.qf.entity.Goods;

import java.util.List;

public interface GoodsService {
    public List<Goods> fuzzySelectGoods(int pageNo, int pageSize, String condition);
    public int goodsFuzzyDateCount(String condition);
    public int addGoods(Goods goods);
    public int deleteGoods(List list);
    public Goods getGoodsById(int id1);
    public int updateGoods(Goods goods,int id);
}
