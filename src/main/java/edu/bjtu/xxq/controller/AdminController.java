package edu.bjtu.xxq.controller;

import com.google.gson.Gson;
import edu.bjtu.xxq.model.*;
import edu.bjtu.xxq.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping("/admin")
@RestController
public class AdminController {

    private final Gson gson = new Gson();

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String queryOrder(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "page", required = false) Integer page
    ) {
        if (id != null)
            return gson.toJson(userService.getUserById(id));
        if (StringUtils.hasLength(username))
            return gson.toJson(userService.loadUserByUsername(username));
        if (page == null) page = 0;
        else page--;
        return gson.toJson(userService.getAllUsers(page));
    }

    @Autowired
    private BookService bookService;

    @PostMapping(value = "/book", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String addBook(
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

    @GetMapping(value = "/book", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getBook(@RequestParam(value = "bookId", required = false) Integer bookId,
                          @RequestParam(value = "tag", required = false) String tag,
                          @RequestParam(value = "page", required = false) Integer page) {
        if (bookId != null)
            return gson.toJson(bookService.getOne(bookId));
        if (page == null) page = 0;
        else page--;
        if (tag != null)
            return gson.toJson(bookService.getList(bookService.getBooksByTag(tag, page, 10).toArray(new Integer[0])));
        return "";
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

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/order", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String queryOrder(
            @RequestParam(value = "orderId", required = false) Integer orderId,
            @RequestParam(value = "userId", required = false) Integer userId,
            @RequestParam(value = "from", required = false) String from,
            @RequestParam(value = "to", required = false) String to,
            @RequestParam(value = "page", required = false) Integer page
    ) {
        if (orderId != null)
            return gson.toJson(orderService.getOne(orderId));
        if (page == null) page = 0;
        else page--;
        if (userId != null) {
            return gson.toJson(orderService.getList(orderService.getByUser(userId, page).toArray(new Integer[0])));
        }
        if (StringUtils.hasLength(from)) {
            if (StringUtils.hasLength(to))
                return gson.toJson(orderService.getList(orderService.getBetweenDate(from, to, page).toArray(new Integer[0])));
            return gson.toJson(orderService.getList(orderService.getByDate(from, page).toArray(new Integer[0])));
        }
        if (StringUtils.hasLength(to))
            return gson.toJson(orderService.getList(orderService.getByDate(to, page).toArray(new Integer[0])));
        return gson.toJson(orderService.getAll(page));
    }

    @Autowired
    private SupplyService supplyService;

    @GetMapping(value = "/supplier", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String querySupplier(
            @RequestParam(value = "registerNo", required = false) String registerNo,
            @RequestParam(value = "company", required = false) String company,
            @RequestParam(value = "page", required = false) Integer page
    ) {
        if (StringUtils.hasLength(registerNo))
            return gson.toJson(supplyService.getSupplierByNo(registerNo));
        if (StringUtils.hasLength(company))
            return gson.toJson(supplyService.getSupplierByCompany(company));
        if (page == null) page = 0;
        else page--;
        return gson.toJson(supplyService.getAllSuppliers());
    }

    @PostMapping(value = "/supplier", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String addSupplier(
            @RequestParam("registerNo") String registerNo,
            @RequestParam("company") String company,
            @RequestParam("phone") String phone,
            @RequestParam("email") String email
    ) {
        supplyService.addSupplier(new Supplier()
                .setRegisterNo(registerNo)
                .setCompany(company)
                .setPhone(phone)
                .setEmail(email)
        );
        return gson.toJson(new ResponseJson(ResponseCode.SUCCESS));
    }

    @GetMapping(value = "/supply", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String querySupply(
            @RequestParam(value = "supplyId", required = false) Integer supplyId,
            @RequestParam(value = "from", required = false) String from,
            @RequestParam(value = "to", required = false) String to,
            @RequestParam(value = "page", required = false) Integer page
    ) {
        if (supplyId != null)
            return gson.toJson(supplyService.getSupplyById(supplyId));
        if (page == null) page = 0;
        else page--;
        if (StringUtils.hasLength(from)) {
            if (StringUtils.hasLength(to))
                return gson.toJson(supplyService.getSupplyBetweenDate(from, to));
            return gson.toJson(supplyService.getSupplyByDate(from));
        }
        if (StringUtils.hasLength(to))
            return gson.toJson(supplyService.getSupplyByDate(to));
        return gson.toJson(supplyService.getAllSuppliers());
    }

    @PostMapping(value = "/supply", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String add(
            @RequestParam("company") String company,
            @RequestParam("address") String address,
            @RequestParam("bookId") Integer[] bookId,
            @RequestParam("number") Integer[] number
    ) {
        supplyService.addSupply(new Supply()
                .setCompany(company)
                .setAddress(address)
                .setBookId(bookId)
                .setNumber(number)
        );
        return gson.toJson(new ResponseJson(ResponseCode.SUCCESS));
    }

    @Autowired
    private ReportService reportService;

    @GetMapping(value = "/report", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String queryReport(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "from", required = false) String from,
            @RequestParam(value = "to", required = false) String to
    ) {
        if (StringUtils.hasLength(name))
            return gson.toJson(reportService.getOne(name));
        if (StringUtils.hasLength(from) && StringUtils.hasLength(to))
            return gson.toJson(reportService.getBetweenDate(from, to));
        return gson.toJson(null);
    }
}
