package cn.njust.Service.Customer;
import cn.njust.dao.OrderDao;
import cn.njust.dao.VenueDao;
import cn.njust.entity.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RentService {
    public Equipment[] searchEquipment(){
        return null;
    }
    public Venue[] searchVenue(){
        return null;
    }
    public Order equipmentOrder(String uid,String type,int number)
    {
        //订单号命名：日期+三位随机数
        //获得当前日期
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyMMdd");
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append(dateFormat.format(date));
        //生成三位随机数
        do {
            //随机生成五位数字作为用户ID
            String str = "0123456789";
            Random random = new Random();
            for (int i = 0; i < 5; i++) {
                int num = random.nextInt(10);
                stringBuffer.append(str.charAt(num));
            }
            String oid = stringBuffer.toString();
        }
        while(false);//查找数据库检验是否有重复订单号

        System.out.println(dateFormat.format(date).toString());
        return null;
    }
    public Order venueOrder(String uId,String vtpe,String vId,int time)
    {
        String oid;
        //订单号命名：日期+三位随机数
        //获得当前日期
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyMMdd");
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append(dateFormat.format(date));
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp t1 = new Timestamp(date.getTime());
        Timestamp t2 = new Timestamp(date.getTime()+time*60*60);
        int sum=VenueDao.findPriceByType(vtpe);
        //生成三位随机数
        do {
            //随机生成三位数字作为校验码
            String str = "0123456789";
            Random random = new Random();
            for (int i = 0; i < 3; i++) {
                int num = random.nextInt(10);
                stringBuffer.append(str.charAt(num));
            }
            oid = stringBuffer.toString();
        }
        while(OrderDao.findOrderByOrderId(oid)==null);//查找数据库检验是否有重复订单号
//        Order(String oid, String rtype, String rid, String uid, Timestamp orderTime, Timestamp returnTime, int sum, String state)
        Order or = new Order(oid,vtpe,vId,uId, Timestamp.valueOf(simpleDateFormat.format(t1)),Timestamp.valueOf(simpleDateFormat.format(t2)),sum,"未审核");
        return or;
    }

    public static void main(String[] args){
        RentService t=new RentService();
        //t.equipmentOrder("0","0",0);
    }
}
