package cn.njust.controller.Customer;

import cn.njust.Service.Customer.ReturnService;
import cn.njust.Service.Customer.ViewService;
import cn.njust.dao.OrderDao;
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
        Object que=request.getParameter("return");
        String oid=request.getParameter("order_id");
        User cus = (User) request.getSession().getAttribute("user");
        if(que!=null)
        {
            ReturnService rs=new ReturnService();
            rs.returnBack(oid);
        }
        ViewService vs = new ViewService();
        request.setAttribute("orderList",vs.viewOrder(cus.getId()));
        request.getRequestDispatcher("../page/client/order/client_order.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
