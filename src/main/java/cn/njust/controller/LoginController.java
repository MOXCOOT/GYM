package cn.njust.controller;

import cn.njust.Service.Login.Login;
import cn.njust.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginController", urlPatterns = "/servlet/LoginController")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("UTF-8");
        String loginname = request.getParameter("loginname");
        String password = request.getParameter("password");
        Login b=new Login();
        User user=new User(loginname,password);
        int result=b.login(user);
        System.out.println(result);
        if(result==0)
        {
            response.sendRedirect("http://localhost:8080/GYM_manage/page/client_venue.jsp");
        }
        else
            response.sendRedirect("http://localhost:8080/GYM_manage/page/login.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
