package edu.bjtu.xxq.controller;

import edu.bjtu.xxq.model.*;
import com.google.gson.Gson;
import edu.bjtu.xxq.service.BookService;
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
    @Autowired
    private BookService bookService;
    /*
    我的商店
     */
    @RequestMapping("/myStore")
    public String myStore(@RequestParam("username") String username){
        Gson gson = new Gson();
        Store s = new Store();
        List<Book> books = new ArrayList<Book>();
        books = bookService.loadBookByTag("1");

        return gson.toJson(new ResponseJson(ResponseCode.REGISTER_ILLEGAL_PASSWORD,books));

    }

}
