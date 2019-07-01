package com.bjtuxxq.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreController {
    /*
    商店主页
    功能：
     */
    @RequestMapping("/storeHome")
    public void storeHome(){

    }
    /*
    购买页
    功能：
     */
    @RequestMapping("/buyBook")
    public void buyBook(){

    }
    /*
    图书详情页
     */
    @RequestMapping("/book/{bookid}")
    public void book(@PathVariable("bookid") String bookid){

    }
    /*
    书籍分类页面
     */
    @RequestMapping("/buyBook/{bookType}")
    public void bookType(@PathVariable("bookType") String bookType){

    }
}
