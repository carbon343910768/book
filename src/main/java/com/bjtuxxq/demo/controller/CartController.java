package com.bjtuxxq.demo.controller;

import com.bjtuxxq.demo.model.ResponseCode;
import com.bjtuxxq.demo.model.ResponseJson;
import com.bjtuxxq.demo.model.Cart;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
public class CartController {
    private List<Cart> sclist = new LinkedList<Cart>();
    private List<Cart> buylist = new LinkedList<Cart>();
    /*
    修改购物车商品
    返回：购物车修改后内容
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    @ResponseBody
    public String add(@RequestParam("bookId") String bookId,
                      @RequestParam("num") int num){
        Gson gson = new Gson();
        Map<Cart,Cart> map = new HashMap<Cart, Cart>();
        if (!StringUtils.isEmpty(bookId)){
            int bookPrice = 100;
            Cart sc = new Cart();
            sc.setBookId(bookId);
            sc.setPrice(bookPrice);
            sc.setNum(num);
            sclist.add(sc);
            for (Cart sctr : sclist){
                if (map.containsKey(sctr))
                    map.put(sctr, Cart.merge(sctr,map.get(sctr)));
                else
                    map.put(sctr,sctr);
            }
            sclist.clear();
            for(Map.Entry<Cart,Cart> TEMP :map.entrySet())
                sclist.add(TEMP.getValue());
            return gson.toJson(new ResponseJson(ResponseCode.ADD_TO_CART_SUCCESS,sclist));
        }else
            return gson.toJson(new ResponseJson(ResponseCode.ADD_TO_CART_FAIL,sclist));
    }

   /*
   返回购物车内容
    */
    @RequestMapping(value = "/cart",method = RequestMethod.GET)
    @ResponseBody
    public String getCart(){
        Gson gson = new Gson();
        return gson.toJson(new ResponseJson(ResponseCode.ADD_TO_CART_SUCCESS,sclist));
    }

    @RequestMapping(value = "/price",method = RequestMethod.GET)
    @ResponseBody
    public String getprice(){
        Gson gson = new Gson();
        return gson.toJson(new ResponseJson(ResponseCode.ADD_TO_CART_SUCCESS,sclist));
    }
    /*
    选择购买的商品
     */
    @RequestMapping(value = "/buy")
    @ResponseBody
    public String addBuy(@RequestParam("bookId") String bookId,
                         @RequestParam("num") int num){
        Gson gson = new Gson();
        if(!StringUtils.isEmpty(bookId)){
            int bookPrice = 100;
            Cart sc = new Cart();
            sc.setBookId(bookId);
            sc.setPrice(bookPrice);
            sc.setNum(num);
            buylist.add(sc);
            return gson.toJson(new ResponseJson(ResponseCode.ORDER_SUCCESS,buylist));
        }else
            return gson.toJson(new ResponseJson(ResponseCode.ORDER_FAIL,buylist));
    }
}
