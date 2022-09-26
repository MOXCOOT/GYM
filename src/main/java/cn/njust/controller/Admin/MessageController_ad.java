package cn.njust.controller.Admin;

import cn.njust.Service.Admin.ViewAllService;
import cn.njust.Service.Customer.ViewService;
import cn.njust.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MessageController_ad", value = "/MessageController_ad")
public class MessageController_ad extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ViewService ms = new ViewService();
        ViewAllService vs=new ViewAllService();
        String m=request.getParameter("push");
        String id=request.getParameter("order_id");
        String cus=request.getParameter("user_id");
        request.setAttribute("orderList",vs.viewOrder());
        if(m!=null)
        ms.sendMessage(cus,id);
        request.getRequestDispatcher("../page/administrator/order/hurry.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
