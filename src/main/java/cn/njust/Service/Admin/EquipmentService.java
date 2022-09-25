package cn.njust.Service.Admin;

import cn.njust.dao.EquipmentDao;
import cn.njust.entity.Equipment;

import java.util.Random;

public class EquipmentService {
    public void addEquipment(String ename,String etype,int enumber,int eprice,String estate)
    {
        String eid;
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
            eid = stringBuffer.toString();
        }
        while (EquipmentDao.findEquipmentByEquipmentId(eid)!=null);
//             public Equipment(String id, String name, String type, int number, int price, String state)
        Equipment eq=new Equipment(eid,ename,etype,enumber,eprice,estate);
        EquipmentDao.insertEquipment(eq);
    }

    public void updateEquipment(String ename,String etype,int enumber,int eprice,String estate,String eid)
    {
        Equipment eq=new Equipment(eid,ename,etype,enumber,eprice,estate);
        EquipmentDao.updateEquipment(eq);
    }
    public void deleteEquipment(String eid)
    {
        EquipmentDao.deleteEquipmentById(eid);
    }

}
