package edu.bjtu.xxq.controller;

import com.google.gson.Gson;
import edu.bjtu.xxq.model.Book;
import edu.bjtu.xxq.model.Order;
import edu.bjtu.xxq.service.BookService;
import edu.bjtu.xxq.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    private final Gson gson = new Gson();
    @Autowired
    private BookService bookService;

    @RequestMapping("")
    public String test() {
        return "test";
    }

    @Autowired
    private OrderService orderService;

    @RequestMapping("/order")
    public String testOrder() {
        byte[] k ={1,1,1};
        Order order = new Order().setCustomer(1).setPrice("1").setState(true).setTime("1111-1-1");
        Map<Integer,Integer> books = new HashMap<Integer, Integer>();
        books.put(110001,1);
        books.put(110002,2);
        Book book = new Book().setName("asdqwe").setDescription("asdqwe").setAuthor("asdqwe").setPublisher("asdqwe").setPublished("1111-1-1").setISBN("11111").setPrice("11.12");
        return gson.toJson(orderService.addOrder(order,books));
    }

}
