package com.qf.dao.impl1;

import com.qf.dao.UserDao;
import com.qf.entity.User;
import com.qf.utils.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl1 extends BaseDao implements UserDao {
    @Override
    public List<User> fuzzySelectUser(int pageNo, int pageSize, String condition) {
        String sql = "select * from t_user where 1=1 "+condition+" limit ?,?";
        Object[] obj = {(pageNo-1)*pageSize,pageSize};
        List list = new ArrayList();
        try {
            ResultSet rs = this.select(sql, obj);
            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setPhone(rs.getString(4));
                user.setSex(rs.getString(6));
                user.setMail(rs.getString(7));
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int userFuzzyDateCount(String condition) {
        String sql = "select count(1) from t_user where 1=1 "+condition;
        Object[] obj = {};
        int count = 0;
        try {
            ResultSet rs1 = this.select(sql, obj);
            while (rs1.next()){
                count = rs1.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int userDeleteById(int id) {
        String sql = "delete from t_user where id = ?";
        Object[] obj = {id};
        int count = this.setUpdate(sql, obj);
        return count;
    }

    @Override
    public int userResetresetPassword(String password ,int id) {
        String sql = "update t_user set password = ? where id = ?";
        Object[] obj = {password,id};
        int i = this.setUpdate(sql, obj);
        return i;
    }

    @Override
    public int userAdd(User user) {
        String sql = "insert into t_user (username,password,phone,mail) values(?,?,?,?)";
        String username = user.getUsername();
        String password = user.getPassword();
        String phone = user.getPhone();
        String mail = user.getMail();
        Object[] obj = {username,password,phone,mail};
        int i = this.setUpdate(sql, obj);
        return i;
    }
}
