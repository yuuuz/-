package com.yuuuzh.service;

import com.yuuuzh.Dao.AdminDao;

/**
 * 2018/2/6 14:57
 */
public class AdminService {
    AdminDao adminDao = new AdminDao();
    public boolean login(String name, String password){
        if(adminDao.login(name, password)){
            return true;
        }
        return false;
    }
}
