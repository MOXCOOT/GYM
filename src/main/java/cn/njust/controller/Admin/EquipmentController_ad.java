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
        Object quedingupdate = request.getParameter("p2");
        Object quedingdelete = request.getParameter("d2");
       // System.out.println(quedingdelete);
//        System.out.println(quedingadd);
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
        if(quedingupdate!=null)
        {
            int equip_number= Integer.parseInt(request.getParameter("eqnumber"));
            int equip_price= Integer.parseInt(request.getParameter("eqprice"));
            String equip_state=request.getParameter("eqstate");
            String equip_name=request.getParameter("eqname");
            String equip_id=request.getParameter("eqid");
            String equip_type=request.getParameter("eqtype");
            EquipmentService es2=new EquipmentService();
            es2.updateEquipment(equip_name,equip_type,equip_number,equip_price,equip_state,equip_id);
        }
        if(quedingdelete!=null)
        {
            String eid=request.getParameter("e_id");
            EquipmentService es3=new EquipmentService();
            es3.deleteEquipment(eid);
        }
        ViewAllService vs = new ViewAllService();
        request.setAttribute("equipList",vs.viewEquipment());
        request.getRequestDispatcher("../page/administrator/shop/equipment.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
