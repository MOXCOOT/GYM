package cn.njust.controller.Customer;

import cn.njust.Service.Customer.RegisterService;
import cn.njust.Service.Customer.ReuserService;
import cn.njust.Service.Login.LoginService;

import cn.njust.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserController", value = "/UserController")
public class UserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String user_id=request.getParameter("user_id");
        String user_name=request.getParameter("user_name");
        String number=request.getParameter("user_number");
        String password1=request.getParameter("password1");
        String password2=request.getParameter("password2");
        Object aa=request.getParameter("ok2");
        if (aa==null)
        request.getRequestDispatcher("../page/client/person/modification.jsp").forward(request, response);
        if(aa!=null)
        {
            ReuserService rus=new ReuserService();
            String result=rus.changeUserInfo(number,password1,password2,user_id,user_name);
            request.getSession().setAttribute("message", result);
           request.getRequestDispatcher("../page/main.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
