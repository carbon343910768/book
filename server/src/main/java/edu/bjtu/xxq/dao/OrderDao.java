package edu.bjtu.xxq.dao;

import edu.bjtu.xxq.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderDao {

    Order findOrderById(int id);

    List<Order> findOrdersById(List<Integer> id);

    List<Order> findAllOrders(int start, int limit);

    List<Integer> findOrdersByUser(int id, int start, int limit);

    List<Integer> findOrdersByDate(String date, int start, int limit);

    List<Integer> findOrdersBetweenDate(String from, String to, int start, int limit);

    List<Integer> findAllBooksInOrder(int id);

    Integer findBookNumberInOrder(int orderId, int bookId);

    // books: 图书ID -> 数量（在properties文件里，url后面跟上&allowMultiQueries=true，可执行多条插入）
    // 返回order生成的id
    void addOrder(Order order);

    void addBook(int orderId, Map<Integer, Integer> books);

}
