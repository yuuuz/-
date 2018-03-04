package com.yuuuzh.Dao;

import com.yuuuzh.Util.SQL;
import com.yuuuzh.model.Teacher;

/**
 * 2018/1/22 17:23
 */
public class TeacherDao extends Base{
    protected Class<Teacher> getMClass() {
        return Teacher.class;
    }


    public void insert(Teacher teacher) {
        StringBuffer sql = new StringBuffer("insert into teacher(name, password) values(");
        sql.append("\"" + teacher.getName() + "\"" + ",");
        sql.append("\"" + teacher.getPassword() + "\"" + ")");
        SQL.insert(sql.toString());
    }


    public void update(Teacher teacher) {
        StringBuffer sql = new StringBuffer("update teacher set ");
        if(null != teacher.getName() && 0 != teacher.getName().length()) {
            sql.append("name = ").append("\"" + teacher.getName() + "\"");
        }
        if(null != teacher.getPassword() && 0 != teacher.getPassword().length()) {
            sql.append(" , password = ").append("\"" + teacher.getPassword() + "\"");
        }
        sql.append(" where id = " + teacher.getId());
        SQL.update(sql.toString());
    }

    @Override
    public String  getTableName() {
        return "teacher";
    }
}
