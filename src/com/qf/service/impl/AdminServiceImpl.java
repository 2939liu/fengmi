package com.qf.service.impl;

import com.qf.dao.AdminDao;
import com.qf.dao.impl1.AdminDaoImpl;
import com.qf.entity.User;
import com.qf.service.AdminService;

public class AdminServiceImpl implements AdminService {
    AdminDao adminDao = new AdminDaoImpl();
    public boolean login(User user) {
        return adminDao.login(user);
    }
}
