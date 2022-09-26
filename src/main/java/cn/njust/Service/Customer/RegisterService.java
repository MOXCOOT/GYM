package cn.njust.Service.Customer;

import cn.njust.dao.UserDao;
import cn.njust.entity.*;

import java.util.Random;

public class RegisterService {
    public String registerNew(String name,String number,String password1,String password2)
    {
        if(name.equals("")||number.length()==0||password1.length()==0||password2.length()==0)return "输入不能为空";
//        if(number==null) return 2;
        else if(number.length()!=11) return "手机号错误或已被注册";
        UserDao dao=new UserDao();
        User newid=new User();
//        System.out.println(name);
//        System.out.println(number);
//        System.out.println(password1);
//        System.out.println(password2);
        //返回 3 代表手机号错误或已被注册
        //返回 2 代表有空空值
        //返回 1 代表两次密码不一致
        //返回 0 代表注册成功
        //检验两次密码是否一致
        if(!password1.equals(password2))
            return "代表两次密码不一致";
        String uid;
        do {
            //随机生成五位数字作为用户ID
            String str = "0123456789";
            Random random = new Random();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < 5; i++) {
                int num = random.nextInt(10);
                stringBuffer.append(str.charAt(num));
            }
            uid = stringBuffer.toString();

          //  System.out.println(uid);

            newid.setId(uid);
        }
        while(dao.findSingleUser(uid)==null);//查找数据库检验是否有重复ID
        newid.setPassword(password1);
        newid.setName(name);
        newid.setNumber(number);
        UserDao.insertSingleUser(newid);
       // System.out.println("服务端插入成功");
        //将数据插入数据库
        return "注册成功";
    }


}