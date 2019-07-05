package edu.bjtu.xxq.controller;

import com.google.gson.Gson;
import edu.bjtu.xxq.model.ResponseCode;
import edu.bjtu.xxq.model.ResponseJson;
import edu.bjtu.xxq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private Gson gson = new Gson();

    @PostMapping(value = "/register", produces = "application/json;charset=UTF-8")
    public String register(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ) {
        if (!verifyUsername(username))
            return gson.toJson(new ResponseJson(ResponseCode.REGISTER_ILLEGAL_USERNAME, username));
        if (!verifyPassword(password))
            return gson.toJson(new ResponseJson(ResponseCode.REGISTER_ILLEGAL_PASSWORD, password));
        if (userService.loadUserByUsername(username) != null)
            return gson.toJson(new ResponseJson(ResponseCode.REGISTER_EXISTED_USERNAME, username));
        if (userService.addUser(username, password))
            return gson.toJson(new ResponseJson(ResponseCode.REGISTER_SUCCESS));
        else
            return gson.toJson(new ResponseJson(ResponseCode.REGISTER_FAIL));
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
