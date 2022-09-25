package cn.njust.Service.Admin;

import cn.njust.dao.EquipmentDao;
import cn.njust.dao.VenueDao;
import cn.njust.entity.Equipment;
import cn.njust.entity.Venue;

import java.util.Random;

public class VenueService {
    public void addVenue(String vname,String vtype,int vprice,String vstate)
    {
        String vid;
        //生成三位随机数
        StringBuffer stringBuffer=new StringBuffer();
        do {
            //随机生成三位数字作为校验码
            String str = "0123456789";
            Random random = new Random();
            for (int i = 0; i < 3; i++) {
                int num = random.nextInt(10);
                stringBuffer.append(str.charAt(num));
            }
            vid = stringBuffer.toString();
        }
        while (VenueDao.findVenueByVenueId(vid)!=null);
        Venue ve=new Venue(vid,vname,vtype,vprice,vstate);
        VenueDao.insertVenue(ve);
    }
    public void updateVenue(String vname,String vtype,int vprice,String vstate,String vid)
    {
        Venue eq=new Venue(vid,vname,vtype,vprice,vstate);
        VenueDao.updateVenue(eq);
    }
}
