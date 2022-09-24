package cn.njust.controller.Customer;

import cn.njust.Service.Customer.RentService;
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

//        Object queding = request.getParameter("123");
        Object queding = request.getParameter("ok");

        User cus = (User) request.getSession().getAttribute("user");
        System.out.println(queding);
        if(queding!=null)
        {
            String venue_id = request.getParameter("venue_id");
            String venue_name = request.getParameter("venue_name");
            String hours =  request.getParameter("hours");
            System.out.println(venue_name);
            RentService rs=new RentService();
            rs.venueOrder(cus.getId(),venue_name,venue_id,Integer.parseInt(hours));
        }
        ViewService vs = new ViewService();
        request.setAttribute("venueList",vs.viewVenue());
        request.getRequestDispatcher("../page/client/shop/venue.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
