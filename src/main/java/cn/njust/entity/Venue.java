package cn.njust.entity;

public class Venue {

    private String id;
    private String name;
    private String type;
    private int price;
    private String state;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    public Venue(String id, String name, String type, int price, String state) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.state = state;
    }
    public Venue(){}
}
