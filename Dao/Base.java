package com.yuuuzh.Dao;

import com.yuuuzh.Util.SQL;

import java.util.List;

/**
 * 2018/1/22 17:22
 */
public abstract class Base<M>{
    protected abstract String getTableName();
    protected abstract Class<M> getMClass();

    public List<M> findAll() {
        final String baseSql = "select * from " + this.getTableName();
        return SQL.query(baseSql,this.getMClass());
    }
    public M findById(int id){
        final String baseSql = "select * from " + this.getTableName() + " where id = " + id;
        List<M> result = SQL.query(baseSql,this.getMClass());
        if (null == result || 0 == result.size()) {
            return null;
        }
        return result.get(0);
    }
    public List<M> findByName(String name){
        final String baseSql = "select * from " + this.getTableName() + " where name = " + name;
        return SQL.query(baseSql,this.getMClass());
    }
    public void deleteById(int id) {
        final String baseSql = "delete from " + this.getTableName() + " where id = " + id;
        SQL.delete(baseSql);
    }

    //
    public boolean login(String name, String password){
        final String baseSql = "select * from " + this.getTableName() +
                " where name  = '" + name + "' and password = '" + password  + "'";
        return SQL.login(baseSql);
    }
}
