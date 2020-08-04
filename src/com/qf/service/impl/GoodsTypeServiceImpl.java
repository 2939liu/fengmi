package com.qf.service.impl;

import com.qf.dao.GoodsTypeDao;
import com.qf.dao.impl1.GoodsTypeDaoImpl;
import com.qf.entity.GoodsType;
import com.qf.service.GoodsTypeService;

import java.util.List;

public class GoodsTypeServiceImpl implements GoodsTypeService {
    @Override
    public List<GoodsType> seelectGoodsType(int pageNo) {
        GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
        return goodsTypeDao.seelectGoodsType(pageNo);
    }

    @Override
    public GoodsType getGoodsTypeById(int id) {
        GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
        return goodsTypeDao.getGoodsTypeById(id);
    }

    @Override
    public int selectTypeName(String typeName) {
        GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
        return goodsTypeDao.selectTypeName(typeName);
    }

    @Override
    public int deleteGoodsType(int id) {
        GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
        return goodsTypeDao.deleteGoodsType(id);
    }

    @Override
    public int updateGoodsType(String typeName, int id) {
        GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
        return goodsTypeDao.updateGoodsType(typeName,id);
    }

    @Override
    public int addGoodsType(String typeName) {
        GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
        return goodsTypeDao.addGoodsType(typeName);
    }

}
