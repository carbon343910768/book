package com.bjtuxxq.demo.controller;

import com.bjtuxxq.demo.model.ResponseJson;
import com.bjtuxxq.demo.model.RespCode;
import com.bjtuxxq.demo.model.User;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    private Gson gson = new Gson();

//    @PostMapping(value = "/login")
//    @ResponseBody
//    public String loginGet(
//            @RequestParam("username") String username,
//            @RequestParam("password") String password
//    ) {
//        User user = new User();
//        if (!StringUtils.isEmpty(username)) {
//            user.setName(username);
//            if ("123456".equals(password)) {
//                user.setPassword(password);
//                return gson.toJson(new ResponseJson(RespCode.LOGINSUCCESS, user));
//            }
//            return gson.toJson(new ResponseJson(RespCode.LOGINWARN_PASSWORD, user));
//        } else
//            return gson.toJson(new ResponseJson(RespCode.LOGINWARN_USERNAME_EMPTY, user));
//    }

//    @PostMapping(value = "/register")
//    @ResponseBody
//    public String register(
//            @RequestParam("username") String username,
//            @RequestParam("password") String password
//    ) {
//        User user = new User();
//        if (!StringUtils.isEmpty(username) && password.equals(repassword)) {
//            user.setName(username);
//            user.setPassword(password);
//            return gson.toJson(new ResponseJson(RespCode.REGISTSUCCESS, user));
//        } else
//            return gson.toJson(new ResponseJson(RespCode.REGISTWARN_PASSWORD, user));
//    }
}
