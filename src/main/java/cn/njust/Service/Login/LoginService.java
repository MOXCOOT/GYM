package cn.njust.Service.Login;


import cn.njust.entity.*;

import cn.njust.dao.*;

public class LoginService {
    public int login(String id_phone,String pwd)
    {
        User userCorrect = UserDao.findSingleUser(id_phone);
        if(pwd.equals(userCorrect.getPassword()))return 0;//正确登录
        return 1;
    }

}
