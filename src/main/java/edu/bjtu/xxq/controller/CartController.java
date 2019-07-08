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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
            @RequestParam("cartId") int cartId,
            @RequestParam("bookId") int bookId,
            @RequestParam("number") int number
    ) {
        cartService.addBook(cartId,bookId,number);
        return gson.toJson(new ResponseJson(ResponseCode.ADD_TO_CART_SUCCESS));
    }
}
