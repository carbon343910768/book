package edu.bjtu.xxq.controller;

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

    @GetMapping(value = "/order", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String queryOrder(
            @RequestParam(value = "id", required = false) Integer id
    ) {
        return "";
    }
}
