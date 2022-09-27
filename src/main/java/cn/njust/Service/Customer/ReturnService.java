package cn.njust.Service.Customer;
import cn.njust.dao.OrderDao;
import cn.njust.entity.Order;

import java.util.List;

public class ReturnService {
    public void returnBack(String oid)
    {
        Order or=OrderDao.findOrderByOrderId(oid);
            if(or.getState().equals("进行中")||or.getState().equals("已逾期"))
            {
                Order od=new Order(oid,or.getRname(),or.getRid(),or.getUid(),or.getOrderTime(),or.getReturnTime(),or.getSum(),"归还审核中");
                OrderDao.updateOrder(od);
            }
    }
}
