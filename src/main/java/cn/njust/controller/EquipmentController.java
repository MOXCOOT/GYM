package cn.njust.controller;

import cn.njust.Service.Customer.ViewService;
import cn.njust.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EquipmentController", value = "/EquipmentController")
public class EquipmentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        User cus = (User) request.getSession().getAttribute("user");
//        request.getRequestDispatcher("../page/client_order.jsp").forward(request, response);V

        ViewService vs = new ViewService();
        request.setAttribute("equipList",vs.viewEquipment());
//        System.out.println("12313213");
//        System.out.println(vs.viewEquipment());
        request.getRequestDispatcher("../page/client/shop/equipment.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
