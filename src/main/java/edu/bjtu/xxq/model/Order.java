package edu.bjtu.xxq.model;

import java.util.Date;
import java.util.List;

public class Order {
    private int orderId;
    private int orderOwner;
    private Date orderTime;
    private float orderPrice;
    private Boolean orderState;
    private List<Book> book;
    public Order(){}
    public Order(int orderId, int orderOwner, List<Book> book){
        this.book = book;
        this.orderId = orderId;
        this.orderOwner = orderOwner;
    }

    public Order setBook( List<Book> book) {
        this.book = book;
        return this;
    }

    public List<Book> getBook() {
        return book;
    }

    public int getOrderId() {
        return orderId;
    }

}
