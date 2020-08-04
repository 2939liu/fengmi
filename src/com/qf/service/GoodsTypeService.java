package com.qf.service;

import com.qf.entity.GoodsType;

import java.util.List;

public interface GoodsTypeService {
    public List<GoodsType> seelectGoodsType(int pageNo);
    public GoodsType getGoodsTypeById(int id);
    public int addGoodsType(String typeName);
    public int selectTypeName(String typeName);
    public int deleteGoodsType(int id);
    public int updateGoodsType(String typeName,int id);
}
