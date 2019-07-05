package edu.bjtu.xxq.controller;

import com.google.gson.Gson;
import edu.bjtu.xxq.model.Order;
import edu.bjtu.xxq.model.ResponseCode;
import edu.bjtu.xxq.model.ResponseJson;
import edu.bjtu.xxq.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    private Gson gson  = new Gson();
    /*
    添加订单
    请求格式：
    {"orderOwner":"","book":[{"bookid":"110001"},{"bookid":"110002"}]}
     */
    @RequestMapping(value = "/addOrder",method = RequestMethod.POST)
    @ResponseBody
    public String addOrder(@RequestBody String json){
        Order order = gson.fromJson(json, Order.class);
        orderService.addOrder(order);
        return gson.toJson(new ResponseJson(ResponseCode.ADD_ORDER_SUCCESS));
    }

    /*
    请求用户订单
    {
    "message":"loda all order success",
    "data":[
        {
            "orderId":"150001",
            "orderOwner":"1",
            "orderTime":"Jan 1, 1111 8:00:00 AM",
            "book":[
                {
                    "bookId":"110001",
                    "bookName":"煞笔",
                    "bookAuthor":"阿萨德",
                    "bookPublisher":"阿萨德",
                    "bookPublished":"1111-01-01",
                    "bookPages":123,
                    "bookISBN":"123123",
                    "bookPrice":14
                },
                {
                    "bookId":"110002",
                    "bookName":"阿斯顿",
                    "bookAuthor":"爱仕达",
                    "bookPublisher":"爱仕达",
                    "bookPublished":"1111-01-01",
                    "bookPages":1,
                    "bookISBN":"1",
                    "bookPrice":1
                }
            ]
        }
    ]
}
     */
    @RequestMapping(value = "/loadOrderById",method = RequestMethod.GET)
    public String loadOrderById(@RequestParam("id") String id){
        return gson.toJson(new ResponseJson(ResponseCode.LOAD_ALL_ORDER_SUCCESS,orderService.orderList(id)));
    }

    /*
    请求订单内容
    {
    "message":"loda order success",
    "data":{
        "orderId":"150001",
        "orderOwner":"1",
        "orderTime":"Jan 1, 1111 8:00:00 AM",
        "book":[
            {
                "bookId":"110001",
                "bookName":"煞笔",
                "bookAuthor":"阿萨德",
                "bookPublisher":"阿萨德",
                "bookPublished":"1111-01-01",
                "bookPages":123,
                "bookISBN":"123123",
                "bookPrice":14
            },
            {
                "bookId":"110002",
                "bookName":"阿斯顿",
                "bookAuthor":"爱仕达",
                "bookPublisher":"爱仕达",
                "bookPublished":"1111-01-01",
                "bookPages":1,
                "bookISBN":"1",
                "bookPrice":1
            }
        ]
    }
}
    */
    @RequestMapping(value = "/loadOrder",method = RequestMethod.GET)
    public String loadOrder(@RequestParam("orderId") String orderId){
        return gson.toJson(new ResponseJson(ResponseCode.LOAD_ORDER_SUCCESS,orderService.getOrder(orderId)));
    }
}
