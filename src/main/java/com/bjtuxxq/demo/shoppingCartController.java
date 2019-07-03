package com.bjtuxxq.demo;

import com.bjtuxxq.demo.entity.Entity;
import com.bjtuxxq.demo.entity.RespCode;
import com.bjtuxxq.demo.entity.ShoppingCart;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
public class shoppingCartController {
    private List<ShoppingCart> sclist = new LinkedList<ShoppingCart>();
    private List<ShoppingCart> buylist = new LinkedList<ShoppingCart>();
    /*
    修改购物车商品
    返回：购物车修改后内容
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    @ResponseBody
    public String add(@RequestParam("bookId") String bookId,
                      @RequestParam("num") int num){
        Gson gson = new Gson();
        Map<ShoppingCart,ShoppingCart> map = new HashMap<ShoppingCart, ShoppingCart>();
        if (!StringUtils.isEmpty(bookId)){
            int bookPrice = 100;
            ShoppingCart sc = new ShoppingCart();
            sc.setBookid(bookId);
            sc.setPrice(bookPrice);
            sc.setNum(num);
            sclist.add(sc);
            for (ShoppingCart sctr : sclist){
                if (map.containsKey(sctr))
                    map.put(sctr,ShoppingCart.merge(sctr,map.get(sctr)));
                else
                    map.put(sctr,sctr);
            }
            sclist.clear();
            for(Map.Entry<ShoppingCart,ShoppingCart> TEMP :map.entrySet())
                sclist.add(TEMP.getValue());
            return gson.toJson(new Entity(RespCode.SHOPPINGCART_ADD_SUCCESS,sclist));
        }else
            return gson.toJson(new Entity(RespCode.SHOPPINGCART_ADD_WARN,sclist));
    }

   /*
   返回购物车内容
    */
    @RequestMapping(value = "/cart",method = RequestMethod.GET)
    @ResponseBody
    public String getCart(){
        Gson gson = new Gson();
        return gson.toJson(new Entity(RespCode.SHOPPINGCART_ADD_SUCCESS,sclist));
    }

    @RequestMapping(value = "/price",method = RequestMethod.GET)
    @ResponseBody
    public String getprice(){
        Gson gson = new Gson();
        return gson.toJson(new Entity(RespCode.SHOPPINGCART_ADD_SUCCESS,sclist));
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
            ShoppingCart sc = new ShoppingCart();
            sc.setBookid(bookId);
            sc.setPrice(bookPrice);
            sc.setNum(num);
            buylist.add(sc);
            return gson.toJson(new Entity(RespCode.BUYCART_SUCCESS,buylist));
        }else
            return gson.toJson(new Entity(RespCode.BUYCART_WARN,buylist));
    }
}
