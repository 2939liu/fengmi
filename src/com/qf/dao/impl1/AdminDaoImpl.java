package com.qf.dao.impl1;

import com.qf.dao.AdminDao;
import com.qf.entity.User;
import com.qf.utils.BaseDao;
import com.qf.utils.BeanDao;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AdminDaoImpl extends BaseDao implements AdminDao {
    @Override
    public boolean login(User user) {
        String sql = "select * from t_user where username = ? && password = ?";
        Object[] obj = {user.getUsername(),user.getPassword()};

        try {
            ResultSet query = this.select(sql, obj);
            if(query.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
