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

        Object queding = request.getParameter("123");
        if(queding!=null)
        {
            String venue_id = request.getParameter("venue_id");
            String venue_name = request.getParameter("venue_name");
            String hours =  request.getParameter("hours");
            System.out.println(venue_id+" "+ venue_name+" "+ hours);

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
