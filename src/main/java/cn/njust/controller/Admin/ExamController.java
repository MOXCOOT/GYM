package cn.njust.controller.Admin;

import cn.njust.Service.Admin.ExamService;
import cn.njust.Service.Admin.ViewAllService;
import cn.njust.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ExamController", value = "/ExamController")
public class ExamController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Object tg=request.getParameter("tg");
        String oid=request.getParameter("order_id");
        ViewAllService vs = new ViewAllService();
        request.setAttribute("orderList",vs.viewOrder());
        if(tg!=null)
        {
            ExamService es=new ExamService();
            es.resetTime(oid);
        }
        request.getRequestDispatcher("../page/administrator/order/exam.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
