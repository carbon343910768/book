package edu.bjtu.xxq.model;

public class Order {

    private int id;
    private int customer;
    private String time;
    private String price;
    private boolean state;

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
