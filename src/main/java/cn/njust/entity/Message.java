package cn.njust.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class Message {
    private String uid;
    private String oid;
    private Timestamp time;

    public void setType(String type) {
        this.type = type;
    }

    private String id;

    public String getType() {
        return type;
    }

    private String type;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
    public Message(String uid, String oid, Timestamp time, String id,String type) {
        this.uid = uid;
        this.oid = oid;
        this.time = time;
        this.id = id;
        this.type=type;
    }
    public Message(){}
}
