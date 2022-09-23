package cn.njust.controller;

import cn.njust.Service.Customer.ViewService;
import cn.njust.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "VenueController", value = "/VenueController")
public class VenueController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Object queding = request.getParameter("queding");

      //  System.out.println("访问VenueController"+queding);

        if(queding!=null)
        {
            System.out.println("hello"+request.getSession().getAttribute("vId"));
        }




        User cus = (User) request.getSession().getAttribute("user");
        ViewService vs = new ViewService();
        request.setAttribute("venueList",vs.viewVenue());
        request.getRequestDispatcher("../page/client/shop/venue.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
