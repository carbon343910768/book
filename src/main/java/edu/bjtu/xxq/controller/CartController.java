package edu.bjtu.xxq.controller;

import com.google.gson.Gson;
import edu.bjtu.xxq.model.Cart;
import edu.bjtu.xxq.model.ResponseCode;
import edu.bjtu.xxq.model.ResponseJson;
import edu.bjtu.xxq.service.CartService;
import edu.bjtu.xxq.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cart")
@RestController
public class CartController {

    @Autowired
    private CartService cartService;
    private final Gson gson = new Gson();

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String add(
            @RequestParam("address") String address,
            @RequestParam("phone") String phone
    ) {
        if (StringUtils.isEmpty(address))
            return gson.toJson(new ResponseJson(ResponseCode.ADD_CART_FAIL));
        Integer userId = UserUtil.getUserId();
        if (userId == null)
            return gson.toJson(new ResponseJson(ResponseCode.ADD_CART_FAIL));
        int id = cartService.addCart(new Cart()
                .setOwner(userId)
                .setAddress(address)
                .setPhone(phone)
        );
        return gson.toJson(new ResponseJson(ResponseCode.ADD_CART_SUCCESS, id));
    }

    @PostMapping(value = "/book", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String addBook(
            @RequestParam("bookId") int bookId,
            @RequestParam("number") int number
    ) {
        Integer userId = UserUtil.getUserId();
        //TODO 这里的2不要忘了改成userid
        cartService.addBook(2,bookId,number);
        return gson.toJson(new ResponseJson(ResponseCode.ADD_TO_CART_SUCCESS));
    }

    @GetMapping(value = "/book", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getBookId(){
        Integer userId = UserUtil.getUserId();
        //TODO 这里的2不要忘了改成userid
        return gson.toJson(cartService.getAllBooksInCart(2));
    }
}
