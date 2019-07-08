package edu.bjtu.xxq.controller;

import com.google.gson.Gson;
import edu.bjtu.xxq.model.Order;
import edu.bjtu.xxq.model.ResponseCode;
import edu.bjtu.xxq.model.ResponseJson;
import edu.bjtu.xxq.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    private Gson gson = new Gson();

    @GetMapping(value = "/one", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String query(@RequestParam("id") int id) {
        return gson.toJson(orderService.getOne(id));
    }

    @GetMapping(value = "/batch", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String query(@RequestParam("id") Integer[] id) {
        return gson.toJson(orderService.getList(id));
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String add(
            @RequestParam("bookId") Integer[] bookId,
            @RequestParam("number") Integer[] number,
            @RequestParam(value = "cartId", required = false) int cartId,
            @RequestParam(value = "address", required = false) String address,
            @RequestParam(value = "phone", required = false) String phone
    ) {
        //TODO 这里参数设计的很奇怪，先按你的参数实现了一下
        Map<Integer,Integer> bookMap = IntStream.range(0, bookId.length).boxed().collect(Collectors.toMap(j -> bookId[j], j -> number[j]));
        Order order = new Order().setAddress(address).setPhone(phone);
        orderService.addOrder(order,bookMap);
        return gson.toJson(new ResponseJson(ResponseCode.ADD_TO_CART_SUCCESS));
    }
//    /*
//    添加订单
//    请求格式：
//    {"orderOwner":"","book":[{"bookid":"110001"},{"bookid":"110002"}]}
//     */
//    @RequestMapping(value = "/addOrder",method = RequestMethod.POST)
//    @ResponseBody
//    public String addOrder(@RequestBody String json){
//        Order order = gson.fromJson(json, Order.class);
//        orderService.addOrder(order);
//        return gson.toJson(new ResponseJson(ResponseCode.ADD_ORDER_SUCCESS));
//    }
//
//    /*
//    请求订单
//    请求：methods：查询的方式: user用户id查询，id订单id查询
//          term：查询条件
//    返回
//    {
//    "message":"loda all order success",
//    "data":[
//        {
//            "orderId":"150001",
//            "orderOwner":"1",
//            "orderTime":"Jan 1, 1111 8:00:00 AM",
//            "book":[
//                {
//                    "bookId":"110001",
//                    "bookName":"煞笔",
//                    "bookAuthor":"阿萨德",
//                    "bookPublisher":"阿萨德",
//                    "bookPublished":"1111-01-01",
//                    "bookPages":123,
//                    "bookISBN":"123123",
//                    "bookPrice":14
//                }
//            ]
//        }
//    ]
//}
//     */
//    @RequestMapping(value = "/loadOrder",method = RequestMethod.GET)
//    public String loadOrder(@RequestParam("methods") String methods ,@RequestParam("term") String term){
//        switch (methods){
//            case "id":
//                return gson.toJson(new ResponseJson(ResponseCode.LOAD_ORDER_SUCCESS,orderService.orderList("order_id",term)));
//            case "user":
//                return gson.toJson(new ResponseJson(ResponseCode.LOAD_ORDER_SUCCESS,orderService.orderList("user_id",term)));
//            default:
//                return gson.toJson(new ResponseJson(ResponseCode.LOAD_ORDER_WARN));
//        }
//    }
//
//    @RequestMapping(value = "/loadOrderByTime",method = RequestMethod.GET)
//    public String loadOrderByTime(@RequestParam("methods") String methods ,@RequestParam("time") String time){
//        switch (methods){
//            case "day":
//                return gson.toJson(new ResponseJson(ResponseCode.LOAD_ORDER_SUCCESS,orderService.orderListByTime("'%Y-%m-%d'",time)));
//            case "mouth":
//                return gson.toJson(new ResponseJson(ResponseCode.LOAD_ORDER_SUCCESS,orderService.orderListByTime("'%Y-%m'",time)));
//            case "year":
//                return gson.toJson(new ResponseJson(ResponseCode.LOAD_ORDER_SUCCESS,orderService.orderListByTime("'%Y'",time)));
//            default:
//                return gson.toJson(new ResponseJson(ResponseCode.LOAD_ORDER_WARN));
//        }
//    }
}
