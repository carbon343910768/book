package edu.bjtu.xxq.controller;

import com.google.gson.Gson;
import edu.bjtu.xxq.model.*;
import edu.bjtu.xxq.service.*;
import edu.bjtu.xxq.util.UserUtil;
import org.omg.CORBA.DATA_CONVERSION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
            @RequestParam("time") String time,
            @RequestParam("address") String address,
            @RequestParam("phone") String phone
    ) {
        Map<Integer, Integer> bookMap
                = IntStream.range(0, bookId.length).boxed()
                .collect(Collectors.toMap(j -> bookId[j], j -> number[j]));

        Order order = new Order()
                .setCustomer(userId)
                .setPhone(phone)
                .setTime(time)
                .setAddress(address)
                .setState(true);
        orderService.addOrder(order, bookMap);
        System.out.println(gson.toJson(order));
        return gson.toJson(new ResponseJson(ResponseCode.ORDER_SUCCESS));
    }

    @Autowired
    private UserService userService;

    @PostMapping(value = "/customer", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String detail(
            @RequestParam("id") Integer id,
            @RequestParam("name") String name,
            @RequestParam("phone") String phone,
            @RequestParam("email") String email
    ) {
        userService.change(id, name, phone, email);
        return gson.toJson(new ResponseJson(ResponseCode.SUCCESS));
    }

}
