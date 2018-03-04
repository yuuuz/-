package com.yuuuzh.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 2018/1/20 16:54
 */
public class DBUtil {
    static final String URL = "jdbc:mysql://localhost/test1";
    static final String USER = "root";
    static final String PASSWORD = "hhxxttxs123";
    static Connection connection = null;
    static Statement statement = null;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Statement open() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);//打开数据库连接
            statement = connection.createStatement();//准备执行
            return statement;
        } catch (Exception e) {
            System.out.println("Open error message:" + e);
        }
        return null;
    }

    public static void close() {
        try {
            if (null != statement) {
                statement.close();
            }
            if (null != connection) {
                connection.close();
            }
        } catch (Exception e) {
            System.out.println("Close error message:" + e);
        }
    }
}
