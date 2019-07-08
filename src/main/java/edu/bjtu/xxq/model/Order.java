package edu.bjtu.xxq.model;

public class Order {

    private int id;
    private int customer;
    private String address;
    private String phone;
    private String time;
    private String price;
    private boolean state;


    public String getPhone() {
        return phone;
    }

    public Order setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public int getId() {
        return id;
    }

    public Order setId(int id) {
        this.id = id;
        return this;
    }

    public int getCustomer() {
        return customer;
    }

    public Order setCustomer(int customer) {
        this.customer = customer;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Order setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getTime() {
        return time;
    }

    public Order setTime(String time) {
        this.time = time;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public Order setPrice(String price) {
        this.price = price;
        return this;
    }

    public boolean isState() {
        return state;
    }

    public Order setState(boolean state) {
        this.state = state;
        return this;
    }
}
