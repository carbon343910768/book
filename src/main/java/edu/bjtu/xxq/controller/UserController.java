package edu.bjtu.xxq.controller;

import com.google.gson.Gson;
import edu.bjtu.xxq.model.ResponseCode;
import edu.bjtu.xxq.model.ResponseJson;
import edu.bjtu.xxq.model.User;
import edu.bjtu.xxq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Scanner;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    private Gson gson = new Gson();

    @PostMapping(value = "/register")
    @ResponseBody
    public String register(
            @RequestParam() User user
//            @RequestParam("username") String username,
//            @RequestParam("password") String password
    ) {
        ResponseCode response;
        if (!verifyUsername(user.getUsername()))
            response = ResponseCode.REGISTER_ILLEGAL_USERNAME;
        else if (!verifyPassword(user.getPassword()))
            response = ResponseCode.REGISTER_ILLEGAL_PASSWORD;
        else if (userService.loadUserByUsername(user.getUsername()) != null)
            response = ResponseCode.REGISTER_EXISTED_USERNAME;
        else if(userService.addUser(user))
            response = ResponseCode.REGISTER_SUCCESS;
        else
            response = ResponseCode.REGISTER_FAIL;
        return gson.toJson(new ResponseJson(response, user));
    }

    private static final int USERNAME_MIN_LENGTH = 2;
    private static final int USERNAME_MAX_LENGTH = 40;
    private static final int PASSWORD_MIN_LENGTH = 6;
    private static final int PASSWORD_MAX_LENGTH = 20;

    private static boolean verifyUsername(String username) {
        if (!StringUtils.hasLength(username)) return false;
        if (username.length() < USERNAME_MIN_LENGTH) return false;
        if (username.length() > USERNAME_MAX_LENGTH) return false;
        for (char c : username.toCharArray())
            if (!Character.isUnicodeIdentifierPart(c))
                return false;
        return true;
    }

    private static boolean verifyPassword(String password) {
        if (!StringUtils.hasLength(password)) return false;
        if (password.length() < PASSWORD_MIN_LENGTH) return false;
        if (password.length() > PASSWORD_MAX_LENGTH) return false;
        for (char c : password.toCharArray())
            if (!Character.isLetterOrDigit(c))
                return false;
        return true;
    }
}
