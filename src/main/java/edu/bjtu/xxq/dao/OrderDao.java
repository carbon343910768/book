package edu.bjtu.xxq.dao;

import edu.bjtu.xxq.model.Book;
import edu.bjtu.xxq.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {
    //获取订单内容
    List<Book> bookList(int orderId);

    List<Order> orderList(String method,String term);

    List<Order> orderListByTime(String method,String time);

    //添加
    boolean addOrder(Order order);

    boolean addOrderBook(int orderId,int bookId,int bookNum);
}
