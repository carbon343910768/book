package com.bjtuxxq.demo.controller;

import com.bjtuxxq.demo.model.ResponseCode;
import com.bjtuxxq.demo.model.ResponseJson;
import com.bjtuxxq.demo.model.Store;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreController {
    /*
    我的商店
     */
    @RequestMapping("/myStore")
    public String myStore(@RequestParam("username") String username){
        Gson gson = new Gson();
        Store s = new Store();

        return gson.toJson(new ResponseJson(ResponseCode.REGISTER_ILLEGAL_PASSWORD,s));

    }

}
