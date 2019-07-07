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
        if (!StringUtils.isEmpty(address))
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
        return gson.toJson(new ResponseJson(ResponseCode.ADD_TO_CART_SUCCESS));
    }
//   /*
//   返回购物车内容
//   返回：{"message":"add to cart success","data":[{"bookId":"123","price":123,"num":33}]}
//    */
//    @RequestMapping(value = "/cart",method = RequestMethod.GET)
//    @ResponseBody
//    public String getCart(){
//        return gson.toJson(new ResponseJson(ResponseCode.ADD_TO_CART_SUCCESS,sclist));
//    }
//
//    /*
//    选择购买的商品
//    输入：{"bookId":"123","price":"123","num":"3"} or {"bookId":"123","price":"123","num":"-2"}
//    返回：{"message":"add to cart success","data":[{"bookId":"123","price":123,"num":27}]}
//     */
//    @RequestMapping(value = "/buy",method = RequestMethod.POST)
//    @ResponseBody
//    public String addBuy(@RequestBody String buyBook){
//        if(!StringUtils.isEmpty(buyBook)){
//            Cart sc = gson.fromJson(buyBook,Cart.class);
//            buylist.add(sc);
//            if(checkList(buylist))
//                return gson.toJson(new ResponseJson(ResponseCode.ORDER_SUCCESS,buylist));
//            else
//                return gson.toJson(new ResponseJson(ResponseCode.ORDER_FAIL,buylist));
//        }else
//            return gson.toJson(new ResponseJson(ResponseCode.ORDER_FAIL,buylist));
//    }
}
