package com.qf.dao.impl1;

import com.qf.dao.GoodsTypeDao;
import com.qf.entity.GoodsType;
import com.qf.utils.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GoodsTypeDaoImpl extends BaseDao implements GoodsTypeDao {
    @Override
    public List<GoodsType> seelectGoodsType(int pageNo) {
        String sql = "select id,typename from t_goodstype where 1=1 limit ?,3";
        Object[] obj = {(pageNo-1)*3};
        List<GoodsType> list = new ArrayList<>();
        try {
            ResultSet rs = this.select(sql, obj);
            while (rs.next()){
                GoodsType goodsType = new GoodsType();
                goodsType.setId(rs.getInt(1));
                goodsType.setTypeName(rs.getString(2));
                list.add(goodsType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public GoodsType getGoodsTypeById(int id) {
        String sql = "select * from t_goodstype where id = ?";
        Object[] obj = {id};
        GoodsType goodsType = null;
        try {
            ResultSet rs = this.select(sql, obj);
            while (rs.next()){
                goodsType = new GoodsType();
                goodsType.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return goodsType;
    }

    @Override
    public int selectTypeName(String typeName) {
        String sql = "select* from t_goodstype where typename = ?";
        Object[] obj = {typeName};
        try {
            ResultSet rs = this.select(sql, obj);
            while (rs.next()){
                if(rs.getInt(1) > 0 ){
                    return 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteGoodsType(int id) {
        String sql = "delete from t_goodstype where id = ?";
        Object[] obj = {id};
        int i = this.setUpdate(sql, obj);
        return i;
    }

    @Override
    public int updateGoodsType(String typeName,int id) {
        String sql = "update t_goodstype set typename = ? where id = ?";
        Object[] obj ={typeName,id,};
        int row = this.setUpdate(sql, obj);
        return row;
    }

    @Override
    public int addGoodsType(String typeName) {
        String sql = "insert into t_goodstype (typename) values(?)";
        Object[] obj = {typeName};
        int row = this.setUpdate(sql, obj);
        return row;
    }

}
