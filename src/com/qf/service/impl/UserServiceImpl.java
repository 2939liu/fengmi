package com.qf.service.impl;

import com.qf.dao.UserDao;
import com.qf.dao.impl1.UserDaoImpl1;
import com.qf.entity.User;
import com.qf.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public List<User> fuzzySelectUser(int pageNo, int pageSize, String condition) {
        UserDao userDao = new UserDaoImpl1();
        return userDao.fuzzySelectUser(pageNo, pageSize, condition);
    }

    @Override
    public int userFuzzyDateCount(String condition) {
        UserDao userDao = new UserDaoImpl1();
        return userDao.userFuzzyDateCount(condition);
    }

    @Override
    public int userDeleteById(int id) {
        UserDao userDao = new UserDaoImpl1();
        return userDao.userDeleteById(id);
    }

    @Override
    public int userResetresetPassword(String password, int id) {
        UserDao userDao = new UserDaoImpl1();
        return  userDao.userResetresetPassword(password, id);
    }

    @Override
    public int userAdd(User user) {
        UserDao userDao = new UserDaoImpl1();
        return userDao.userAdd(user);
    }
}
