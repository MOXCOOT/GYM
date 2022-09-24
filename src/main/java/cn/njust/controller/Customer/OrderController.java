package cn.njust.controller.Customer;

import cn.njust.Service.Customer.ViewService;
import cn.njust.entity.User;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "OrderController", value = "/OrderController")
public class OrderController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        User cus = (User) request.getSession().getAttribute("user");
        ViewService vs = new ViewService();
        //System.out.println(vs.viewOrder(cus.getId()));
        request.setAttribute("orderList",vs.viewOrder(cus.getId()));
        request.getRequestDispatcher("../page/client/order/client_order.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
