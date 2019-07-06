package edu.bjtu.xxq.dao;

import edu.bjtu.xxq.model.Book;
import edu.bjtu.xxq.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {

    Order findOrderById(int id);

    List<Order> findOrdersById(List<Integer> id);

    List<Book> findAllBooksInOrder(int id);

    Integer findBookNumberInOrder(int orderId, int bookId);

    void addOrder(Order order);

    void addOrderBook(int orderId, int bookId, int bookNumber);

}
