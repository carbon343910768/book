package edu.bjtu.xxq.dao;

import edu.bjtu.xxq.model.Book;
import edu.bjtu.xxq.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {
    //获取订单内容
    List<Book> bookList(String orderId);

    List<Order> orderList(String id);

    Order getOrder(String orderId);
    //添加
    boolean addOrder(Order order);

    boolean addOrderBook(String orderId,String bookId);
}
