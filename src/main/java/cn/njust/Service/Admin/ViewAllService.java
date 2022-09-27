package cn.njust.Service.Admin;

import cn.njust.dao.EquipmentDao;
import cn.njust.dao.OrderDao;
import cn.njust.dao.UserDao;
import cn.njust.dao.VenueDao;
import cn.njust.entity.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class ViewAllService {
    public List<Equipment> viewEquipment()
    {
        List<Equipment> lisequipment= EquipmentDao.findAllEquipment();
        for(Equipment i:lisequipment)
        {
            if(i.getNumber()==0)
                i.setState("不可租赁");
        }
        return lisequipment;
    }
    public List<Venue> viewVenue()
    {
        List<Venue> lisvenue= VenueDao.findAllVenue();
        return lisvenue;
    }
    public List<Order> viewOrder()
    {
        List<Order> lisorder = OrderDao.findAllOrder();
        for(Order i:lisorder)
        {
            Date date = new Date(System.currentTimeMillis());
            Timestamp t = new Timestamp(date.getTime());
            if(i.getReturnTime().before(t)&&i.getState().equals("已逾期")!=false)
            {
                i.setState("已逾期");
            }
        }
        return lisorder;
    }
    public List<Message> viewMessage()

    {
        return null;
    }
    public List<User> viewUser(){
        List<User> lisuser = UserDao.findAllUser();
        return lisuser;
    }
}
