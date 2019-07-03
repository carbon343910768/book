package com.bjtu.xxq.controller;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private Gson gson = new Gson();

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
//            return gson.toJson(new ResponseJson(ResponseCode.REGISTSUCCESS, user));
//        } else
//            return gson.toJson(new ResponseJson(ResponseCode.REGISTER_ILLEGAL_PASSWORD, user));
//    }
}
