package cn.njust.entity;

public class Equipment {


    private String id;
    private String name;
    private String type;
    private int number;
    private int price;
    private int state;

    public Equipment(String id, String name, String type, int number, int price, int state) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.number = number;
        this.price = price;
        this.state = state;
    }
    public Equipment(){}
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
