package cn.njust.Service.Admin;

import cn.njust.dao.EquipmentDao;
import cn.njust.dao.OrderDao;
import cn.njust.dao.UserDao;
import cn.njust.entity.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class ViewAllService {
    public List<Equipment> viewEquipment()
    {
        List<Equipment> lisequipment= EquipmentDao.findAllEquipment();
        return lisequipment;
    }
    public List<Venue> viewVenue()
    {
        return null;
    }
    public List<Order> viewOrder()
    {
        List<Order> lisorder = OrderDao.findAllOrder();
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
    public List<Message> viewMessage()

    {
        return null;
    }
    public List<User> viewUser(){
        List<User> lisuser = UserDao.findAllUser();
        return lisuser;
    }
}
