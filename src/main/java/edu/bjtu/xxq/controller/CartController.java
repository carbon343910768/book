package edu.bjtu.xxq.controller;

import edu.bjtu.xxq.model.ResponseCode;
import edu.bjtu.xxq.model.ResponseJson;
import edu.bjtu.xxq.model.Cart;
import com.google.gson.Gson;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
public class CartController {

    private List<Cart> sclist = new LinkedList<Cart>();//购物车列表
    private List<Cart> buylist = new LinkedList<Cart>();//选择购买列表
    private Map<Cart,Cart> map = new HashMap<Cart, Cart>();
    private  Gson gson = new Gson();

    private Boolean checkList(List<Cart> list){
        for (Cart sctr : list){//重复检验
            if (map.containsKey(sctr))
                map.put(sctr, Cart.merge(sctr,map.get(sctr)));
            else
                map.put(sctr,sctr);
        }
        sclist.clear();
        for(Map.Entry<Cart,Cart> TEMP :map.entrySet())
            list.add(TEMP.getValue());
        map.clear();
        return true;
    }
    /*
    修改购物车商品
    输入：{"bookId":"123","price":"123","num":"3"} or {"bookId":"123","price":"123","num":"-2"}
    返回：{"message":"add to cart success","data":[{"bookId":"123","price":123,"num":27}]}
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public String add(@RequestBody String addBook){
        if (!StringUtils.isEmpty(addBook)){
            Cart sc = gson.fromJson(addBook,Cart.class);
            sclist.add(sc);
            if (checkList(sclist))
                return gson.toJson(new ResponseJson(ResponseCode.ADD_TO_CART_SUCCESS,sclist));
            else
                return gson.toJson(new ResponseJson(ResponseCode.ADD_TO_CART_FAIL,sclist));
        }else
            return gson.toJson(new ResponseJson(ResponseCode.ADD_TO_CART_FAIL,sclist));
    }
   /*
   返回购物车内容
   返回：{"message":"add to cart success","data":[{"bookId":"123","price":123,"num":33}]}
    */
    @RequestMapping(value = "/cart",method = RequestMethod.GET)
    @ResponseBody
    public String getCart(){
        return gson.toJson(new ResponseJson(ResponseCode.ADD_TO_CART_SUCCESS,sclist));
    }

    /*
    选择购买的商品
    输入：{"bookId":"123","price":"123","num":"3"} or {"bookId":"123","price":"123","num":"-2"}
    返回：{"message":"add to cart success","data":[{"bookId":"123","price":123,"num":27}]}
     */
    @RequestMapping(value = "/buy",method = RequestMethod.POST)
    @ResponseBody
    public String addBuy(@RequestBody String buyBook){
        if(!StringUtils.isEmpty(buyBook)){
            Cart sc = gson.fromJson(buyBook,Cart.class);
            buylist.add(sc);
            if(checkList(buylist))
                return gson.toJson(new ResponseJson(ResponseCode.ORDER_SUCCESS,buylist));
            else
                return gson.toJson(new ResponseJson(ResponseCode.ORDER_FAIL,buylist));
        }else
            return gson.toJson(new ResponseJson(ResponseCode.ORDER_FAIL,buylist));
    }
}
