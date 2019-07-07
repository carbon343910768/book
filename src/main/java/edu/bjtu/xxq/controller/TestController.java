package edu.bjtu.xxq.controller;

import com.google.gson.Gson;
import edu.bjtu.xxq.model.Book;
import edu.bjtu.xxq.model.Cart;
import edu.bjtu.xxq.model.Image;
import edu.bjtu.xxq.model.Order;
import edu.bjtu.xxq.service.BookService;
import edu.bjtu.xxq.service.CartService;
import edu.bjtu.xxq.service.ImageService;
import edu.bjtu.xxq.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
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

    @RequestMapping("/order")
    public String testOrder() {
        byte[] k ={1,1,1};
        Book book = new Book().setName("asdqwe").setDescription("asdqwe").setAuthor("asdqwe").setPublisher("asdqwe").setPublished("1111-1-1").setISBN("11111").setPrice("11.12");

/*        Order order = new Order().setCustomer(1).setPrice("1").setState(true).setTime("1111-1-1");
        Map<Integer,Integer> books = new HashMap<>();
        books.put(1,1);
        books.put(1,2);
        books.put(2,2);
        return gson.toJson(orderService.addOrder(order,books));*/

        //return gson.toJson(orderService.getOne(1));

/*        Integer[] id = {1,2};
        return gson.toJson(orderService.getList(id));*/

//        return gson.toJson(orderService.getAllBooksInOrder(1));

        return gson.toJson(orderService.getBookNumber(1,1));
    }

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

        return gson.toJson(cartService.getBookNumber(1,111));
    }

    @RequestMapping("/image")
    public String testImage(){
        /*byte[] b = {1,1,1};
        Image image = new Image().setContent(b);
        return gson.toJson(imageService.addImage(image));*/

       return gson.toJson(imageService.getImage(3));
    }

}
