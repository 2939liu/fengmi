package com.qf.dao.impl1;

import com.qf.dao.GoodsDao;
import com.qf.entity.Goods;
import com.qf.utils.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsDaoImpl extends BaseDao implements GoodsDao {

    @Override
    public List<Goods> fuzzySelectGoods(int pageNo, int pageSize, String condition) {
        String sql = "select t_goods.id,t_goods.goodsName, t_goods.price,t_goods.imgPath,t_goods.deployDate,t_goodstype.typename, t_goods.comment from t_goods\n" +
                " join t_goodstype on t_goods.typeId = t_goodstype.id where 1=1 "+condition+" limit ?,?";
        Object[] obj = {(pageNo-1)*pageSize,pageSize};
        List<Goods> list = new ArrayList<>();
        try {
            ResultSet rs = this.select(sql, obj);
            while(rs.next()){
                Goods goods = new Goods();
                goods.setId(rs.getInt(1));
                goods.setGoodsName(rs.getString(2));
                goods.setPrice(rs.getDouble(3));
                goods.setImgPath(rs.getString(4));
                goods.setDeployDate(rs.getDate(5));
                goods.setType(rs.getString(6));
                goods.setComment(rs.getString(7));
                list.add(goods);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int goodsFuzzyDateCount(String condition) {
        String sql = "select count(1) from t_goods where 1=1 "+condition;
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

    @Override
    public int addGoods(Goods goods) {
        String goodsName = goods.getGoodsName();
        double price = goods.getPrice();
        int typeId = goods.getTypeId();
        String imgPath = goods.getImgPath();
        String comment = goods.getComment();
        Date deployDate = goods.getDeployDate();
        String sql = "insert into t_goods (goodsName,price,deployDate,imgPath,comment,typeId) values(?,?,?,?,?,?)";
        Object[] obj = {goodsName,price,deployDate,imgPath,comment,typeId};
        int i = 0;
        try {
           i = this.setUpdate(sql, obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int deleteGoods(List list) {
        int row = 0;
        for (int i = 0; i< list.size(); i++){
            String sql = "delete from t_goods where id = ?";
            Object[] obj ={list.get(i)};
            row = this.setUpdate(sql, obj);
            if(row>1){
                row++;
            }
        }
        return row;
    }

    @Override
    public Goods getGoodsById(int id1) {
        String sql = "select * from t_goods where id = ?";
        Object[] obj = {id1};
        Goods goods = null;
        try {
            ResultSet rs = this.select(sql, obj);
            while (rs.next()){
                goods = new Goods();
                goods.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return goods;
    }

    @Override
    public int updateGoods(Goods goods,int id) {
        String sql = "update t_goods set goodsName = ?,price = ?,imgPath = ?,comment=?,typeId = ? where id = ?";
        String goodsName = goods.getGoodsName();
        System.out.println(goodsName);
        double price = goods.getPrice();
        String imgPath = goods.getImgPath();
        String comment = goods.getComment();
        int typeId = goods.getTypeId();
        Object[] obj = {goodsName,price,imgPath,comment,typeId,id};
        int i = this.setUpdate(sql, obj);
        return i;
    }
}
