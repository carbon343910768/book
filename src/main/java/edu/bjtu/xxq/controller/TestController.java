package edu.bjtu.xxq.controller;

import com.google.gson.Gson;
import edu.bjtu.xxq.model.Order;
import edu.bjtu.xxq.model.ResponseCode;
import edu.bjtu.xxq.model.ResponseJson;
import edu.bjtu.xxq.service.BookService;
import edu.bjtu.xxq.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private OrderService orderService;

    private Gson gson  = new Gson();
    @RequestMapping("/test")
    public String test(@RequestBody String json){
        Order order = new Order();
        order = gson.fromJson(json, Order.class);
        orderService.addOrder(order);
        return gson.toJson(new ResponseJson(ResponseCode.REGISTER_ILLEGAL_PASSWORD));
    }

}
