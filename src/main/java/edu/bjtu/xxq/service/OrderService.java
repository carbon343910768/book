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
    public Order getOne(int id) {
        return orderDao.findOrderById(id);
    }

    public List<Order> getMany(List<Integer> idList){
        List<Order> orderList = new ArrayList<Order>();
        for (Integer id:idList){
            orderList.add(getOne(id));
        }
        return orderList;
        //return orderDao.findOrdersById(id);
    }

    public List<Book> getAllBooksInOrder(int id ){return orderDao.findAllBooksInOrder(id);}

    public Integer bookNumber(int orderId,int bookId){return orderDao.findBookNumberInOrder(orderId,bookId);}

    public boolean addOrder(Order order){
        orderDao.addOrder(order);
        for(Book book:order.getBook()){
            orderDao.addOrderBook(order.getOrderId(),book.getBookId(),1);
        }
        return true;
    }

    /*
    返回订单
     */
//    public List<Order> orderList(String method,String term){
//        List<Order> idList = new ArrayList<Order>();
//        idList = orderDao.orderList(method,term);
//        for(Order o:idList)
//            o.setBook(bookList(o.getOrderId()));
//        return idList;
//    }
//    public List<Order> orderListByTime(String method,String time){
//        List<Order> idList = new ArrayList<Order>();
//        idList = orderDao.orderListByTime(method,time);
//        for(Order o:idList)
//            o.setBook(bookList(o.getOrderId()));
//        return idList;
//    }
//
//    /*
//    添加订单
//     */
//    public boolean addOrder(Order order){
//        List<Book> books =(List<Book>) order.getBook();
//        for(Book book:books)
//            addOrderBook(order.getOrderId(),book.getBookId(),book.getBookNum());
//        orderDao.addOrder(order);
//        return true;
//    }
//
//    public boolean addOrderBook(int orderId,int bookId,int bookNum){
//        orderDao.addOrderBook(orderId,bookId,bookNum);
//        return true;
//    }
//
}
