package cn.njust.controller;

import cn.njust.Service.Customer.Register;
import cn.njust.Service.Login.Login;
import cn.njust.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginController", value = "/LoginController")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();

        String name_sub = request.getParameter("name_sub");
        String name=request.getParameter("name");
        String pwd1=request.getParameter("pwd1");
        String pwd2=request.getParameter("pwd2");
        String phone=request.getParameter("phone");
        String pwd=request.getParameter("pwd");

        String sub=request.getParameter("sub");
        String login=request.getParameter("login");

        if(sub!=null)
        {
            System.out.println("sub");
            Register rg = new Register();
            int Rg_result = rg.registerNew(name_sub,phone,pwd1,pwd2);
        }

        if(login!=null)
        {
            System.out.println("login");
            Login lg=new Login();
//            if(lg.login(name,pwd)==1)
//            {
//                //正确登录，转到个人主页
//
//            }
            request.getRequestDispatcher("../page/client_order.jsp").forward(request, response);
        }


        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("    This is ");
        out.print(this.getClass());
        out.println(", using the GET method");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
