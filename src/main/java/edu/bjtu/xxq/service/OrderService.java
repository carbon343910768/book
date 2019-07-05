package edu.bjtu.xxq.service;

import edu.bjtu.xxq.dao.OrderDao;
import edu.bjtu.xxq.model.Book;
import edu.bjtu.xxq.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    /*
        返回订单书籍
    */
    public List<Book> bookList(int orderId){
        return orderDao.bookList(orderId);
    }

    /*
    返回订单
     */
    public List<Order> orderList(String method,String term){
        List<Order> idList = new ArrayList<Order>();
        idList = orderDao.orderList(method,term);
        for(Order o:idList)
            o.setBook(bookList(o.getOrderId()));
        return idList;
    }
    public List<Order> orderListByTime(String method,String time){
        List<Order> idList = new ArrayList<Order>();
        idList = orderDao.orderListByTime(method,time);
        for(Order o:idList)
            o.setBook(bookList(o.getOrderId()));
        return idList;
    }

    /*
    添加订单
     */
    public boolean addOrder(Order order){

        List<Book> books =(List<Book>) order.getBook();
        for(Book book:books)
            addOrderBook(order.getOrderId(),book.getBookId(),book.getBookNum());
        orderDao.addOrder(order);
        return true;
    }

    public boolean addOrderBook(int orderId,int bookId,int bookNum){
        orderDao.addOrderBook(orderId,bookId,bookNum);
        return true;
    }


}
