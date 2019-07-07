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

    public List<Integer> getListByUser(int id,int start,int limit) {
        return orderDao.findOrdersByUser(id,start,limit);
    }

    public List<Integer> getListByDate(String date,int start,int limit) {
        return orderDao.findOrdersByDate(date,start,limit);
    }

    public List<Integer> getListBetweenDate(String from,String to,int start,int limit) {
        return orderDao.findOrdersBetweenDate(from,to,start,limit);
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
