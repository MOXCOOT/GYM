package cn.njust.Service.Customer;

import cn.njust.dao.UserDao;

public class LogoutService {
    public void logoutUser(String uid)
    {
        UserDao.deleteUser(uid);
    }

}
