package com.qf.dao;

import com.qf.entity.User;

import java.util.List;

public interface UserDao {
    public List<User> fuzzySelectUser(int pageNo,int pageSize,String condition);
    public int userFuzzyDateCount(String condition);
    public int userDeleteById(int id);
    public int userResetresetPassword(String password,int id);
    public int userAdd(User user);
}
