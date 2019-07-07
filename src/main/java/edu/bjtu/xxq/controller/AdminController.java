package edu.bjtu.xxq.controller;

import com.google.gson.Gson;
import edu.bjtu.xxq.model.Book;
import edu.bjtu.xxq.model.ResponseCode;
import edu.bjtu.xxq.model.ResponseJson;
import edu.bjtu.xxq.service.BookService;
import edu.bjtu.xxq.service.OrderService;
import edu.bjtu.xxq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping("/admin")
@RestController
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    @Autowired
    private OrderService orderService;

    private final Gson gson = new Gson();

    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String queryOrders(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "page", required = false) Integer page
    ) {
        if (StringUtils.hasLength(username))
            return gson.toJson(userService.loadUserByUsername(username));
        if (page != null)
            return gson.toJson(userService.getAllUsers(page - 1));
        return gson.toJson(userService.getAllUsers(0));
    }

    @PostMapping(value = "/book", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String add(
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("author") String author,
            @RequestParam("publisher") String publisher,
            @RequestParam("published") String published,
            @RequestParam("ISBN") String ISBN,
            @RequestParam("price") String price
    ) {
        int id = bookService.addBook(new Book()
                .setName(name)
                .setDescription(description)
                .setAuthor(author)
                .setPublisher(publisher)
                .setPublished(published)
                .setISBN(ISBN)
                .setPrice(price));
        return gson.toJson(new ResponseJson(ResponseCode.ADD_BOOK_SUCCESS, id));
    }

    @PostMapping(value = "/book/tag", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String addTag(
            @RequestParam("bookId") int bookId,
            @RequestParam("tag") String tag
    ) {
        bookService.addTag(bookId, tag);
        return gson.toJson(new ResponseJson(ResponseCode.ADD_TAG_SUCCESS));
    }

    @PostMapping(value = "/book/image", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String addImage(
            @RequestParam("bookId") int bookId,
            @RequestParam("image") MultipartFile image
    ) throws IOException {
        bookService.addBookImage(bookId, image.getBytes());
        return gson.toJson(new ResponseJson(ResponseCode.ADD_TAG_SUCCESS));
    }

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

}
