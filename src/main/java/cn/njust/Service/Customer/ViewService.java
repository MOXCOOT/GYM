package cn.njust.Service.Customer;

import cn.njust.entity.*;
import cn.njust.dao.*;

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
        return OrderDao.findAllOrderByUserid(uid);

    }
    public List<Message> viewMessage(String uid)
    {
        return null;
    }

}
