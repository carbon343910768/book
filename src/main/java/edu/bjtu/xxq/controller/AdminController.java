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

    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    @Autowired
    private OrderService orderService;

    Gson gson = new Gson();

    @GetMapping(value = "/order", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String queryOrder(
            @RequestParam(value = "orderId", required = false) Integer orderId,
            @RequestParam(value = "userId", required = false) Integer userId,
            @RequestParam(value = "date", required = false) String date,
            @RequestParam(value = "from", required = false) String from,
            @RequestParam(value = "to", required = false) String to,
            @RequestParam(value = "page") Integer page
            ) {
        return "";
    }

    @GetMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String queryOrders(
            @RequestParam(value = "id", required = false) Integer[] id
    ) {
        return gson.toJson(orderService.getList(id));
    }

}
