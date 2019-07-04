package edu.bjtu.xxq.model;

import java.util.Date;

public class Order {
    private String orderId;
    private String orderOwner;
    private Date orderTime;
    private Boolean orderState;
    private Object book;
    public Order(){}
    public Order(String orderId, String orderOwner, Object book){
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

    public String getOrderId() {
        return orderId;
    }

}
