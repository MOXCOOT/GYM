package cn.njust.Service.Admin;

import cn.njust.dao.OrderDao;
import cn.njust.entity.Order;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExamService {
    public void resetTime(String oid)
    {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       Order or=OrderDao.findOrderByOrderId(oid);
       Long s1=or.getReturnTime().getTime();
       Long s2=or.getOrderTime().getTime();
        int time=(int) ((s1-s2)/3600000);
        Timestamp t1 = new Timestamp(date.getTime());
        Timestamp t2 = new Timestamp(date.getTime()+time*60*60*1000);
       if(or.getState().equals("未审核"))
       {
           Order o1=new Order(oid,or.getRname(),or.getRid(),or.getUid(),Timestamp.valueOf(simpleDateFormat.format(t1)),Timestamp.valueOf(simpleDateFormat.format(t2)),or.getSum(),"进行中");
           OrderDao.updateOrder(o1);
       }
        if(or.getState().equals("归还审核中"))
        {
            Order o2=new Order(oid,or.getRname(),or.getRid(),or.getUid(),or.getOrderTime(),or.getReturnTime(),or.getSum(),"已完成");
            OrderDao.updateOrder(o2);
        }


    }

}
