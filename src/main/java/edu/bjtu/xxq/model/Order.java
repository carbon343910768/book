package edu.bjtu.xxq.model;

import java.util.Date;

public class Order {
    private int orderId;
    private int orderOwner;
    private Date orderTime;
    private float orderPrice;
    private Boolean orderState;
    private Object book;
    public Order(){}
    public Order(int orderId, int orderOwner, Object book){
        this.book = book;
        this.orderId = orderId;
        this.orderOwner = orderOwner;
    }

    public void setBook(Object book) {
        this.book = book;
    }

    public Object getBook() {
        return book;
    }

    public int getOrderId() {
        return orderId;
    }

}
