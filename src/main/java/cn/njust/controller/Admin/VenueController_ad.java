package cn.njust.controller.Admin;

import cn.njust.Service.Admin.EquipmentService;
import cn.njust.Service.Admin.VenueService;
import cn.njust.Service.Admin.ViewAllService;
import cn.njust.Service.Customer.RentService;
import cn.njust.Service.Customer.ViewService;
import cn.njust.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "VenueController_ad", value = "/VenueController_ad")
public class VenueController_ad extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Object quedingadd = request.getParameter("ok2");
        Object quedingupdate = request.getParameter("p2");
        if(quedingadd!=null)
        {
            String venue_name = request.getParameter("vname");
            int venue_price = Integer.parseInt(request.getParameter("vprice"));
            String venue_state = request.getParameter("vstate");
            String venue_type=request.getParameter("vtype");
            VenueService es=new VenueService();
            es.addVenue(venue_name,venue_type,venue_price,venue_state);
        }
        if(quedingupdate!=null)
        {
            int venuePrice= Integer.parseInt(request.getParameter("veprice"));
            String venueState=request.getParameter("vestate");
            String venueName=request.getParameter("vename");
            String venueId=request.getParameter("veid");
            String venueType=request.getParameter("vetype");
            VenueService vs2=new VenueService();
            vs2.updateVenue(venueName,venueType,venuePrice,venueState,venueId);
        }
        ViewAllService vs = new ViewAllService();
        request.setAttribute("venueList",vs.viewVenue());
        request.getRequestDispatcher("../page/administrator/shop/venue.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
