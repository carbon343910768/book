package edu.bjtu.xxq.controller;

import com.google.gson.Gson;
import edu.bjtu.xxq.model.ResponseCode;
import edu.bjtu.xxq.model.ResponseJson;
import edu.bjtu.xxq.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    private Gson gson = new Gson();

    @GetMapping(value = "/book", produces = "application/json;charset=UTF-8")
    public String getOne(@RequestParam("id") int id) {
        return null;
    }

    /*
    返回全部图书
    参数：null
    返回：{"message":"load all book success",
    "data":[
    {"bookId":"110001","bookName":"煞笔","bookAuthor":"吃撑","bookPublisher":"阿萨德","bookPublished":"1111-01-01","bookPages":123,"bookISBN":"123123","bookPrice":14},
    {"bookId":"110002","bookName":"阿斯顿","bookAuthor":"爱仕达","bookPublisher":"爱仕达","bookPublished":"1111-01-01","bookPages":1,"bookISBN":"1","bookPrice":1}
    ]
    }
     */
//    @RequestMapping(value = "/book", method = RequestMethod.GET)
//    public String getAllBook() {
//        return gson.toJson(new ResponseJson(ResponseCode.LOAD_ALL_BOOK_SUCCESS, bookService.getAll()));
//    }

    /*
    返回指定tag的图书
    参数：String tag 图书的标签
    返回：{"message":"register illegal password",
    "data":[
    {"bookId":"110001","bookName":"煞笔","bookAuthor":"吃撑","bookPublisher":"阿萨德","bookPublished":"1111-01-01","bookPages":123,"bookISBN":"123123","bookPrice":14}
    ]
    }
     */
//    @RequestMapping(value = "/book/{tag}", method = RequestMethod.GET)
//    public String loadBookByTag(@PathVariable("tag") String tag) {
//        return gson.toJson(new ResponseJson(ResponseCode.REGISTER_ILLEGAL_PASSWORD, bookService.loadBookByTag(tag)));
//    }
}
