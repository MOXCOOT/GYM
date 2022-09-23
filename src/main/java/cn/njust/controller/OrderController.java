package cn.njust.controller;

import cn.njust.Service.Customer.ViewService;
import cn.njust.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "OrderController", value = "/OrderController")
public class OrderController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        User cus = (User) request.getSession().getAttribute("user");
        System.out.println("success");
//        request.getRequestDispatcher("../page/client_order.jsp").forward(request, response);V

        ViewService vs = new ViewService();
        request.setAttribute("orderList",vs.viewOrder(cus.getId()));
        request.getRequestDispatcher("../page/client/order/client_order.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
