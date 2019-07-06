package edu.bjtu.xxq.controller;

import com.google.gson.Gson;
import edu.bjtu.xxq.model.Book;
import edu.bjtu.xxq.model.ResponseCode;
import edu.bjtu.xxq.model.ResponseJson;
import edu.bjtu.xxq.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping("/book")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    private Gson gson = new Gson();

    @GetMapping(value = "/one", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String query(@RequestParam("id") int id) {
        return gson.toJson(bookService.getOne(id));
    }

    @GetMapping(value = "/batch", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String query(@RequestParam("id") Integer[] id) {
        return gson.toJson(bookService.getList(id));
    }

    @GetMapping(value = "/image", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String image(@RequestParam("id") int id) {
        return gson.toJson(bookService.getBookImages(id));
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
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

    @PostMapping(value = "/tag", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String addTag(
            @RequestParam("bookId") int bookId,
            @RequestParam("tag") String tag
    ) {
        bookService.addTag(bookId, tag);
        return gson.toJson(new ResponseJson(ResponseCode.ADD_TAG_SUCCESS));
    }

    @PostMapping(value = "/image", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String addImage(
            @RequestParam("bookId") int bookId,
            @RequestParam("image") MultipartFile image
    ) throws IOException {
        bookService.addBookImage(bookId, image.getBytes());
        return gson.toJson(new ResponseJson(ResponseCode.ADD_TAG_SUCCESS));
    }

}
