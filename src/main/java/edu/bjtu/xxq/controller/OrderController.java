package edu.bjtu.xxq.controller;

import com.google.gson.Gson;
import edu.bjtu.xxq.model.Cart;
import edu.bjtu.xxq.model.Order;
import edu.bjtu.xxq.model.ResponseCode;
import edu.bjtu.xxq.model.ResponseJson;
import edu.bjtu.xxq.service.CartService;
import edu.bjtu.xxq.service.OrderService;
import edu.bjtu.xxq.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CartService cartService;

    private Gson gson = new Gson();

    @GetMapping(value = "/one", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String query(@RequestParam("id") int id) {
        return gson.toJson(orderService.getOne(id));
    }

    @GetMapping(value = "/batch", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String query(@RequestParam("id") Integer[] id) {
        return gson.toJson(orderService.getList(id));
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String queryAll(@RequestParam(value = "page", required = false) Integer page) {
        if (page == null) page = 0;
        else page--;
        Integer userId = UserUtil.getUserId();
        if (userId == null) return "";
        return gson.toJson(orderService.getByUser(userId, page));
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String add(
            @RequestParam("bookId") Integer[] bookId,
            @RequestParam("number") Integer[] number,
            @RequestParam(value = "cartId", required = false) Integer cartId,
            @RequestParam(value = "address", required = false) String address,
            @RequestParam(value = "phone", required = false) String phone
    ) {
        cartId = UserUtil.getUserId();
        Map<Integer, Integer> bookMap
                = IntStream.range(0, bookId.length).boxed()
                .collect(Collectors.toMap(j -> bookId[j], j -> number[j]));
        if (cartId != null) {
            cartService.updateCart(cartId, bookMap);
            Cart cart = cartService.getOne(cartId);
            address = cart.getAddress();
            phone = cart.getPhone();
        }
        Integer userId = UserUtil.getUserId();
        if (userId == null || address == null || phone == null)
            return gson.toJson(new ResponseJson(ResponseCode.ORDER_FAIL));
        Order order = new Order()
                .setAddress(address)
                .setPhone(phone)
                .setTime(LocalDateTime.now().toString())
                .setCustomer(userId)
                .setState(true);
        orderService.addOrder(order, bookMap);
        return gson.toJson(new ResponseJson(ResponseCode.ORDER_SUCCESS));
    }
}
