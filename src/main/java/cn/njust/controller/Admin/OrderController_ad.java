package cn.njust.controller.Admin;

import cn.njust.Service.Admin.ViewAllService;
import cn.njust.Service.Customer.ViewService;
import cn.njust.dao.OrderDao;
import cn.njust.entity.User;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "OrderController_ad", value = "/OrderController_ad")
public class OrderController_ad extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ViewAllService vs = new ViewAllService();
        request.setAttribute("orderList",vs.viewOrder());
        request.getRequestDispatcher("../page/administrator/order/allOrder.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
