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
    public List<Book> bookList(String orderId){
        return orderDao.bookList(orderId);
    }

    /*
    返回用户全部订单
     */
    public List<Order> orderList(String id){
        List<Order> idList = new ArrayList<Order>();
        idList = orderDao.orderList(id);
        for(Order o:idList){
            o.setBook(bookList(o.getOrderId()));
        }
        return idList;
    }

    /*
    返回订单内容
     */
    public Order getOrder(String orderId){
        List<Book> book = new ArrayList<Book>();
        book = bookList(orderId);
        Order order = new Order();
        order = orderDao.getOrder(orderId);
        order.setBook(book);
        return order;
    }
    /*
    添加订单
     */
    public boolean addOrder(Order order){

        List<Book> books =(List<Book>) order.getBook();
        for(Book book:books){
            addOrderBook(order.getOrderId(),book.getBookId());
        }
        orderDao.addOrder(order);
        return true;
    }
    public boolean addOrderBook(String orderId,String bookId){
        orderDao.addOrderBook(orderId,bookId);
        return true;
    }


}
