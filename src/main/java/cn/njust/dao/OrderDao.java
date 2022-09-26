package cn.njust.dao;

import cn.njust.entity.Order;
import cn.njust.utils.DBUtil;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDao extends BaseDao{

    /**
     *   无需输入，直接查看所有订单信息
     */
    public static List<Order> findAllOrder(){
//        String sql = "select * from orde";
        List<Map<String, Object>> list = null;
        Map<String,Object> wheremap=new HashMap<>();
        List<Order> orders=new ArrayList<>();
        try {
            list = DBUtil.query("orde",wheremap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("标记");
        System.out.println(list.size());
        for(Map<String, Object> i:list)
        {
            Order j=new Order();
            j.setOid(i.get("order_id").toString());
            j.setUid(i.get("user_id").toString());
            j.setRid(i.get("rent_id").toString());
            j.setReturnTime(Timestamp.valueOf(i.get("return_time").toString()));
            j.setOrderTime(Timestamp.valueOf(i.get("order_time").toString()));
            j.setSum(Integer.parseInt(i.get("order_sum").toString()));
            j.setState(i.get("order_state").toString());
            j.setRname(i.get("rent_name").toString());
            orders.add(j);
        }
        //System.out.println(list.get(0).get("order_state"));
        return orders;//返回订单信息
    }
//    public static void main(String[] args) {
//        System.out.println("askojdhfilouahrslf");
//        System.out.println(OrderDao.findAllOrderByUserid("d"));
//        OrderDao.findAllOrderByUserid("d");
//   }

    /**
     *   输入user_id,根据user_id查看每个用户所有订单的信息
     */
    public static List<Order> findAllOrderByUserid(String uid) {
        String sql = "select * from orde where user_id=?";
        List<Map<String, Object>> list = null;
        Object[] param={uid};
        List<Order> orders = new ArrayList<>();
        try {
            list = DBUtil.executeQuery(sql,param);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Map<String, Object> i : list) {
            Order j = new Order();
            j.setOid(i.get("order_id").toString());
            j.setUid(i.get("user_id").toString());
            j.setRid(i.get("rent_id").toString());
            j.setReturnTime(Timestamp.valueOf(i.get("return_time").toString()));
            j.setOrderTime(Timestamp.valueOf(i.get("order_time").toString()));
            j.setSum(Integer.parseInt(i.get("order_sum").toString()));
            j.setState(i.get("order_state").toString());
            j.setRname(i.get("rent_name").toString());
            orders.add(j);
        }
        return orders;
    }

        /**
         *   输入order,根据order_id查看每个用户所有订单的信息
         */

    public static Order findOrderByOrderId(String oid)
    {
        String sql = "select * from orde where order_id=" +oid;
            try {
                List<Map<String, Object>> lis = DBUtil.query(sql);
                if(lis.isEmpty()) return null;
                else
                {
//                    Order(String oid, String rtype, String rid, String uid, Timestamp orderTime, Timestamp returnTime, int sum, String state)
                    Map<String, Object> ma=lis.get(0);
                    Order or = new Order(ma.get("order_id").toString(),ma.get("rent_id").toString(),ma.get("user_id").toString(),ma.get("rent_name").toString(),Timestamp.valueOf(ma.get("order_time").toString()),Timestamp.valueOf(ma.get("return_time").toString()),Integer.parseInt(ma.get("order_sum").toString()),ma.get("order_state").toString());
                    return or;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return null;
    }


//    public static void main(String[] args)
//    {
//        System.out.println(OrderDao.findTimeByOId("220924151"));
//   }
        /**
         *   输入order,根据订单id实现订单信息删除
         */
    public static void deleteOrderById(String oid) {
        Map<String, Object> whereMap = new HashMap<>();
        whereMap.put("order_id", oid);//根据订单id寻找进而删除
        try {
            int count = DBUtil.delete("orde", whereMap);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 输入order实现更新，可变更state
     */
    public static void updateOrder(Order order) {
        Map<String, Object> map = new HashMap<>();
        map.put("order_state",order.getState() );//更新状态
        Map<String, Object> whereMap = new HashMap<>();
        whereMap.put("order_id", order.getOid());//根据订单id寻找
        try {
            int count = DBUtil.update("orde", map, whereMap);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     *   输入Order,实现订单信息插入(不需要输入时间，时间为系统当前自带)
     */
    public static void insertOrder(Order order){
        Map<String, Object> map = new HashMap<>();
        Date date = new Date(System.currentTimeMillis());//获取当前时间戳
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Timestamp t1 = new Timestamp(date.getTime());
//        Timestamp t2 = new Timestamp(date.getTime()+36000);
//        order.setOrderTime(Timestamp.valueOf(simpleDateFormat.format(t1)));
//        order.setReturnTime(Timestamp.valueOf(simpleDateFormat.format(t2)));
            map.put("user_id",order.getUid());
            map.put("order_id", order.getOid());
            map.put("rent_id",order.getRid() );
            map.put("order_time",order.getOrderTime() );
            map.put("order_state",order.getState() );
            map.put("return_time",order.getReturnTime());
            map.put("order_sum",order.getSum());
            map.put("rent_name",order.getRname());
        try {
            int count = DBUtil.insert("orde", map);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    public static void main(String[] args)
//    {
//        Order or=new Order();
//        or.setOid("fsadf");
//        or.setState("fdsa");
//        or.setUid("fdsaf");
//        or.setRname("fdsf");
//        or.setRid("dsaf");
//
//        OrderDao.insertOrder(or);
//    }
    /*public static void main(String[] args)
    {
        Order o=new Order();
        o.setSum(100);
        o.setRid("0");
        o.setUid("0");
        o.setState(1);
        o.setOid("9");
        Date date = new Date(System.currentTimeMillis());//获取当前时间戳
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp t = new Timestamp(date.getTime());
        Timestamp t2 = new Timestamp(date.getTime()+ 24 * 60 * 60 * 1000);
        o.setOrderTime(Timestamp.valueOf(simpleDateFormat.format(t)));
       o.setReturnTime(Timestamp.valueOf(simpleDateFormat.format(t)));
        OrderDao.insertOrder(o);
    }*/



}
