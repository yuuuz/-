package com.yuuuzh.Dao;

import com.yuuuzh.Util.SQL;
import com.yuuuzh.model.Student;

/**
 * 2018/2/5 11:32
 */
public class StudentDao extends Base{
    public void insert(Student student) {
        StringBuffer sql = new StringBuffer("insert into student(name, password) values(");
        sql.append("\"" + student.getName() + "\"" + ",");
        sql.append("\"" + student.getPassword() + "\"" + ")");
        SQL.insert(sql.toString());
    }


    public void update(Student student) {
        StringBuffer sql = new StringBuffer("update student set ");
        if(null != student.getName() && 0 != student.getName().length()) {
            sql.append("name = ").append("\"" + student.getName() + "\"");
        }
        if(null != student.getPassword() && 0 != student.getPassword().length()) {
            sql.append(" , password = ").append("\"" + student.getPassword() + "\"");
        }
        sql.append(" where id = " + student.getId());
        SQL.update(sql.toString());
    }

    @Override
    public String  getTableName() {
        return "student";
    }

    @Override
    protected Class getMClass() {
        return Student.class;
    }
}
