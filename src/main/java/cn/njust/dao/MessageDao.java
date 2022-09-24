package cn.njust.dao;

import cn.njust.entity.Message;
import cn.njust.entity.Order;
import cn.njust.utils.DBUtil;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

public class MessageDao {

    /**
     * 查询场地,返回场地信息
     */
    public static List<Message> findAllMessage(){
        String sql = "select * from message";
        List<Map<String, Object>> list = null;
        List<Message> messages=new ArrayList<Message>();
        try {
            list = DBUtil.query(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(Map<String, Object> i:list)
        {
            Message j=new Message();
            j.setId(i.get("message_id").toString());
            j.setOid(i.get("order_id").toString());
            j.setUid(i.get("user_id").toString());
            j.setTime(Timestamp.valueOf((i.get("message_time").toString())));

        }
       // System.out.println(list.get(0).get("message_time"));//时间输出测试
        return messages;//返回场地信息

    }
    /**
     *   输入Message,实现订单信息插入(不需要输入时间，时间为系统当前自带)
     */


    public static List<Message> findAllMessageByUserid(String uid) {
        String sql = "select * from message where user_id=?";
        List<Map<String, Object>> list = null;
        Object[] param={uid};
        List<Message> messages = new ArrayList<>();
        try {
            list = DBUtil.executeQuery(sql,param);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Map<String, Object> i : list) {
            Message j = new Message();
            j.setOid(i.get("order_id").toString());
            j.setUid(i.get("user_id").toString());
            j.setId(i.get("message_id").toString());
            j.setTime(Timestamp.valueOf(i.get("message_time").toString()));
            messages.add(j);
        }
        return messages;
    }

    /**
     *   输入message,根据message_id查看每个用户所有订单的信息
     */


    public static void insertMessage(Message message){
        Map<String, Object> map = new HashMap<>();
        Date date = new Date(System.currentTimeMillis());//获取当前时间戳
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp t = new Timestamp(date.getTime());
        message.setTime(Timestamp.valueOf(simpleDateFormat.format(t)));
        map.put("user_id",message.getUid());
        map.put("message_id", message.getId());
        map.put("message_time",message.getTime() );
        map.put("order_id",message.getOid() );
        try {
            int count = DBUtil.insert("message", map);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteMessageById(Message message) {
        Map<String, Object> whereMap = new HashMap<>();
        whereMap.put("message_id", message.getId());//根据消息id寻找进而删除
        try {
            int count = DBUtil.delete("message", whereMap);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

/*
 *测试
 */
 /*  public static void main(String[] args){
       Message m=new Message();
       m.setContent("好");
       m.setId("6");
       m.setOid("2");
       m.setUid("1");
       m.setAid("8");
       MessageDao.insertMessage(m);
    }*/
}
