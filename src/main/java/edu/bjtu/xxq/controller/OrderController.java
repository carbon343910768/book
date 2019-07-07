package edu.bjtu.xxq.controller;

import com.google.gson.Gson;
import edu.bjtu.xxq.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
