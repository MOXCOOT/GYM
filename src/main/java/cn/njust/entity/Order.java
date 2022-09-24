package cn.njust.entity;

import java.sql.Timestamp;

public class Order {
    private String oid;//订单id
    private String rname;
    private String rid;//器材id
    private String uid;//用户id
    private Timestamp orderTime;
    private Timestamp returnTime;
    private int sum;
    private String state;

    public Order(){}

    public Order(String oid, String rname, String rid, String uid, Timestamp orderTime, Timestamp returnTime, int sum, String state) {
        this.oid = oid;
        this.rname = rname;
        this.rid = rid;
        this.uid = uid;
        this.orderTime = orderTime;
        this.returnTime = returnTime;
        this.sum = sum;
        this.state = state;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    public Timestamp getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Timestamp returnTime) {
        this.returnTime = returnTime;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }
}
