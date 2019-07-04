package edu.bjtu.xxq.controller;

import edu.bjtu.xxq.model.*;
import com.google.gson.Gson;
import edu.bjtu.xxq.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StoreController {
    @Autowired
    private OrderService orderService;
    /*
    我的商店
     */
    @RequestMapping("/myStore")
    public String myStore(@RequestParam("username") String username){
        Gson gson = new Gson();
        Store s = new Store();
        Book b1 = new Book("110001","choushabi");
        Book b2 = new Book("110002","asidun");
        List<Book> b = new ArrayList<Book>();
        b.add(b1);
        b.add(b2);
        Order order = new Order("150004","1",b);
        orderService.addOrder(order);

        return gson.toJson(new ResponseJson(ResponseCode.REGISTER_ILLEGAL_PASSWORD,s));

    }

}
