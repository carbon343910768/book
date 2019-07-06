package edu.bjtu.xxq.controller;

import com.google.gson.Gson;
import edu.bjtu.xxq.model.Book;
import edu.bjtu.xxq.model.Order;
import edu.bjtu.xxq.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/test")
    public String test(){
        Gson gson = new Gson();
        List<Integer> List = new ArrayList<Integer>();
        List.add(150001);
        List.add(150002);
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book(110001,1));
        Order order = new Order(150003,1,bookList);
        return gson.toJson(orderService.addOrder(order));
    }

}
