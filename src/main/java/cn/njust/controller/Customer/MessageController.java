package cn.njust.controller.Customer;

import cn.njust.Service.Customer.ViewService;
import cn.njust.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MessageController", value = "/MessageController")
public class MessageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User cus = (User) request.getSession().getAttribute("user");
        ViewService vs = new ViewService();
        request.setAttribute("messageList",vs.viewMessage(cus.getId()));
        request.getRequestDispatcher("../page/client/person/message.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
