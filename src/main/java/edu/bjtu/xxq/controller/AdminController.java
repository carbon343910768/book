package edu.bjtu.xxq.controller;

import com.google.gson.Gson;
import edu.bjtu.xxq.model.ResponseCode;
import edu.bjtu.xxq.model.ResponseJson;
import edu.bjtu.xxq.service.BookService;
import edu.bjtu.xxq.service.OrderService;
import edu.bjtu.xxq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/admin")
@RestController
public class AdminController {
    //dingdan yonghu

    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    @Autowired
    private OrderService orderService;

    Gson gson = new Gson();

    @GetMapping(value = "/order", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String queryOrder(
            @RequestParam(value = "id", required = false) Integer id
    ) {
        return gson.toJson(new ResponseJson(ResponseCode.LOAD_ORDER_SUCCESS,orderService.getOne(id)));
    }

    @GetMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String queryOrders(
            @RequestParam(value = "id", required = false) Integer[] id
    ) {
        return gson.toJson(new ResponseJson(ResponseCode.LOAD_ORDER_SUCCESS,orderService.getList(id)));
    }


    @GetMapping(value = "/user/id", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String queryUserById(
            @RequestParam(value = "id", required = false) Integer id
    ) {
        return gson.toJson(new ResponseJson(ResponseCode.LOAD_USER_SUCCESS,userService.loadUserById(id)));
    }

    @GetMapping(value = "/user/name", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String queryUserByName(
            @RequestParam(value = "username", required = false) String username
    ) {
        return gson.toJson(new ResponseJson(ResponseCode.LOAD_USER_SUCCESS,userService.loadUserByUsername(username)));
    }

}
