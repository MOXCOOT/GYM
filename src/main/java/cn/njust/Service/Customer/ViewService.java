package cn.njust.Service.Customer;

import cn.njust.entity.*;
import cn.njust.dao.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class ViewService {
    public List<Equipment> viewEquipment()
    {
        return EquipmentDao.findAllEquipment();
    }
    public List<Venue> viewVenue()
    {
        return VenueDao.findAllVenue();
    }
    public List<Order> viewOrder(String uid)
    {
      //  System.out.println(OrderDao.findAllOrderByUserid(uid));
        List<Order> lisorder = OrderDao.findAllOrderByUserid(uid);
        for(Order i:lisorder)
        {
            Date date = new Date(System.currentTimeMillis());
            Timestamp t = new Timestamp(date.getTime());
            if(i.getReturnTime().before(t))
            {
                i.setState("已逾期");

            }
        }
        return lisorder;
    }

    public List<Message> viewMessage(String uid)
    {
        return null;
    }
//    public static void main(String[] args){
//        Date date = new Date(System.currentTimeMillis());
//        Timestamp t = new Timestamp(date.getTime());
//        System.out.println(t);
//    }

}


