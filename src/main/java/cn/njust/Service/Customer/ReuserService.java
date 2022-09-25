package cn.njust.Service.Customer;

import cn.njust.dao.LoginDao;
import cn.njust.dao.UserDao;
import cn.njust.entity.Equipment;
import cn.njust.entity.User;

public class ReuserService {
    public String changeUserInfo(String num,String psw1,String psw2,String uid,String uname)
    {
        User newUser=new User(uid,uname,num,psw1);
        if(psw1.length()==0||psw2.length()==0)return "输入密码不能为空";
       else if(!psw1.equals(psw2))
            return "代表两次密码不一致";
       else
        {
            UserDao.updateUser(newUser);
            return "修改成功";
        }


    }


}
