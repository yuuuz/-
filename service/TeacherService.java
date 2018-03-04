package com.yuuuzh.service;

import com.yuuuzh.Dao.TeacherDao;
import com.yuuuzh.model.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 2018/1/22 17:36
 */
public class TeacherService {
    Scanner scanner = new Scanner(System.in);
    TeacherDao teacherDao = new TeacherDao();
    List<Teacher> teachers = new ArrayList<>();

    public List<Teacher> queryAll() {
        return teacherDao.findAll();
    }

    public void delete() {
        System.out.println("请输入要删除的老师id：");
        int id = scanner.nextInt();
        teacherDao.deleteById(id);
    }

    public void insert(Teacher teacher){
        System.out.println("请输入老师姓名：");
        String name = scanner.next();
        teacher.setName(name);
        System.out.println("请输入老师密码：");
        String password = scanner.next();
        teacher.setPassword(password);
        teachers.add(teacher);
        this.teacherDao.insert(teacher);
    }

    public void update(Teacher teacher){
        System.out.println("请输入要修改的老师id：");
        int id = scanner.nextInt();
        teacher.setId(id);
        System.out.println("请输入更新后的老师姓名：");
        String name = scanner.next();
        teacher.setName(name);
        System.out.println("请输入更新后的老师密码：");
        String password = scanner.next();
        teacher.setPassword(password);
        teacherDao.update(teacher);
    }

    public boolean login(String name, String password){
        if(teacherDao.login(name, password)){
            return true;
        }
        return false;
    }
}
