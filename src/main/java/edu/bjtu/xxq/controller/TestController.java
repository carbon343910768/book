package edu.bjtu.xxq.controller;

import com.google.gson.Gson;
import edu.bjtu.xxq.service.BookService;
import edu.bjtu.xxq.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return gson.toJson(orderService.getOne(150001));
    }

}
