package cn.njust.Service.Admin;

import cn.njust.dao.UserDao;

public class LogoutService {
    public void logoutUser(String uid)
    {
        UserDao.deleteUser(uid);
    }

}
