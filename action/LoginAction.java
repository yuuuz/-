package com.yuuuzh.action;

import com.yuuuzh.Dao.AdminDao;
import com.yuuuzh.Dao.StudentDao;
import com.yuuuzh.Dao.TeacherDao;
import com.yuuuzh.service.AdminService;
import com.yuuuzh.service.StudentService;
import com.yuuuzh.service.TeacherService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * 2018/2/3 11:51
 */
@WebServlet("/login")
public class LoginAction extends HttpServlet{
    TeacherService teacherService = new TeacherService();
    StudentService studentService = new StudentService();
    AdminService adminService = new AdminService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型

//        HttpSession session = request.getSession(true);
//
//        Cookie user = new Cookie("user",request.getParameter("user"));
//        Cookie password = new Cookie("password",request.getParameter("password"));
//        user.setMaxAge(60*60);
//        password.setMaxAge(60*60);
//        response.addCookie(user);
//        response.addCookie(password);
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        String a = request.getParameter("users");
//        PrintWriter out = response.getWriter();
        if (a.equals("admin")&&adminService.login(user,password)){
            request.getRequestDispatcher("/admin.jsp").forward(request,response);
        }else if (a.equals("teacher")&&teacherService.login(user,password)){
            request.getRequestDispatcher("/teacher.jsp").forward(request,response);
        }else if (a.equals("student")&&studentService.login(user,password)){
            request.getRequestDispatcher("/student.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }

        response.setContentType("text/html;charset=UTF-8");
    }

    // 处理 POST 方法请求的方法
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
