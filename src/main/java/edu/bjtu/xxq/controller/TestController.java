package edu.bjtu.xxq.controller;

import com.google.gson.Gson;
import edu.bjtu.xxq.model.*;
import edu.bjtu.xxq.service.BookService;
import edu.bjtu.xxq.service.CartService;
import edu.bjtu.xxq.service.ImageService;
import edu.bjtu.xxq.service.OrderService;
import edu.bjtu.xxq.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequestMapping("/test")
@RestController
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

    @Autowired
    private CartService cartService;

    @Autowired
    private ImageService imageService;

    @RequestMapping("/cart")
    public String testCart() {

        /*Cart cart = new Cart().setOwner(1).setAddress("asd");
        return gson.toJson(cartService.addCart(cart));*/

        // return gson.toJson(cartService.getOne(1));

        /*List<Integer> id = new ArrayList<Integer>();
        id.add(1);
        id.add(2);
        return gson.toJson(cartService.getList(id));*/

        /*cartService.addBook(1,111,1);
        cartService.addBook(1,123,1);
        return gson.toJson(cartService.addBook(2,111,1));*/

        //return gson.toJson(cartService.getAllBooksInCart(1));

        return gson.toJson(cartService.getBookNumber(1, 111));

    }

    @RequestMapping("/book")
    public String testBook() {
        return gson.toJson(bookService.search("asd asd"));
    }

    @RequestMapping("/image")
    public String testImage() {
        /*byte[] b = {1,1,1};
        Image image = new Image().setContent(b);
        return gson.toJson(imageService.addImage(image));*/

        return gson.toJson(imageService.getImage(3));
    }

    @PostMapping(value = "/order", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String add(
            @RequestParam("bookId") Integer[] bookId,
            @RequestParam("number") Integer[] number,
            @RequestParam("userId") Integer userId,
            @RequestParam("address") String address,
            @RequestParam("phone") String phone
    ) {
        Map<Integer, Integer> bookMap
                = IntStream.range(0, bookId.length).boxed()
                .collect(Collectors.toMap(j -> bookId[j], j -> number[j]));

        Order order = new Order()
                .setCustomer(userId)
                .setPhone(phone)
                .setAddress(address)
                .setState(true);
        orderService.addOrder(order, bookMap);
        System.out.println(order);
        return gson.toJson(new ResponseJson(ResponseCode.ORDER_SUCCESS));
    }

//    @PostMapping(value = "/customer", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public String detail(
//            @RequestParam(value = "name", required = false) String name,
//            @RequestParam(value = "phone", required = false) String phone,
//            @RequestParam(value = "email", required = false) String email
//    ) {
//        Integer userId = UserUtil.getUserId();
//        if (userId == null)
//            return gson.toJson(new ResponseJson(ResponseCode.FAIL));
//        userService.change(userId, name, phone, email);
//        return gson.toJson(new ResponseJson(ResponseCode.SUCCESS));
//    }

}
