package com.yuuuzh.service;

import com.yuuuzh.Dao.StudentDao;
import com.yuuuzh.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 2018/2/5 11:38
 */
public class StudentService {
    Scanner scanner = new Scanner(System.in);
    StudentDao studentDao = new StudentDao();
    List<Student>students = new ArrayList<>();

    public List<Student> queryAll() {
        return studentDao.findAll();
    }

    public void delete(int id) {
        studentDao.deleteById(id);
    }

    public void insert(Student student, String name, String password){
        student.setName(name);
        student.setPassword(password);
        students.add(student);
        this.studentDao.insert(student);
    }

    public void update(Student student,int id, String name, String password){
        student.setId(id);
        student.setName(name);
        student.setPassword(password);
        studentDao.update(student);
    }

    public boolean login(String name, String password){
        if(studentDao.login(name, password)){
            return true;
        }
        return false;
    }
}
