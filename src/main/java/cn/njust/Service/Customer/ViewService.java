package cn.njust.Service.Customer;

import cn.njust.entity.*;
import cn.njust.dao.*;
import cn.njust.utils.DBUtil;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
//                public Order(String oid, String rname, String rid, String uid, Timestamp orderTime, Timestamp returnTime, int sum, String state)
                Order od=new Order(i.getOid(),i.getRname(),i.getRid(),i.getUid(),i.getOrderTime(),i.getReturnTime(),i.getSum(),"已逾期");
               OrderDao.updateOrder(od);
            }
        }
        return lisorder;
    }

    public List<Message> viewMessage(String uid)
    {
        List<Order> liorder= OrderDao.findAllOrderByUserid(uid);
        List<Message> limessage=MessageDao.findAllMessageByUserid(uid);
            for (Order i:liorder)
            {
                     if (i.getState().equals("已完成"))
                    {
                        MessageDao.deleteMessageByOrderId(i.getOid());
                    }
                }
        return limessage;
    }

    public void sendMessage(String uid,String oid)
    {
        java.util.Date date = new java.util.Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp t = new Timestamp(date.getTime());
        String mid;
        StringBuffer stringBuffer=new StringBuffer();
        do {
            //随机生成三位数字作为校验码
            String str = "0123456789";
            Random random = new Random();
            for (int j = 0; j < 3; j++) {
                int num = random.nextInt(10);
                stringBuffer.append(str.charAt(num));
            }
            mid = stringBuffer.toString();
        }
            while(MessageDao.findMessageByMessageId(mid)!=null);
            Message ms=new Message(uid,oid,Timestamp.valueOf(simpleDateFormat.format(t)),mid);
            MessageDao.insertMessage(ms);

    }
//    public static void main(String[] args){
//        Date date = new Date(System.currentTimeMillis());
//        Timestamp t = new Timestamp(date.getTime());
//        System.out.println(t);
//    }

}


