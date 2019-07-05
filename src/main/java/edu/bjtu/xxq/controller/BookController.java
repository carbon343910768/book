package edu.bjtu.xxq.controller;

import com.google.gson.Gson;
import edu.bjtu.xxq.model.ResponseCode;
import edu.bjtu.xxq.model.ResponseJson;
import edu.bjtu.xxq.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Component
public class BookController {
    @Autowired
    private BookService bookService;

    private Gson gson = new Gson();
    /*
    返回全部图书
     */
    @RequestMapping(value = "/book",method = RequestMethod.GET)
    public String getAllBook(){
        return gson.toJson(new ResponseJson(ResponseCode.LOAD_ALL_BOOK_SUCCESS,bookService.getAll()));
    }
    /*
    返回指定tag的图书
     */
    @RequestMapping(value = "/book/tag",method = RequestMethod.GET)
    public String loadBookByTag(@RequestParam("tag") String tag){
        return gson.toJson(new ResponseJson(ResponseCode.REGISTER_ILLEGAL_PASSWORD,bookService.loadBookByTag(tag)));
    }
}
