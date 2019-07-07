package edu.bjtu.xxq.service;

import edu.bjtu.xxq.dao.OrderDao;
import edu.bjtu.xxq.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    public Order getOne(int id) {
        return orderDao.findOrderById(id);
    }

    public List<Order> getList(Integer[] id) {
        return orderDao.findOrdersById(Arrays.asList(id));
    }

    private static final int PAGE_SIZE = 10;

    public List<Integer> getByUser(int id, int page) {
        return orderDao.findOrdersByUser(id, page * PAGE_SIZE, PAGE_SIZE);
    }

    public List<Integer> getByDate(String date, int page) {
        return orderDao.findOrdersByDate(date, page * PAGE_SIZE, PAGE_SIZE);
    }

    public List<Integer> getBetweenDate(String from, String to, int page) {
        return orderDao.findOrdersBetweenDate(from, to, page * PAGE_SIZE, PAGE_SIZE);
    }

    public List<Integer> getAllBooksInOrder(int id) {
        return orderDao.findAllBooksInOrder(id);
    }

    public Integer getBookNumber(int orderId, int bookId) {
        return orderDao.findBookNumberInOrder(orderId, bookId);
    }

    public int addOrder(Order order, Map<Integer, Integer> books) {
        int id = orderDao.addOrder(order);
        orderDao.addBook(id, books);
        return order.getId();
    }
}
