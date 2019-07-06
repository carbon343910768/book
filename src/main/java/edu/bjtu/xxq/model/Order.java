package edu.bjtu.xxq.model;

public class Order {

    private int orderId;
    private int orderOwner;
    private String orderTime;
    private String orderPrice;
    private boolean orderState;

    public int getOrderId() {
        return orderId;
    }

    public Order setOrderId(int orderId) {
        this.orderId = orderId;
        return this;
    }

    public int getOrderOwner() {
        return orderOwner;
    }

    public Order setOrderOwner(int orderOwner) {
        this.orderOwner = orderOwner;
        return this;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public Order setOrderTime(String orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public Order setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
        return this;
    }

    public boolean isOrderState() {
        return orderState;
    }

    public Order setOrderState(boolean orderState) {
        this.orderState = orderState;
        return this;
    }
}
