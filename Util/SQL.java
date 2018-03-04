package com.yuuuzh.Util;

import com.yuuuzh.model.Student;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 2018/1/22 17:43
 */
public class SQL{

    public  static <T> List<T> query(final String sql,Class<T> clazz) {
        List<T> results = new ArrayList<>();
        try {
            Statement statement = DBUtil.open();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                String password = resultSet.getString(3);
                T temp = clazz.newInstance();

            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return results;
    }

    public static void delete(final String sql) {
        try {
            Statement statement = DBUtil.open();
            statement.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
    }

    public static void update(final String sql) {
        try {
            Statement statement = DBUtil.open();

            statement.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
    }

    public static void insert(final String sql) {
        try {
            Statement statement = DBUtil.open();

            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
    }

    public static boolean login(String sql){
        try{
            Statement statement = DBUtil.open();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return false;
    }
}
