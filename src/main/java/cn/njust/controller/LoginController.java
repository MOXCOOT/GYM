package cn.njust.controller;

import cn.njust.Service.Customer.RegisterService;
import cn.njust.Service.Login.LoginService;

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
            RegisterService rg = new RegisterService();
            String Rg_result = rg.registerNew(name_sub,phone,pwd1,pwd2);
            request.getSession().setAttribute("message", Rg_result);
            request.getRequestDispatcher("../page/main.jsp").forward(request, response);
            System.out.println(Rg_result);
            //返回 3 代表手机号错误或已被注册
            //返回 2 代表有空空值
            //返回 1 代表两次密码不一致
            //返回 0 代表注册成功
            //检验两次密码是否一致
            //测试
        }

        if(login!=null)
        {
            System.out.println("login");
            LoginService lg=new LoginService();
            User loginNow=lg.login(name,pwd);
            if(lg.login(name,pwd)!=null)
            {
                request.getSession().setAttribute("user",loginNow);
                //正确登录，转到个人主页
                request.getRequestDispatcher("../page/client_order.jsp").forward(request, response);
            }
            else {
                request.getSession().setAttribute("message","登录错误！请重新登录");
                request.getRequestDispatcher("../page/main.jsp").forward(request, response);
            };
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
