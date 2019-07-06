package edu.bjtu.xxq.controller;

import com.google.gson.Gson;
import edu.bjtu.xxq.service.BookService;
import edu.bjtu.xxq.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final Gson gson = new Gson();
    @Autowired
    private BookService bookService;

    @Autowired
    private OrderService orderService;

    @RequestMapping("/test")
    public String test() {
        return gson.toJson(orderService.getOne(150001));
    }

}
