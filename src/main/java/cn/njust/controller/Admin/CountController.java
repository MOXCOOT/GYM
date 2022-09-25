package cn.njust.controller.Admin;

import cn.njust.Service.Admin.ViewAllService;
import cn.njust.Service.Admin.LogoutService;
import cn.njust.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "CountController", value = "/CountController")
public class CountController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Object queding = request.getParameter("ok2");
        User cus = (User) request.getSession().getAttribute("user");
        if(queding!=null)
        {
            String user_id = request.getParameter("user_id");
            LogoutService ls=new LogoutService();
            ls.logoutUser(user_id);
        }
        ViewAllService vs = new ViewAllService();
        request.setAttribute("userList",vs.viewUser());
        request.getRequestDispatcher("../page/administrator/count/allCount.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
