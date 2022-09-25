package cn.njust.controller.Admin;

import cn.njust.Service.Admin.EquipmentService;
import cn.njust.Service.Admin.ViewAllService;
import cn.njust.Service.Customer.RentService;
import cn.njust.Service.Customer.ViewService;
import cn.njust.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "EquipmentController_ad", value = "/EquipmentController_ad")
public class EquipmentController_ad extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Object quedingadd = request.getParameter("ok2");
        System.out.println(quedingadd);
//       // System.out.println("hellooooo"+queding);
        if(quedingadd!=null)
        {
            String equipment_name = request.getParameter("ename");
            int equipment_number = Integer.parseInt(request.getParameter("enumber"));
            int equipment_price = Integer.parseInt(request.getParameter("eprice"));
            String equipment_state = request.getParameter("estate");
            String equipment_type=request.getParameter("etype");
            EquipmentService es=new EquipmentService();
            es.addEquipment(equipment_name,equipment_type,equipment_number,equipment_price,equipment_state);
        }
        ViewAllService vs = new ViewAllService();
        request.setAttribute("equipList",vs.viewEquipment());
        request.getRequestDispatcher("../page/administrator/shop/equipment.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
