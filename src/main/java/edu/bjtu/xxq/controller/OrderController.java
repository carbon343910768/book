package edu.bjtu.xxq.controller;

import com.google.gson.Gson;
import edu.bjtu.xxq.model.Book;
import edu.bjtu.xxq.model.Order;
import edu.bjtu.xxq.model.ResponseCode;
import edu.bjtu.xxq.model.ResponseJson;
import edu.bjtu.xxq.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class OrderController {
    @Autowired
    private OrderService orderService;

    private Gson gson  = new Gson();
    /*
    添加订单
    请求格式：
    {"orderOwner":"","book":[{"bookid":"110001"},{"bookid":"110002"}]}
     */
    @RequestMapping(value = "/addOrder.go",method = RequestMethod.POST)
    @ResponseBody
    public String addOrder(@RequestBody String json){
        Order order = new Order();
        order = gson.fromJson(json, Order.class);
        orderService.addOrder(order);
        return gson.toJson(new ResponseJson(ResponseCode.ADD_ORDER_SUCCESS));
    }

    /*
    请求用户订单
     */
    @RequestMapping(value = "/loadOrderById",method = RequestMethod.GET)
    public String loadOrderById(@RequestParam("id") String id){
        return gson.toJson(new ResponseJson(ResponseCode.LOAD_ALL_ORDER_SUCCESS,orderService.orderList(id)));
    }

    /*
    请求订单内容
     */
    @RequestMapping(value = "/loadOrder",method = RequestMethod.GET)
    public String loadOrder(@RequestParam("orderId") String orderId){
        return gson.toJson(new ResponseJson(ResponseCode.LOAD_ORDER_SUCCESS,orderService.getOrder(orderId)));
    }
}
