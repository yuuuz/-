package com.yuuuzh.Dao;

import com.yuuuzh.model.Admin;

/**
 * 2018/2/6 13:57
 */
public class AdminDao extends Base{
    @Override
    protected String getTableName() {
        return "admin";
    }

    @Override
    protected Class getMClass() {
        return Admin.class;
    }

}
