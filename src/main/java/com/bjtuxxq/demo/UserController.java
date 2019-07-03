package com.bjtuxxq.demo;

import com.bjtuxxq.demo.entity.Book;
import com.bjtuxxq.demo.entity.Entity;
import com.bjtuxxq.demo.entity.RespCode;
import com.bjtuxxq.demo.entity.User;
import com.google.gson.Gson;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.LinkedList;
import java.util.List;


@Controller
public class UserController {
    /*
    登录
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ResponseBody
    public String loginGet(@RequestParam("username") String username,
                           @RequestParam("password") String password){
        User user = new User();
        Gson gson = new Gson();
        if(!StringUtils.isEmpty(username)){
            user.setName(username);
            if ("123456".equals(password)){
                user.setPassword(password);
                return gson.toJson(new Entity(RespCode.LOGINSUCCESS,user));
            }
            return gson.toJson(new Entity(RespCode.LOGINWARN_PASSWORD,user));
        }else
            return gson.toJson(new Entity(RespCode.LOGINWARN_USERNAME_EMPTY,user));
    }
    /*
    注册
     */
    @RequestMapping(value = "/regist")
    @ResponseBody
    public String regist(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         @RequestParam("repassword") String repassword){
        User user = new User();
        Gson gson = new Gson();
        if(!StringUtils.isEmpty(username) && password.equals(repassword)){
            user.setName(username);
            user.setPassword(password);
            return gson.toJson(new Entity(RespCode.REGISTSUCCESS,user));
        }else
            return gson.toJson(new Entity(RespCode.REGISTWARN_PASSWORD,user));
    }
    /*

     */
    @RequestMapping(value = "userOrder")
    @ResponseBody
    public String getOrder(@RequestParam("username") String username){
        Gson gson = new Gson();
        List<Book> books = new LinkedList<Book>();
        Book book = new Book();
        books.add(book);
        return gson.toJson(new Entity(RespCode.REGISTSUCCESS,books));
    }

}
