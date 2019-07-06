package edu.bjtu.xxq.controller;

import com.google.gson.Gson;
import edu.bjtu.xxq.model.Book;
import edu.bjtu.xxq.model.ResponseCode;
import edu.bjtu.xxq.model.ResponseJson;
import edu.bjtu.xxq.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
    public String post(
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


//    /*
//    返回指定tag的图书
//    参数：String tag 图书的标签，path
//    返回：{"message":"register illegal password",
//    "data":[
//    {"bookId":"110001","bookName":"煞笔","bookAuthor":"吃撑","bookPublisher":"阿萨德","bookPublished":"1111-01-01","bookPages":123,"bookISBN":"123123","bookPrice":14}
//    ]
//    }
//     */
//    @RequestMapping(value = "/book/tag/{tag}",method = RequestMethod.GET)
//    public String loadBookByTag(@PathVariable("tag") String tag){
//        return gson.toJson(new ResponseJson(ResponseCode.REGISTER_ILLEGAL_PASSWORD,bookService.loadBookByTag(tag)));
//    }
//    /*
//    根据name返回图书，没有推荐算法，就是个模糊搜索
//    结果：
//    {
//    "message":"register illegal password",
//    "data":[
//        {
//            "bookId":"110003",
//            "bookName":"煞",
//            "bookAuthor":"阿萨德",
//            "bookPublisher":"阿萨德",
//            "bookPublished":"1111-01-01",
//            "bookPages":11,
//            "bookISBN":"12",
//            "bookPrice":1
//        },
//    ]
//}
//     */
//    @RequestMapping(value = "/book/name/{name}",method = RequestMethod.GET)
//    public String loadBookByName(@PathVariable("name") String name){
//        return gson.toJson(new ResponseJson(ResponseCode.REGISTER_ILLEGAL_PASSWORD,bookService.loadBookByName(name)));
//    }
}
