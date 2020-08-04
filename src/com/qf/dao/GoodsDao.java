package com.qf.dao;

import com.qf.entity.Goods;

import java.util.List;

public interface GoodsDao {
    public List<Goods> fuzzySelectGoods(int pageNo, int pageSize, String condition);
    public int goodsFuzzyDateCount(String condition);
    public int addGoods(Goods goods);
    public int deleteGoods(List list);
    public Goods getGoodsById(int id1);
    public int updateGoods(Goods goods,int id);
}
