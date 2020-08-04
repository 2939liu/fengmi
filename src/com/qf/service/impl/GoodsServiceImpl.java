package com.qf.service.impl;

import com.qf.dao.GoodsDao;
import com.qf.dao.impl1.GoodsDaoImpl;
import com.qf.entity.Goods;
import com.qf.service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    GoodsDao goodsDao = new GoodsDaoImpl();
    @Override
    public List<Goods> fuzzySelectGoods(int pageNo, int pageSize, String condition) {
        List<Goods> list = goodsDao.fuzzySelectGoods(pageNo, pageSize, condition);
        return list;
    }

    @Override
    public int goodsFuzzyDateCount(String condition) {
        return goodsDao.goodsFuzzyDateCount(condition);
    }

    @Override
    public int addGoods(Goods goods) {
        return goodsDao.addGoods(goods);
    }

    @Override
    public int deleteGoods(List list) {
        return goodsDao.deleteGoods(list);
    }

    @Override
    public Goods getGoodsById(int id1) {
        return goodsDao.getGoodsById(id1);
    }

    @Override
    public int updateGoods(Goods goods,int id) {
        return goodsDao.updateGoods(goods,id);
    }
}
