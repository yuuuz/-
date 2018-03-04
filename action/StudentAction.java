package com.yuuuzh.action;

import com.yuuuzh.model.Student;
import com.yuuuzh.service.AdminService;
import com.yuuuzh.service.StudentService;
import com.yuuuzh.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 2018/2/6 18:34
 */
@WebServlet("/student")
public class StudentAction extends HttpServlet{
    StudentService studentService = new StudentService();
    Student student = new Student();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String type = request.getParameter("type");
        if (type.equals("f1")){
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            studentService.insert(student, name, password);
            out.println("insert success!");
        }
        if (type.equals("f2")){
            String del = request.getParameter("id");
            int id = Integer.parseInt(del);
            studentService.delete(id);
            out.println("delete success!");
        }
        if (type.equals("f3")){
            String up = request.getParameter("id");
            int id = Integer.parseInt(up);
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            studentService.update(student,id, name, password);
            out.println("update success!");
        }if (type.equals("f4")){
            studentService.queryAll();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
