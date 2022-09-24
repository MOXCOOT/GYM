package cn.njust.controller;

import cn.njust.Service.Customer.RentService;
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
        Object queding = request.getParameter("ok2");
        User cus = (User) request.getSession().getAttribute("user");
        System.out.println("hellooooo"+queding);
        if(queding!=null)
        {
            String equipment_id = request.getParameter("equipment_id");
            String equipment_name = request.getParameter("equipment_name");
            String hours =  request.getParameter("hours");
//            System.out.println("时间"+ hours );
//            System.out.println(equipment_id);
//            System.out.println(equipment_name);
            RentService rs=new RentService();
            rs.equipmentOrder(cus.getId(),equipment_name,equipment_id,Integer.parseInt(hours));
        }
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
